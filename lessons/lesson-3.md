# Lesson 3: Control Flow

Now that you can read input, store data in variables, and print output, it's time to make programs that make decisions and repeat actions.
("Control flow" means the order your program runs instructions.)

## Conditions (Expressions)

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

## If / Else

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

## While Loop

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

## For Loop

A `for` loop is a compact way to repeat a fixed number of times.

```Java
for (int i = 1; i <= 5; i = i + 1) {
    System.out.println("i is " + i);
}
```

This does the same thing as the `while` example above, but in a slightly more compact form.

## Try it out!

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

