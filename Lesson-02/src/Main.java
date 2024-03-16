import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your first name?");
        String first = input.nextLine();
        System.out.println("What is your last name?");
        String last = input.nextLine();

        int numberOne = 8;
        int numberTwo = 3;

        System.out.println("Hi " + first + " " + last + "! ");

        // What if we don't have the parentheses around 'numberOne + numberTwo'?
        // Try it and see what happens. Can you figure out what is going on?
        System.out.println(numberOne + " + " + numberTwo + " = " + (numberOne + numberTwo));
    }
}