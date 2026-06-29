# Lesson 4: Scope

In Lesson 3, we started using braces (`{` and `}`) with things like `if` statements and loops.
The code _inside_ those braces is called a code block. Each code block also has it's own *scope*, 
which is what we will talk about for this lesson.

Scope means where in your code a variable can be used. You may have used a language like `Scratch` or `Blocks`. 
In those languages, a variable can be used _anywhere_ once you have created it. 
That's not the case in Java and many other languages. Instead, where you can use a variable depends on where you create it.

## Block Scope

When you define a variable inside a block, that variable _only_ exists inside that block. 
The places where a variable can be used is called its *scope*.

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

## Scope in Loops

If you create a variable *inside* the loop's code block, that variable is created again each time the loop runs.
Sometimes you want that! But it does not "remember" its value from the last iteration.

For example:

```Java
int count = 0;

while (count < 3) {
    int inside = 100;
    System.out.println(inside);

    inside = inside + 1;
    count = count + 1;
}
```

This prints:
```
100
100 
100
```

Why?
* each time the `while` loop starts again, a brand new `inside` variable is created
* it starts at `100` every time
* then it becomes `101`
* but it goes out of scope and is not used again

If you want a variable to keep its value between loop iterations, define it *before* the loop:

```Java
int count = 0;
int outside = 100;

while (count < 3) {
    System.out.println(outside);

    outside = outside + 1;
    count = count + 1;
}
```

This prints:

```
100
101
102
```

because `outside` stays in scope for the whole loop, instead of being recreated each time.

Note: A variable declared in a `for` loop header only exists in that loop, but it is 'outside' the loop code block, so we can 

```Java
for (int i = 0; i < 3; i = i + 1) {
    System.out.println(i);
}

// System.out.println(i); // does NOT work: i is out of scope here
```

## Indentation and Braces

When you write blocks in Java, the braces `{` and `}` decide what code is inside the block.
The spaces at the start of each line (indentation) do not change what Java does, but they make it much easier for people to see which `}` matches which `{`.

For example, this is formatted clearly:

```Java
int outside = 10;

if (outside > 5) {
    int inside = 20;
    System.out.println(inside);
}

System.out.println(outside);
```

Notice:
* the line with `if (...) {` starts a block
* the code inside the block is indented one level
* the matching `}` lines up with the `if`

Here is the same code with messy formatting:

```Java
    int outside = 10;
if (outside > 5) {
    
        int inside = 20;
System.out.println(inside);


   } System.out.println(outside);
```

Java can still run that code just fine, but it is much harder for a person to read.
That makes it easier to put a `}` in the wrong place by accident. 

Here is an example where formatting helps a lot:

```Java
if (outside > 5) {
    System.out.println("Inside the if");
    while (outside > 7) {
        System.out.println("Inside the while");
        outside = outside - 1;
    }
}
```

In this example:
* the `while` block is inside the `if` block
* the `while` code is indented one more level than the `if` code
* each `}` lines up with the statement that started its block

When you type Java code, try to copy the indentation carefully.
Even though the spaces do not change the meaning, they help you see the meaning.

In the coming lessons, we will learn about more places where we use code blocks. In each of those cases, the scope rules will apply.

## Try it out!

Write a small program that:
* Creates a variable outside a `while` loop
* Creates a second variable inside the `while` loop
* Prints both values inside the block
* Prints the outside variable after the block
* Tries (in a comment) to print the inside variable after the block and explain why it fails

Optional challenge:
* Create an `if` statement inside the `while` loop. What variables can you see (or not see) inside the `if` statement's code block? Can you keep adding more code blocks inside it?
