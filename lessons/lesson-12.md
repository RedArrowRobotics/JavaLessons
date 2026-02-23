# Lesson 12: Inheritance and Override

As programs grow, you often create classes that are very similar.
You could copy-paste code between classes, but that can lead to duplication, which we generally try to avoid. 

(Why do we avoid duplication? One of the main reasons is if you find a bug, you have to fix it _everywhere_ that has the 
same code - and it's often easy to miss a place)

Instead, we can take all the common parts of the classes and put them in a 'parent' class. This is also sometimes 
referred to as a base class. Then, we tell each of the original 'child' classes (sometimes also called subclasses) to 
_inherit_ from the parent class we made. Each child class gets everything in the parent class (except for anything marked `private`[^1]). That lets us focus on 
just the parts that are different from the parent class.

[^1]: In many cases, you may want something in a parent class that child classes _can_ use, but everything else cannot. In this case, use the keyword `protected` rather than `private` or `public`.

It also means that if we change something in the parent class, then _all_ the classes that inherit from it will change
in the same way.

To have a class inherit from a parent class, we use the `extends` keyword when defining the child class, followed by the parent class name:
```Java
public class MyClassName extends ParentClassName
```

Here's an example. We have a parent class called `RobotPart` that has a `name` and a `getStatus` method. If we want a 
new robot part to have a name and status, we can inherit `RobotPart` when we define the new class - for example, `MotorPart`.
The two classes might look like this:

```Java
public class RobotPart {
    String name;

    RobotPart(String name) {
        this.name = name;
    }

    String getStatus() {
        return name + ": OK";
    }
}

public class MotorPart extends RobotPart {
    MotorPart(String name) {
        // In the same way that `this` means the current class, `super` means "the parent class"
        // When we call super here, we are actually calling the parent's class's constructor
        super(name);
    }

    // `MotorPart` now has `getStatus()` because it extends `RobotPart`.
}
```
A common way to think about whether to compose or inherit:
* inheritance can be thought of as an "is a" relationship (`MotorPart` is a `RobotPart`)
* composition can be thought of as a "has a" relationship (`RobotPart` has a `name` - and because `MotorPart` is a `RobotPart`, `MotorPart` _also_ has a `name`)

### `@Override`

Sometimes, we want to make the child class have slightly different behavior from the parent class. Be careful! If you find this happening
a lot, it may mean that inheritance isn't the best choice for your classes. However, we can _override_ the parent class's methods
in a child class by using the _@Override_ annotation.

An annotation is extra information you attach to code, and in Java these always start with an `@` symbol.

`@Override` is an annotation that tells Java: "this method is intended to replace a method from the parent class." For example,
if we have another class called `SensorPart` that needs a different status, we can add the same status method with the `@Override` annotation
like this:

```Java
public class SensorPart extends RobotPart {
    SensorPart(String name) {
        super(name);
    }

    @Override
    String getStatus() {
        return name + ": NEEDS CALIBRATION";
    }
}
```

Now, if you have a `SensorPart` and call `getStatus()` on it, it will use the method in `SensorPart` instead of the one in `RobotPart`.

## Try it out!

* Add another subclass (for example, `CameraPart`)
* Override `getStatus()` with a custom message
* Create one object of each subclass and print statuses
* Add one non-overridden method in `RobotPart` and call it from all subclasses
