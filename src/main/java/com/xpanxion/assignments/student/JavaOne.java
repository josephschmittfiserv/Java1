package com.xpanxion.assignments.student;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class JavaOne {

    //
    // Constructors
    //

    public JavaOne() {
    }

    //
    // Public methods
    //

    public void ex1() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("Student 1: ex1.");
        System.out.println("Enter in your name: ");
        input = sc.nextLine();

        System.out.println("Your name in lower case is: " + input.toLowerCase());
    }

    public void ex2() {
        Scanner sc = new Scanner(System.in);
        String input;
        int count = 0;
        System.out.println("Student 1: ex2.");
        System.out.println("Enter in a string: ");
        input = sc.nextLine();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
                count++;
            }
        }
        System.out.println("The amount of uppercase letters in this are: " + count);
    }

    public void ex3() {
        Scanner sc = new Scanner(System.in);
        String input;
        int count = 0;
        System.out.println("Student 1: ex3.");
        System.out.println("Enter in a sentence: ");
        input = sc.nextLine();

        StringTokenizer st = new StringTokenizer(input);

        System.out.println("Every other word capatalized is: ");

        while (st.hasMoreTokens()) {

            if (count % 2 == 0)
                System.out.println(st.nextToken().toUpperCase());

            else
                System.out.println(st.nextToken().toLowerCase());

            count++;
        }
    }

    public void ex4() {
        Scanner sc = new Scanner(System.in);
        String input;
        System.out.println("Student 1: ex4.");
        System.out.print("Enter in a word to see if palindrome:");
        input = sc.next();

        String sb = new StringBuilder(input).reverse().toString();

        if (input.equals(sb))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public void ex5() {
        Scanner sc = new Scanner(System.in);
        String input = "", vowel = "aeiou", consonant = "bcdfghjklmnpqrstvwxyz";
        int vowelCount = 0, consantCount = 0;
        System.out.println("Student 1: ex5.");
        while (!input.equals("quit")) {
            System.out.print("Enter in a word to see constants and vowels:");
            input = sc.nextLine().toLowerCase();
            if (input.equals("quit"))
                break;

            for (int i = 0; i < input.length(); i++) {
                if (vowel.indexOf(input.charAt(i)) != -1)
                    vowelCount++;
                else if (consonant.indexOf(input.charAt(i)) != -1)
                    consantCount++;
            }

            System.out.println("The number of vowels are: " + vowelCount +
                    " and the number of constants are: " + consantCount);
            vowelCount = 0;
            consantCount = 0;
        }

    }

    public void ex6() {
        Scanner sc = new Scanner(System.in);
        int input1, input2;

        System.out.println("Student 1: ex6.");

        System.out.print("Enter first number:");
        input1 = sc.nextInt();
        System.out.print("Enter first number:");
        input2 = sc.nextInt();

        System.out.println("Result: " + (input1 + input2));
    }

    public void add(int x, int y) {
        System.out.println(x + y);
    }

    public void sub(int x, int y) {
        System.out.println(x - y);
    }

    public void div(int x, int y) {
        System.out.println(x / y);
    }

    public void mul(int x, int y) {
        System.out.println(x * y);
    }

    public void ex7() {
        Scanner sc = new Scanner(System.in);
        int input1, input2;
        String input3;
        System.out.println("Student 1: ex7.");

        System.out.print("Enter first number:");
        input1 = sc.nextInt();
        System.out.print("Enter first number:");
        input2 = sc.nextInt();
        System.out.print("Enter operation (add, sub, mul, div): ");
        input3 = sc.next();

        if (input3.equals("add"))
            add(input1, input2);
        else if (input3.equals("sub"))
            sub(input1, input2);
        else if (input3.equals("div"))
            div(input1, input2);
        else if (input3.equals("mul"))
            mul(input1, input2);
    }

    public void ex8() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the price of the carpet per square feet: ");
        double price = in.nextDouble();
        double totalArea = 0;
        double totalCost = 0;

        // neex this to clear the line
        in.nextLine();
        while (true) {
            System.out.print("Enter the width and length of a room (or \"done\" to finish): ");
            String line = in.nextLine();

            if (line.equalsIgnoreCase("done")) {
                break;
            }

            //changed this to " "
            String[] tokens = line.split(" ");
            //changed this to index 2
            System.out.println(tokens[0]);
            System.out.println(tokens[2]);
            double width = Double.parseDouble(tokens[0]);
            double length = Double.parseDouble(tokens[2]);

            double area = width * length;
            double cost = area * price;
            totalArea += area;
            totalCost += cost;
        }

        in.close();

        System.out.println("The total area of the carpet is " + totalArea + " square feet.");
        System.out.println("The total cost of the carpet installation job is $" + totalCost + ".");
    }

    public void ex9() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int input2 = 0;
        int numberToGuess = rand.nextInt(5);
        System.out.println("Student 1: ex9.");

        while (input2 != numberToGuess) {
            System.out.print("Enter a number: ");
            input2 = sc.nextInt();
            System.out.println("Try again... ");
        }
        System.out.println("You guessed it!!!");
    }

    public void ex10() {
        Scanner sc = new Scanner(System.in);
        String spaces = "", s;
        System.out.println("Student 1: ex10.");

        System.out.println("Enter a string: ");
        s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            spaces = spaces + " ";
            System.out.println(spaces + s.charAt(i));

            if (s.charAt(i) == ' ') {
                spaces = "";
            }
        }
    }

    //
    // Private helper methods
    //
    // public static void main(String[] args) {
    //     JavaOne javaTwo = new JavaOne();
    //     javaTwo.ex8();
    // }
}
