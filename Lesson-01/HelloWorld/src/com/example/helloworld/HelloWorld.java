package com.example.helloworld;

public class HelloWorld {
    public static void main(String[] args) {

        String thing1 = "Hello Tester";
        String[] thing2 = new String[] {"Message 0", "Message 1"};
        String thing3 = GetName(5);

        System.out.println(thing1);
        System.out.println(thing2[0]);
        System.out.println(thing3);
    }

    public static String GetName(int mySelection) {
        String[] myArray = new String[] {"Message 0", "Message 1", "Message 2","Message 3","Message 4","Message 5"};
        return myArray[mySelection];
    }
}
