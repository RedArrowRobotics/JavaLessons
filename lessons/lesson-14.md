# Lesson 14: Lambdas

Imagine we have a function called `runIf` that should run an action only if the robot is in a certain state. 

```Java
public class Main {
    static void runIf(String robotState) {
        if (robotState.equals("TELEOP")) {
            System.out.println("Action ran");
        }
    }

    public static void main(String[] args) {
        runIf("TELEOP");
    }
}
```

This is nice, but what if we want to do a different action? We could make a _new_ `runIf` function for the new action, but
then we might need to create _many_ `runIf` functions, with one for each action we might want to run.

One way we could make this better is by using interfaces again. We can make a `RobotAction` interface:

```Java
interface RobotAction {
    void run();
}

class PrintAction implements RobotAction {
    @Override
    public void run() {
        System.out.println("Action ran");
    }
}

public class Main {
    static void runIf(String robotState, RobotAction action) {
        if (robotState.equals("TELEOP")) {
            action.run();
        }
    }

    public static void main(String[] args) {
        runIf("TELEOP", new PrintAction());
    }
}
```

This works much better, but for doing simple things it can feel like you have to do a lot. We only want to do a simple 
`println`, but we have to make a `PrintAction` class, have it implement `RobotAction`, override the `run` function, and then
_finally_ we have the part that we actually care about - the `println`. Doing this too much can also be hard to read because 
the main idea is split across multiple classes.

A *lambda* is an alternative way to do the same thing, that is more compact.
It can be used anywhere where Java expects an interface with exactly one required method. These are sometimes referred to as a
SAM (single abstract method [^1]) interface.

[^1]: _abstract method_ means that there is no function body associated with the method. This is exactly what an interface provides.

In our example, `RobotAction` has one required function: `run()`. When Java sees a lambda instead of a class that implements 
a SAM interface, it treats the lambda as the code for that interface's method. Let's look at an example:

```Java
    public static void main(String[] args) {
        runIf("TELEOP", new PrintAction());
        runIf("TELEOP", () -> System.out.println("A different action ran")); // we can create a new action right here, without making 'DifferentPrintAction' class
    }
```

Java interprets: `() -> System.out.println("A different action ran")` as a `RobotAction`

Now that we have a cleaner way to write code like this, we might add an additional interface for the condition:

```Java
interface Condition {
    boolean test(String robotState);
}

interface RobotAction {
    void run();
}

public class Main {
    static void runIf(String robotState, Condition condition, RobotAction action) {
        if (condition.test(robotState)) {
            action.run();
        }
    }

    public static void main(String[] args) {
        runIf(
            "TELEOP", // In real code, this wouldn't be just a string - we'd get it from somewhere that could update it as the robot's state changes
            (state) -> state.equals("TELEOP"),
            () -> System.out.println("Action ran")
        );
    }
}
```
For the new 'condition' lambda, we can see how to write a lambda that takes a parameter; in this case, `state`. We can see from the
interface that the `test` method takes a `String` as a parameter, so we know that will be the type of the `state` parameter. We can also
see that the `test` function returns a `boolean`, so our lambda also needs to return a boolean - in this case the `.equals` 
function does exactly that.


### Method References

A method reference is shorter syntax for "use this existing method as the function."

```Java
class Helper {
    void printReady() {
        System.out.println("Ready");
    }
}

Helper helper = new Helper();
RobotAction r1 = () -> helper.printReady();
RobotAction r2 = helper::printReady; // this is the same as r1, just a different (shorter) way of writing it.

r1.run();
r2.run();
```

What `helper::printReady` means:
* left side (`helper`) = which object
* right side (`printReady`) = which function on that object

So `helper::printReady` is the same behavior as `() -> helper.printReady()`.


### Passing a Function vs Running It

This is a very important distinction:
* passing a function means giving `runIf` behavior to run later
* running a function means it executes right now

Correct (passes behavior):

```Java
RobotAction action = () -> System.out.println("Action ran");
runIf("DISABLED", (state) -> state.equals("TELEOP"), action::run);
// Nothing prints, because condition is false - the runIf function can _choose_ whether the action's 'run' function is called
```

Incorrect (passes result of running a function):

```Java
RobotAction action = () -> System.out.println("Action ran");
// This doesn't compile, because we're trying to pass in the _result_ of running the `run` function, rather than passing in the `run` function itself
runIf("TELEOP", (state) -> state.equals("TELEOP"), action.run());
```

`action.run()` is a call that executes immediately, not a function value to pass in.

Read `(state) -> state.equals("TELEOP")` as:
* `(state)` = one input parameter
* `->` = "returns/does"
* `state.equals("TELEOP")` = true/false result for the condition

Read `() -> System.out.println("Action ran")` as:
* no inputs
* run this print statement when called


## Try it out!

* Create a `Condition` lambda that checks a robot state string
* Create a second `Condition` lambda with different logic
* Use `runIf(...)` with at least two different state values
* Replace one action lambda with a method reference
