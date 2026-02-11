# Lesson 5: Functions

As programs get bigger, functions help you organize your code into smaller pieces.

A function is a named block of code that can:
* optionally take input values (called parameters)
* do some work
* optionally return a result

## Function Basics

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

## Calling a Function

To use a function, call it by name and pass the inputs it expects, separated by commas. If no inputs are required, you (again) still need the parentheses.

```Java
int total = add(3, 4);
System.out.println(total); // 7

printGreeting("Taylor"); // Hello, Taylor
```

## Return vs Void

Use a return value when you need to compute and use a result later.
Use `void` when the function should just do an action (like printing).

## Try it out!

Start with your number guessing game from Lesson 3, then:
* Make one function that prints instructions to the player
* Make one function that checks whether a guess is too low, too high, or correct
  * It should print out the result (too high, too low, correct)
  * It should return true if the guess was correct, or false if the guess was not correct
* Call those functions from your main program flow
  * Try not to do the same thing in two different parts of your code!

