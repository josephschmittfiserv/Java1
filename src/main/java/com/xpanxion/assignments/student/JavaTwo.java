package com.xpanxion.assignments.student;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

    public void ex2() {
        Scanner sc = new Scanner(System.in);
        String input;
        int idInput;
        ArrayList<Person> people = new ArrayList<Person>();
        HashMap<Integer, Person> map = new HashMap<>();


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
            map.put(id, person);
        }

        input = "";

        while(true) {
            System.out.print("Enter Person ID: ");
            idInput = sc.nextInt();
            if (input.equalsIgnoreCase("done")) break;

            System.out.println(map.get(idInput).toString());
        }

    }

    public class Product extends Base{
        private String item;
        private double price;

        public Product(int id, String item, double price) {
            super(id);
            this.item = item;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getItem() {
            return item;
        }

        public double getPrice() {
            return price;
        }


    }

    public class Invoice extends Base{
        private ArrayList<Product> products;

        public Invoice(int id) {
            super(id);
            this.products = new ArrayList<>();
        }

        public void addProduct(Product product) {
            this.products.add(product);
        }

        public double getTotalCost() {
            return products.stream().mapToDouble(Product::getPrice).sum();
        }
    }

    public abstract class Base {
        private int id;

        public Base(int id) {
            this.id = id;
        }

        public int getId() {
            return this.id;
        }
    }

    public void ex3() {
        var invoice =  new Invoice(1);
        invoice.addProduct(new Product(111,"Mustard", 2.00));
        invoice.addProduct(new Product(222,"Ketchup", 3.00));
        invoice.addProduct(new Product(333,"Franks Hot Sauce", 4.00));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total cost: " + formatter.format(invoice.getTotalCost()));
    }


    public static void main(String[] args) {
        JavaTwo javaTwo = new JavaTwo();
        javaTwo.ex3();
    }
}
