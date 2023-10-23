package com.xpanxion.assignments.student;

import java.util.ArrayList;
import java.util.Scanner;

public class JavaTwo {

    public class Person {
        private int id;
        private String firstName;
        private String lastName;

        public Person(int id, String firstName, String lastName) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return String.format("\nPerson{id='%d', firstName='%s', lastName'%s'}", id, firstName, lastName);
        }
    }

    public void ex1() {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<Person> people = new ArrayList<Person>();


        while(true) {
            System.out.print("Enter Person: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) break;
            String[] parts = input.split(", ");

            int id = Integer.parseInt(parts[0]);

            String[] nameParts = parts[1].split(" ");

            String first = nameParts[0];
            String last = nameParts[1];
            
            Person person = new Person(id, first, last);

            people.add(person);
        }

        System.out.println(people.toString().replace("[", "").replace("]", ""));
    }
    public static void main(String[] args) {
        JavaTwo javaTwo = new JavaTwo();
        javaTwo.ex1();
    }
}
