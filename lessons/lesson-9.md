# Lesson 9: Functions in Classes

Data is only part of the story with classes. If a class stores data, it is often useful for that class to also know how to work with its own data.
We can add functions to a class that work directly with an object's data. This helps keep things organized by keeping code that works with class data next to that data.

When a function is inside a class, Java usually calls it a *method*. You can think of a method as "a function that belongs to an object."

For example, in our `TeamMember` class we might want methods to print a short summary, and check if the member is at least a certain grade.

Here's what these methods could look like in our `TeamMember` class:
`TeamMember.java`
```Java
public class TeamMember {
    String name;
    int grade;
    String role;

    TeamMember(String name, int grade, String role) {
        this.name = name;
        this.grade = grade;
        this.role = role;
    }

    void printSummary() {
        System.out.println(name + " (Grade " + grade + ") - " + role);
    }

    boolean isAtLeastGrade(int minimumGrade) {
        return grade >= minimumGrade;
    }
}
```
Do you notice that `printSummary()` does not take parameters, but can still see the `name`, `grade`, and `role` fields? That's because the fields are in scope anywhere in the `TeamMember` class body. Because these methods are also in the class body, they can use those fields directly.
`isAtLeastGrade(int minimumGrade)` shows that methods can also take input values when needed.


On the other hand, if we were to put the `printSummary()` function somewhere else in the code, it might have to look like this:

```Java
void printSummaryOutsideClass(String name, int grade, String role) {
    System.out.println(name + " (Grade " + grade + ") - " + role);
}
```

```Java
// We'll make objects `alex` and `sam` using the TeamMember constructor:
TeamMember alex = new TeamMember("Alex", 9, "Programmer");
TeamMember sam = new TeamMember("Sam", 8, "Designer");

// If we use the 'normal' function:
printSummaryOutsideClass(alex.name, alex.grade, alex.role);
printSummaryOutsideClass(sam.name, sam.grade, sam.role);
```

That's a fair bit of typing, and there's more of a chance for errors. For example, you could write this:
```Java
printSummaryOutsideClass(alex.name, sam.grade, sam.role);
```
To use the class method, we use the dot operator on the object with the function name.
If we do this, it becomes much cleaner:
```Java
// This does the same thing using class methods:
alex.printSummary();
sam.printSummary();

// We can also call methods that take parameters in a similar way:
System.out.println(alex.isAtLeastGrade(9));
System.out.println(sam.isAtLeastGrade(9));

```
Calling `alex.printSummary()` means:
* run the `printSummary` function
* using `alex`'s data

Calling `sam.printSummary()` runs the same function, but with `sam`'s data.
For methods with parameters, you pass input in parentheses, just like any other function.
`alex.isAtLeastGrade(9)` asks "is Alex at least grade 9?"

Not only does it look cleaner and is faster to type, it also helps you have fewer bugs in your code!

## Try it out!

* Add a function `String getLabel()` that returns text like `"Alex - Programmer"`
* Add a function `boolean isInGrade(int grade)` that returns `true` if `this.grade == grade`
* Create at least 3 `TeamMember` objects
* Loop through them and call your functions for each member

Optional challenge:
* Add a function `void promoteGrade()` that increases `grade` by 1
* Call it, then print summaries again to confirm each grade changed
