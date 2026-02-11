
# Java Lessons
- A repository for getting started with Java programming. 
- This assumes you've done at least some programming in another language, such as Scratch

## Software
- [IntelliJ IDEA (Community Edition) - Integrated Development Environment](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html?keymap=windows)

## Setup

To get started with Java, the best way to start is with a IDE (also known as an Integrated Development Environment). It's really just a fancy tool that helps make programming easier. There's an "Ultimate" and "Community", so make sure to download the Community edition.

-   [https://www.jetbrains.com/idea/download/?section=windows](https://www.jetbrains.com/idea/download/?section=windows)
    

Important: You won't be able to use a school chromebook, so you'll need a non-school computer. Please make sure your parents know what you're doing!

## Lessons

### Lesson 1: Getting Started With Java

When you get that installed, please follow these instructions for the lesson 1 program:

-   [https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html?keymap=windows](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html?keymap=windows)

### Lesson 2: Variables and Types, Input and Output

#### Variables and Types

Every variable in Java has a `type`. For example, here are some common types:
* int: Used to hold an Integer (whole number)
* double: Used to hold a decimal number
* String: Used to hold text
* boolean: Used to hold either `true` or `false`

But in fact, there are many more than those, because you can make your own types!

A 'type' just describes what type of data a variable can hold.

So you could make a type called `Person`, and inside your `Person` type, you could hold (for example), a `name` and `age`. It turns out this is quite useful.

If you want to use a variable in Java, first you have to _define_ it. This means that you have to tell Java what it's name is, what type it is, and what the initial data it holds is. You have to do this before you use it anywhere else in your program.

So, when you define a variable, it looks like this:
```
<type> <variable name> = <data to store in the variable>;
```

Here's two examples:
```Java
int age = 12;
String name = "Bob";
```

One common thing you will want to do with a variable is set the value to something else.
```Java
// define a variable 'age' and tell it to hold the number `12`:
int age = 12;

// now, tell it to hold the number `13`:
age = 13;

// This doesn't work! We defined `age` to be an integer, but `"fourteen"` is a String.
// The type of a variable is not allowed to change.
age = "fourteen"
```
#### Output

Another common thing you will want to do is display ("print") the value the variable is holding. 
```Java
System.out.println(<variable name>);
```

Substitute `<variable name>` for the actual name, for example:
```Java
int age = 12;
System.out.println(age);

// now, tell it to hold the number `13`:
age = 13;
System.out.println(age);
```

When you run that, it should display
```
12
13
```

Once you have a variable defined, you can do things with it. The things you can do with the variable depend on its type. For example, if the type is `int`, then you could add another `int` to it. If the type is a `String`, you could get the first letter in the string. Most types have many different things you can do with them.

For Strings, there are a lot of things you can do with them. One String operation that can be useful is called `concatenation`. It means to basically to smush the two strings together, and in Java it uses the same `+` symbol for that that integers use for `addition`. It looks like this:
```Java
String one = "My name is ";
String two = "Dave";
System.out.println(one + two);
```
When you run that, it should display
```
My name is Dave
```

#### Input

Let's talk about one more thing. What if we want to have the person running the program type something in for the program to use? That's called 'input'. There are a lot of ways to do input. For our robot last year, we used gamepads. Using a mouse or touch screen is another form of input. For now, let's do one of the simplest ways to input something: typing on the keyboard. In Java, we can do something like this:

```Java
Scanner input = new Scanner(System.in);

// read in inputs
System.out.println("What is your name?");
String name = input.nextLine();

// print output
System.out.println("Your name is " + name);
```

Do you see that `Scanner` is a type? The first line makes a variable with type `Scanner` named `input`, and set it to the value of `new Scanner(System.in)` (but for now, we'll ignore this last part - just know it's required to make our scanner work). It turns out that types in Java can do more than just hold data. They can also do things. Just like a `String` can concatenate and an `int` can add, a `Scanner` can nextLine.

`nextLine` waits for you to type something in. As soon as you press the 'enter' key, it returns whatever you typed as a String. Then, we set that to our `name1` String (or `name2` String).

#### Try it out!

Write a program that:
* Reads in some input
* Print the input
* Do a math problem 
* Print the result of the math problem
Be creative! If you want to incorporate anything else that you know how to do, feel free to do so 🙂

### Lesson 3: Control Flow

Now that you can read input, store data in variables, and print output, it's time to make programs that make decisions and repeat actions.
("Control flow" means the order your program runs instructions.)

#### Conditions (Expressions)

Before `if` and loops, let's talk about conditions.

 * An expression is code that produces a value. For example, `4 + 7` is an expression. Expressions can also use variables, so `age - 2` is also an expression.
 * A condition is an expression that returns a boolean - either `true` or `false`.
 * An operator is a symbol (like `+` or `>`) that does work on values.

This is an example of using an operator (`>=`) to make a condition (`age >= 13`), and assign the result to a variable `isAtLeastThirteen`.
```Java
int age = 14;
boolean isAtLeastThirteen = age >= 13;
```

You will use these operators often when writing conditions:
* `==` equal to
* `!=` not equal to
* `<` less than
* `>` greater than
* `<=` less than or equal to
* `>=` greater than or equal to

You can also use standard arithmetic operators that we briefly talked about in Lesson 2:
* `+` add
* `-` subtract 
* `*` multiply
* `/` divide

You can also combine conditions:
* `&&` and (both conditions must be true)
* `||` or (at least one condition must be true)

Example:

```Java
int age = 14;
boolean canJoin = age >= 13 && age <= 18;
```

#### If / Else

`if` statements let your program choose what to do based on a condition. If the condition is `true`, it runs the code block (the code inside braces `{ ... }`) after the if. You can also use `else` to let your program perform an action if the condition is `false`.

```Java
int grade = 9;

if (grade >= 8) {
    System.out.println("Welcome to FRC!");
} else {
    System.out.println("You can join FRC when you are in 8th grade.");
}
```

You can also check multiple cases with `else if`:

```Java
int score = 87;

if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else {
    System.out.println("Keep practicing!");
}
```
It's important to note that the program will only run *one* of these. So, if `score` is 84, the program will _only_ print:
```
Grade: B
```
Even though the condition `score >= 70` is true, it doesn't also print `Grade: C`, because it tests each condition from top to bottom, and only runs the first one that is true.

#### While Loop

A `while` loop repeats as long as a condition is true.
Each repeat is called an iteration.

```Java
int count = 1;

while (count <= 5) {
    System.out.println("Count is " + count);
    count = count + 1; // This adds 1 to the current value of 'count', and then sets count to that new value.
}
```

This prints numbers 1 through 5.

#### For Loop

A `for` loop is a compact way to repeat a fixed number of times.

```Java
for (int i = 1; i <= 5; i = i + 1) {
    System.out.println("i is " + i);
}
```

This does the same thing as the `while` example above, but in a slightly more compact form.

#### Try it out!

Build a number guessing game:
* Pick a secret number in code (for example, `int secret = 7;`)
* Ask the user to guess using `Scanner`
* Use `if / else` to print:
  * "Too low"
  * "Too high"
  * "Correct!"
* Keep asking in a loop until they guess correctly
* Count how many guesses they needed and print it at the end

Optional challenge:
* Give the player only 5 guesses
* Print "You win!" or "You lose!" at the end

### Lesson 4: Scope

Now that we've used code blocks (`{ ... }`), we should talk about scope.

Scope means where in your code a variable can be used. You may have used a language like `Scratch` or `Blocks`. In those languages, a variable can be used _anywhere_ once you have created it. That's not the case in Java and many other languages.

#### Block Scope

When you define a variable inside a block, that variable _only_ exists inside that block. The places where a variable can be used is called its *scope*.

```Java
int outside = 10;

if (outside > 5) { // the { creates a new code block, so anything inside this is in a new scope
    int inside = 20;
    System.out.println(outside); // works
    System.out.println(inside);  // works
} // this is the end of the scope, so 'inside' no longer exists

System.out.println(outside); // works
// System.out.println(inside); // does NOT work: inside is out of scope here
```

In the coming lessons, we will learn about more places where we use code blocks. In each of those cases, the scope rules will apply.

#### Scope in For Loops

A variable declared in a `for` loop header only exists in that loop.

```Java
for (int i = 0; i < 3; i = i + 1) {
    System.out.println(i);
}

// System.out.println(i); // does NOT work: i is out of scope here
```

#### Try it out!

Write a small program that:
* Creates a variable outside a `while` loop
* Creates a second variable inside the `while` loop
* Prints both values inside the block
* Prints the outside variable after the block
* Tries (in a comment) to print the inside variable after the block and explain why it fails

Optional challenge:
* Create an `if` statement inside the `while` loop. What variables can you see (or not see) inside the `if` statement's code block? Can you keep adding more code blocks inside it?

### Lesson 5: Functions

As programs get bigger, functions help you organize your code into smaller pieces.

A function is a named block of code that can:
* optionally take input values (called parameters)
* do some work
* optionally return a result

#### Function Basics

To create a function, you write this:

```Java
<return type> <function name>(<parameters>) {
    // code
}
```

What each part means:
* Return type: what type of value the function sends back (`int`, `String`, etc.), or `void` if nothing comes back
* Function name: what you call to run it. Naming things is hard! Try to name things in a way that describes what the function does.
* Parameters: any input values the function needs go inside the parentheses. If you have more than one, they should be separated by commas. If it doesn't need any, you still need the parentheses!


Examples:

```Java
int add(int a, int b) {
    return a + b;
}
```
This:
* takes two integer inputs (`a` and `b`)
* does some work (computes the expression `a + b`)
* returns the result of the expression (also as an integer)

```Java
void printGreeting(String name) {
    System.out.println("Hello, " + name);
}
```
This:
* takes one String input (`name`)
* does some work (prints out `"Hello, <name>`)
* returns nothing (`void`)

#### Calling a Function

To use a function, call it by name and pass the inputs it expects, separated by commas. If no inputs are required, you (again) still need the parentheses.

```Java
int total = add(3, 4);
System.out.println(total); // 7

printGreeting("Taylor"); // Hello, Taylor
```

#### Return vs Void

Use a return value when you need to compute and use a result later.
Use `void` when the function should just do an action (like printing).

#### Try it out!

Start with your number guessing game from Lesson 3, then:
* Make one function that prints instructions to the player
* Make one function that checks whether a guess is too low, too high, or correct
  * It should print out the result (too high, too low, correct)
  * It should return true if the guess was correct, or false if the guess was not correct
* Call those functions from your main program flow
  * Try not to do the same thing in two different parts of your code!
