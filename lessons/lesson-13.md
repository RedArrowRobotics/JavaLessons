# Lesson 13: Interfaces and Polymorphism

Imagine we want to run a sequence of different robot actions, like intake, shooting, and climbing.
Each action class has its own code, but from the outside we just want to tell each one: "run."

```Java
public class IntakeAction {
    void run() {
        System.out.println("Running intake");
    }
}

public class ShootAction {
    void run() {
        System.out.println("Shooting fuel");
    }
}

public class ClimbAction {
    void run() {
        System.out.println("Climbing");
    }
}

public class Main {
    static void runAutonomousSequence(IntakeAction intake, ShootAction shoot, ClimbAction climb) {
        intake.run();
        shoot.run();
        climb.run();
    }
}
```

This works, but there are things that could be better:
* every time we add a new action type, we need to change the `runAutonomousSequence` function signature
* we cannot put all actions into a list, because you have to tell the list what type of object it holds - and we have three types here
* code that runs actions must know all the 'action' class names

Interfaces let us improve the code to address these issues.

An interface is a list of function names that a class promises to provide.
To have a class follow an interface, we use the `implements` keyword:

```Java
public class MyClassName implements InterfaceName
```

An interface looks a lot like a class, except that
* it is defined with the `interface` keyword instead of the `class` keyword, and
* the methods don't have any code blocks - instead they end in a semicolon

For this example, we can define an interface called `RobotAction`:
```Java
public interface RobotAction {
    void run();
}
```

Now each action class can implement that interface:

```Java
public class IntakeAction implements RobotAction {
    @Override
    public void run() {
        System.out.println("Running intake");
    }
}

public class ShootAction implements RobotAction {
    @Override
    public void run() {
        System.out.println("Shooting fuel");
    }
}

public class ClimbAction implements RobotAction {
    @Override
    public void run() {
        System.out.println("Climbing");
    }
}
```

Then we can rewrite the same idea more cleanly. Notice how we can add all the different action types to a single list!
This is powerful, because the `runAutonomousSequence` doesn't need to know what _specific_ actions we have. In addition, 
it's much easier to define several lists, each for a different autonomous routine - and still pass them into the same 
`runAutonomousSequence` function.

```Java
public class Main {
    static void runAutonomousSequence(ArrayList<RobotAction> actions) {
        for (RobotAction action : actions) {
            action.run();
        }
    }

    public static void main(String[] args) {
        ArrayList<RobotAction> actions = new ArrayList<>();
        actions.add(new IntakeAction());
        actions.add(new ShootAction());
        actions.add(new ClimbAction());

        runAutonomousSequence(actions);
    }
}
```

### Polymorphism

Polymorphism means one variable type can refer to different classes.
Here, `RobotAction` is that common type.

Even though each object is a different class (`IntakeAction`, `ShootAction`, `ClimbAction`),
they can all be treated as `RobotAction` and used the same way, because they all _implement_ the `RobotAction` interface. 
This is why we can use `RobotAction` as the 'type' for the ArrayList in the above example.

## Try it out!

* Add one more action class that implements `RobotAction`
* Add it to the `actions` list
* Run the sequence again
* Add one more function to `RobotAction` and implement it in all action classes
