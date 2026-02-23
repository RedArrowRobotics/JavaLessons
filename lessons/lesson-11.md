# Lesson 11: Composition and Dependency Passing

Imagine we have an action class that should control a drive subsystem.
The action needs to call functions on the subsystem to make the robot move.

For example, you might have:

```Java
public class DriveSubsystem {
    String name;

    DriveSubsystem(String name) {
        this.name = name;
    }

    void drive(double xSpeed, double turnSpeed) {
        System.out.println(name + " driving: " + xSpeed + ", " + turnSpeed);
    }
}

public class DriveForwardAction {
    void run(DriveSubsystem drive) {
        drive.drive(0.5, 0.0);
    }
}

public class Main {
    public static void main(String[] args) {
        DriveSubsystem practiceDrive = new DriveSubsystem("practice bot");
        DriveSubsystem compDrive = new DriveSubsystem("competition bot");
        DriveForwardAction action = new DriveForwardAction();

        // main must decide which subsystem to pass every time
        action.run(practiceDrive);

        // Easy mistake: passing the wrong subsystem
        action.run(compDrive);
    }
}
```

We can use *composition* to improve this.
Composition means one class contains or uses another class directly (a "has a" relationship). In this case, we'll make
it so the `DriveForwardAction` _has a_ `DriveSubsystem`.

```Java
public class DriveForwardAction {
    private DriveSubsystem drive;

    DriveForwardAction(DriveSubsystem drive) {
        this.drive = drive;
    }

    void run() {
        drive.drive(0.5, 0.0);
    }
}
```

Notice that `DriveForwardAction` does not create its own `DriveSubsystem`.
Instead, it receives one in the constructor.

When one object needs another object to do its job, that second object is called a dependency.
Passing it in (often through a constructor) is called dependency passing.

```Java
public class Main {
    public static void main(String[] args) {
        DriveSubsystem drive = new DriveSubsystem("competition bot");
        DriveForwardAction action = new DriveForwardAction(drive);

        action.run();
    }
}
```

In this example, `main` creates the subsystem and action and then passes the subsystem into action.
We want to do this because you might have a bunch of different actions, but we don't want to make _separate_ drive 
subsystem objects - there should only be one, because our robot only has one physical drive train. (Otherwise, we could
get into a situation where two actions were commanding two drive subsystems to move in different ways at the same time!)

## Try it out!

* Add another subsystem (for example, `ShooterSubsystem`)
* Create an action that depends on it
* Create both objects in `main` and connect them
* Run both actions
