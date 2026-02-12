# Lesson 10: Encapsulation

So far, our code can directly change fields like `member.grade` from anywhere.
That is simple, but it can also lead to bugs (for example, setting grade to `-100` by mistake).

Encapsulation means controlling how data is read and changed.

## Private Fields

`private` means a field can only be accessed directly inside its own class.

```Java
public class TeamMember {
    private String name;
    private int grade;
    private String role;

    TeamMember(String name, int grade, String role) {
        this.name = name;
        this.grade = grade;
        this.role = role;
    }
}
```

Now this will NOT compile outside `TeamMember`:

```Java
TeamMember alex = new TeamMember("Alex", 9, "Programmer");
System.out.println(alex.name); // error: name has private access
```

## Getters and Setters

To read or change private fields from outside the class, we add methods.
These are often called getters and setters.

```Java
public class TeamMember {
    private String name;
    private int grade;
    private String role;

    TeamMember(String name, int grade, String role) {
        this.name = name;
        this.grade = grade;
        this.role = role;
    }

    String getName() {
        return name;
    }

    int getGrade() {
        return grade;
    }
    
    void setGrade(int grade) {
        this.grade = grade;
    }

    String getRole() {
        return role;
    }

    void setRole(String role) {
        this.role = role;
    }
}
```

Use them like this:

```Java
TeamMember alex = new TeamMember("Alex", 9, "Programmer");
System.out.println(alex.getName());
alex.setRole("Drive Team");
```

## Validation

So far, this seems like a lot of extra work to do the same thing we could do before. But, there are some good reasons why we might want to do this.

Did you notice that there wasn't a `void setName()` method? By making the `name` field `private` and not creating a setter for the `name` field, we can prevent someone from changing the name of a `TeamMember`.

Even if we do want the data to be able to be changed, with setter methods, the class can check the data before changing it. For example, `grade` is an `int`, which means it can hold any integer between (approximately) 2 billion and negative 2 billion. Most of those aren't valid grades!
Since the only way we can change the grade is by using `setGrade`, we can only update the grade if we decide it is a real grade. This is called *validation*. Let's modify the `setGrade` method above to include validation:

```Java
void setGrade(int grade) {
    if (grade >= 1 && grade <= 12) {
        this.grade = grade;
    }
}
```

Now invalid grades are ignored.

## Try it out!

* Change your `TeamMember` fields to `private`
* Add getters for all fields
* Add `setRole(String role)`
* Add `setGrade(int grade)` with validation for grades `6` to `12`.
* Update your `Main` code so it uses getters/setters instead of direct field access

Optional challenge:
* If `setGrade` gets an invalid grade, instead of doing nothing, set the grade to the nearest valid grade.
* Add a method `boolean isValidRole(String role)` and use it in `setRole`. Hint: In order to see if two strings are the same, you should use String's `equals` method instead of `==`. For example, to see if String `a` and String `b` are the same, use the condition `a.equals(b)`.
