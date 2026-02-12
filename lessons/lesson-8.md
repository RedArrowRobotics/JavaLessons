# Lesson 8: Constructors

In Lesson 7, we created `TeamMember` objects and then set each field one by one.
That works, but it gets repetitive and makes it easy to forget a field.

A constructor lets you set up an object when it is created.

## Constructor Basics

A constructor is a special function that:
* has the same name as the class
* has parameters for the starting data
* has no return type (not even `void`!)

Example:

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
}
```

`this` means "this current object."
So `this.name` means "the `name` field of this current object."
We use `this` to make it clear that we are assigning the object's field (left side) from the input parameter (right side).

A class _must_ have a constructor, so if you don't add one, Java creates a default one. 
The default constructor takes no parameters, and sets default values for all the fields in the class. 
This is what we used in the last lesson. As soon as you create a constructor, the default constructor isn't needed, and goes away.
This is why if you add the constructor above into your Lesson 7 code, it will no longer work.

But, a class can have more than one constructor! We won't be exploring that in these lessons, but feel free to experiment with it if you'd like.

## Default Values and `null`

When an object is created, fields get default values if you don't set them.

For fields in a class:
* The 8 _primitive_ types get 'default' values:
  *  `byte`, `short`, `int`, and `long` default to `0`
  *  `float` and `double` default to `0.0`
  * `boolean` defaults to `false`
  * `char` defaults to `'\u0000'`
* All other types (like `String`) default to `null`

`null` means "no value/object is set yet."

So if a constructor does not set a `String role` field, that field will be `null`.

```Java
public class TeamMember {
    String name;
    int grade;
    String role;

    TeamMember(String name, int grade) {
        this.name = name;
        this.grade = grade;
        // role is not set, so it defaults to null
    }
}
```

If you print a `null` field, Java prints `null`.
If you try to use it like a real value (for example, `role.length()`), your program will crash!
That particular crash is called a `NullPointerException`, and it is one of the most common ways that Java programs can crash. 
Sometimes `null` values are unavoidable (or even desirable), but it is good practice _for now_ to make sure you always set variables and fields so they are not `null`.

## Creating Objects with a Constructor

Now you can create objects and set all fields in one line:

`Main.java`
```Java
public class Main {
    public static void main(String[] args) {
        TeamMember alex = new TeamMember("Alex", 9, "Programmer");
        TeamMember sam = new TeamMember("Sam", 8, "Designer");

        System.out.println(alex.name + " - " + alex.role);
        System.out.println(sam.name + " - " + sam.role);
    }
}
```

We now have less repeated setup code, and every `TeamMember` starts with the data it needs.

## Try it out!

* Add a new field to `TeamMember` (for example, `lastName`)
* Update the constructor so it includes that new field
* Create another team member using the constructor

Optional challenge:
* Make a second constructor that only takes `name` and `grade`
* In that constructor, set `role` to `"Unknown"`, then compare it with leaving `role` unset (`null`)
