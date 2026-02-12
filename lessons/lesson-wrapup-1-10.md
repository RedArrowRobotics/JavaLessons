# Wrap-Up Project (Lessons 1-10): Scouting App

Now that you've completed Lessons 1-10, let's build a small app that uses everything you've learned.

This project is a simple text-based scouting app for FRC match data.
It is small, but useful. If you have ideas about how you can make it even more useful, you can keep working on it!

## Goal

Build a program that lets you:
* add scouting entries for matches
* list all entries
* optionally filter entries by team number
* optionally print simple statistics (like average points)

## Step 1: Create a Class for One Scouting Entry

Create a class called `ScoutEntry` with private fields:
* `teamNumber` (`int`)
* `matchNumber` (`int`)
* `autoPoints` (`int`)
* `teleopPoints` (`int`)
* `notes` (`String`)

Add:
* a constructor that sets all fields
* getters for all fields
* setters where it makes sense
* validation in setters (for example, points cannot be negative)

Optional:
* add a function like `int getTotalPoints()` that returns `autoPoints + teleopPoints`
* add a function like `String getSummary()` for printing one entry

## Step 2: Store Many Entries

In `Main`, create:

```Java
ArrayList<ScoutEntry> entries = new ArrayList<>();
```

Use this to store every scouting entry the user creates.

## Step 3: Add a Menu Loop

Use a `while` loop and `Scanner` to show a repeating menu:
1. Add entry
2. List entries
3. Find entries by team number (optional)
4. Show average points for a team (optional)
5. Quit

Use the scanner to read a number (1-5) that corresponds to the menu items.
Use `if / else if / else` (or `switch` if you want) to handle the menu choice.

## Step 4: Write Helper Functions

To keep your `main` method clean, make functions such as:
* `addEntry(...)`
* `listEntries(...)`
* `listEntriesForTeam(...)` (optional)
* `printAverageForTeam(...)` (optional)
* To quit, you can use `exit(0);`

These should use loops, conditions, and your `ScoutEntry` methods.

## Step 5: Input One `ScoutEntry`

Inside `addEntry(...)`, explicitly ask the user for each field:
1. Team number
2. Match number
3. Auto points
4. Teleop points
5. Notes

Then:
* create a new `ScoutEntry` with those values
* add it to `entries`

Example flow:
* print `"Team number?"` and read an `int`
* print `"Match number?"` and read an `int`
* print `"Auto points?"` and read an `int`
* print `"Teleop points?"` and read an `int`
* print `"Notes?"` and read a `String`
* call `entries.add(new ScoutEntry(...))`

For `notes`, users might leave it blank.
If notes are missing, consider storing something friendly like `"No notes"` (Hint: to test if String `a` is missing, use the condition `a.equals("")`)

## Step 6 (Optional): Filtering by Team

If you want menu options 3 and 4, first write a helper function that filters entries. The function definition should look like this:

```Java
ArrayList<ScoutEntry> getEntriesForTeam(ArrayList<ScoutEntry> entries, int teamNumber)
```

This function should:
* create a new empty `ArrayList<ScoutEntry>`
* loop through all `entries`
* add only matching team entries to the new list
* return the filtered list

Then reuse that function:
* `listEntriesForTeam(...)` prints the filtered list
* `printAverageForTeam(...)` computes averages from the filtered list

## Suggested Test Data

Add a few entries like:
* Team `1678`, Match `3`, Auto `8`, Teleop `22`, Notes `"Fast cycles"`
* Team `254`, Match `3`, Auto `10`, Teleop `25`, Notes `"Great auto"`
* Team `1678`, Match `7`, Auto `6`, Teleop `24`, Notes `""`

Then test:
* listing all entries
* filtering by team (`1678`) if you implemented Step 6
* average points for team `1678` if you implemented Step 6

## More ideas
There are a lot of ways you can improve this app. Play around with it! Just like anything, the more you practice programming, the better you will get. Here are some ideas that you can use, or think up your own:

* Track extra fields (`defenseRating`, `fouls`, `climbLevel`, etc. You might consider adding fields specifically for this year's game.)
* Add sorting (highest average points first)
* Add team summary output with more information, for example min/max/average.
* Save/load data from a file. You should be able to find plenty of tutorials online that will show you how to do this.
* Split code into more classes. Maybe you want a class that represents an FRC event, so that you can separate `ScountEntry`s by competition. For example, each event could have a name, date, and its own ArrayList of `ScoutEntry` items.

## Next steps
After this review, we will go onto a few more advanced Java concepts that we will need to at least be familiar with to program the Robot. Make sure you understand Lessons 1-10 well before moving on! Everything builds on these, so if you don't understand something, make sure you talk to a mentor.
