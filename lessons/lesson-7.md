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

`Main.java`
```Java
public class Main {
    public static void main(String[] args) {
        TeamMember member = new TeamMember();

        member.name = "Alex";
        member.grade = 9;
        member.role = "Programmer";

        System.out.println(member.name);
        System.out.println(member.grade);
        System.out.println(member.role);
    }
}
```

What this does:
* Defines a class with 3 variables (`name`, `grade`, `role`). Note: When a variable is part of a class, we call it a *field*.
* Creates one object using `new TeamMember()`
* Stores data in that object
* Reads data back and prints it

## Try it out!

* Create a second `TeamMember` object with different data
* Print both members
* Add one more field to the class (for example, `yearsOnTeam`)
* Set and print that field for both objects
