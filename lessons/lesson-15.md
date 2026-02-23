# Lesson 15: Enums and State

Programs often need a fixed set of states.
Using plain strings for state is error-prone, because you can often type them in different ways, like `"teleop"` vs `"Tele-Op"`.

Enums solve this by giving you a fixed list of valid values.

```Java
public enum RobotState {
    DISABLED,
    AUTONOMOUS,
    TELEOP,
    TEST
}
```

`RobotState` can only be one of those values.

An enum can either be in its own file, or inside another class.

* If `RobotState` is in its own file, you access the values like this: `RobotState.DISABLED`.
* If `RobotState` is in another class (for example, `RobotModeManager` below), you access the values like this: `RobotModeManager.RobotState.DISABLED`.

```Java
public class RobotModeManager {
    enum RobotState {
        DISABLED,
        AUTONOMOUS,
        TELEOP,
        TEST
    }
}
```

### Using `switch` with Enums

```Java
public class RobotModeManager {
    private RobotState state = RobotState.DISABLED;

    void setState(RobotState state) {
        this.state = state;
    }

    void periodic() {
        switch (state) {
            case DISABLED -> System.out.println("Robot disabled");
            case AUTONOMOUS -> System.out.println("Running auto");
            case TELEOP -> System.out.println("Driver control");
            case TEST -> System.out.println("Test mode");
        }
    }
}
```

`switch` works a bit like `if/else if` statements - each `case` handles one enum value. The statement after the `->` can also be a block.

## Try it out!

* Add one more state to `RobotState`
* Update `periodic()` to handle it
* Write a small loop that changes state and calls `periodic()` each time
