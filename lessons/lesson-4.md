# Lesson 4: Scope

Now that we've used code blocks (`{ ... }`), we should talk about scope.

Scope means where in your code a variable can be used. You may have used a language like `Scratch` or `Blocks`. In those languages, a variable can be used _anywhere_ once you have created it. That's not the case in Java and many other languages.

## Block Scope

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

## Scope in For Loops

A variable declared in a `for` loop header only exists in that loop.

```Java
for (int i = 0; i < 3; i = i + 1) {
    System.out.println(i);
}

// System.out.println(i); // does NOT work: i is out of scope here
```

## Try it out!

Write a small program that:
* Creates a variable outside a `while` loop
* Creates a second variable inside the `while` loop
* Prints both values inside the block
* Prints the outside variable after the block
* Tries (in a comment) to print the inside variable after the block and explain why it fails

Optional challenge:
* Create an `if` statement inside the `while` loop. What variables can you see (or not see) inside the `if` statement's code block? Can you keep adding more code blocks inside it?

