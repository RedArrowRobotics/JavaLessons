# Lesson 6: Arrays

So far, you've mainly used one variable to hold one value.
But sometimes you need to hold a list of values of the same type.
An array lets you do that.

An array:
* has a fixed size
* stores many values of one type
* uses an index (position number) to access each value

Example:

```Java
String[] names = new String[3];
names[0] = "Alex";
names[1] = "Sam";
names[2] = "Jordan";

System.out.println(names[0]); // Alex
```

You can use loops with arrays to avoid repeating code:

```Java
for (int i = 0; i < 3; i = i + 1) {
    System.out.println(names[i]);
}
```

## ArrayList

Arrays are fundamental, but Java programs use `ArrayList` more often.

`ArrayList` is a resizable list:
* arrays have fixed size (`new String[3]`)
* `ArrayList` can grow as you add items

To use `ArrayList`, import it:

```Java
import java.util.ArrayList;
```

You create an `ArrayList` like this:

```Java
ArrayList<Type> listName = new ArrayList<>();
```

Examples:

```Java
ArrayList<String> names = new ArrayList<>();
ArrayList<Integer> grades = new ArrayList<>();
```

For now, use this pattern:
* Use `String` for text
* Use `Integer` for whole numbers in `ArrayList` (not `int`)

(Why? Java has two kinds of types. _primitive_ types start with a lower-case letter (`int`, `long`, `boolean`) and take up a little less memory. The other kind is a _class_, which starts with an upper-case letter and take up a little more memory, but have some other benefits. We'll talk about classes in the next lesson. `ArrayList` _can't_ store primitive types, so for each primitive type Java also has an equivalent class. For whole numbers you use `Integer`.)

Example:

```Java
ArrayList<String> names = new ArrayList<>();
names.add("Alex");
names.add("Sam");
names.add("Jordan");

System.out.println(names.get(0)); // Alex
System.out.println(names.size()); // 3
```

Common `ArrayList` syntax you'll use:
* `list.add(value)` -> add one item (`value`) to the end
* `list.get(index)` -> return the item at a position `index`
* `list.size()` -> return the number of items currently in the list

Looping through an `ArrayList`:

```Java
for (int i = 0; i < names.size(); i = i + 1) {
    System.out.println(names.get(i));
}
```

## Try it out!

Build a "team roster" program:
* Track 3 team members' names, grades, and roles (role might be `programmer`, `electronics`, `designer`, `fabricator`, etc)
* You can use arrays (`String[] memberNames`, `int[] memberGrades`, etc) or `ArrayList`s (`ArrayList<String> memberNames`, `ArrayList<Integer> memberGrades`, etc)
* Ask the user to type in each member's data using `Scanner`
* Use a loop so you don't repeat the same prompt code 3 times
* Optional extension: allow an unknown number of members by using `ArrayList`
* Use at least one `if / else` condition
  * Example: print a different message for middle school vs high school grade levels
* Create at least one function to avoid repeating code
  * Example: a function that prints one member's info
* Print a final roster summary

