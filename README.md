
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


## Online Resources
- GitHub - Code Repository
- [StackEdit](https://stackedit.io/) - MarkDown Editor
