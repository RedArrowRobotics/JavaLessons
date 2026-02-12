# Lesson 7: Classes and Objects

In Lesson 6, arrays and `ArrayList` helped us scale from one team member to several team members.
But using separate lists for names, grades, and roles can still be hard to manage.
You have to make sure index `0` in every list is the same person, index `1` is the same person, and so on.

What we want is one thing in code that represents one team member.

An object is a self-contained value in your program that can store related data together.
For our team member program, a single object could hold `name`, `grade`, and `role` all together for one person.

A class is the definition that describes what data those objects have.
So:
* `TeamMember` is the class definition. We use it to tell the program that each team member has a `name`, `grade`, and `role`.
* Alex, Sam, and Jordan are separate objects, each with their own set of data.

As an analogy, a class is like a blueprint, and objects are the actual things built from it.

## Creating a Class

In Java, each class is in its own `.java` file, and the file name must match the class name.
If your class is named `TeamMember`, the file should be named `TeamMember.java`.

### IntelliJ steps
* In the Project panel, right-click your source folder (`src`)
* Choose `New` -> `Java Class`
* Name it `TeamMember`

## First Class Example

`TeamMember.java`
```Java
public class TeamMember {
    String name;
    int grade;
    String role;
}
```
This defines a class with 3 variables (`name`, `grade`, `role`). Note: When a variable is part of a class, we call it a *field*.


Now that we have a class, we can create an object. But before we do this, let's learn about the dot operator.
We've already used it a few times. For example `System.out.println(...)` uses it twice.
The dot operator means "access a part of this thing."

Rule of thumb:
* Left of `.` = the thing you have
* Right of `.` = the field or function you want from that thing

Examples:
* `member.name` -> the `name` field on `member`
* `member.role` -> the `role` field on `member`
* `System.out.println(...)` -> chained access: `System` -> `out` -> `println(...)`


Now, let's create our object:

`Main.java`
```Java
public class Main {
    public static void main(String[] args) {
        // Create an Object called member, of type TeamMember
        TeamMember member = new TeamMember();

        // Set the fields using the dot operator
        member.name = "Alex";
        member.grade = 9;
        member.role = "Programmer";

        // Print the fields
        System.out.println(member.name);
        System.out.println(member.grade);
        System.out.println(member.role);
    }
}
```
What this does:
* Creates one object using `new TeamMember()`
* Stores data in that object
* Reads data back and prints it

## Try it out!

* Create a second `TeamMember` object with different data
* Print both members
* Add one more field to the class (for example, `yearsOnTeam`)
* Set and print that field for both objects
