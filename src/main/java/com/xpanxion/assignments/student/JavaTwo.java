package com.xpanxion.assignments.student;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.concurrent.TimeUnit;

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

        public String setLastName(String lastName) {
            return this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return String.format("\nPerson{id='%d', firstName='%s', lastName'%s'}", id,
                    firstName, lastName);
        }
    }

    public void ex1() {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<Person> people = new ArrayList<Person>();

        while (true) {
            System.out.print("Enter Person: ");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("done"))
                break;
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

    // public void ex2() {
    // Scanner sc = new Scanner(System.in);
    // String input;
    // int idInput;
    // ArrayList<Person> people = new ArrayList<Person>();
    // HashMap<Integer, Person> map = new HashMap<>();

    // while(true) {
    // System.out.print("Enter Person: ");
    // input = sc.nextLine();
    // if (input.equalsIgnoreCase("done")) break;
    // String[] parts = input.split(", ");

    // int id = Integer.parseInt(parts[0]);

    // String[] nameParts = parts[1].split(" ");

    // String first = nameParts[0];
    // String last = nameParts[1];

    // Person person = new Person(id, first, last);

    // people.add(person);
    // map.put(id, person);
    // }

    // input = "";

    // while(true) {
    // System.out.print("Enter Person ID: ");
    // idInput = sc.nextInt();
    // if (input.equalsIgnoreCase("done")) break;

    // System.out.println(map.get(idInput).toString());
    // }

    // }

    public class Product extends Base {
        private String item;
        private double price;

        public Product(int id, String item, double price) {
            super(id);
            this.item = item;
            this.price = price;
        }

        public int getId() {
            return getId();
        }

        public String getItem() {
            return item;
        }

        public double getPrice() {
            return price;
        }

    }

    public class Invoice extends Base {
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

    // aka ex. 4
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
        var invoice = new Invoice(1);
        invoice.addProduct(new Product(111, "Mustard", 2.00));
        invoice.addProduct(new Product(222, "Ketchup", 3.00));
        invoice.addProduct(new Product(333, "Franks Hot Sauce", 4.00));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Total cost: " + formatter.format(invoice.getTotalCost()));
    }

    // interface DataAccess {
    // Person getPerson();
    // }

    // class Person {
    // private int id;
    // private String name;

    // public Person(int id, String name) {
    // this.id = id;
    // this.name = name;
    // }

    // @Override
    // public String toString() {
    // String[] names = new String[3];
    // names = name.split(" ", 2);
    // return String.format("\nPerson{id='%d', \nfirstName='%s', \nlastName='%s'}",
    // id, names[0], names[1]);
    // }
    // }

    // class Repository implements DataAccess {
    // private Map<Integer, Person> personMap;

    // public Repository() {
    // personMap = new HashMap<>();
    // personMap.put(1, new Person(1, "John Doe"));
    // }

    // @Override
    // public Person getPerson() {
    // return personMap.get(1);
    // }
    // }

    // public void ex5() {
    // var repository = new Repository();
    // var p = repository.getPerson();
    // System.out.println(p);
    // }

    public class Calculator {
        private ArrayList<String> strArr = new ArrayList<>();

        public void add(int x, int y) {
            strArr.add(x + " + " + y + " = " + (x + y));
            System.out.println("Result: " + (x + y));
        }

        public void sub(int x, int y) {
            strArr.add(x + " - " + y + " = " + (x - y));
            System.out.println("Result: " + (x - y));
        }

        public void div(int x, int y) {
            strArr.add(x + " / " + y + " = " + (x / y));
            System.out.println("Result: " + (x / y));
        }

        public void mul(int x, int y) {
            strArr.add(x + " * " + y + " = " + (x * y));
            System.out.println("Result: " + (x * y));
        }

    }

    public void ex6() {
        Scanner sc = new Scanner(System.in);
        String input1, input2;
        String input3;
        Calculator calc = new Calculator();

        while (true) {
            System.out.print("Enter first number:");
            input1 = sc.nextLine();
            if (input1.equals("done")) {
                break;
            }

            System.out.print("Enter second number:");
            input2 = sc.nextLine();
            if (input2.equals("done")) {
                break;
            }

            System.out.print("Enter operation (add, sub, mul, div): ");
            input3 = sc.nextLine();
            if (input3.equals("done")) {
                break;
            }

            if (input3.equals("add"))
                calc.add(Integer.parseInt(input1), Integer.parseInt(input2));
            else if (input3.equals("sub"))
                calc.sub(Integer.parseInt(input1), Integer.parseInt(input2));
            else if (input3.equals("div"))
                calc.div(Integer.parseInt(input1), Integer.parseInt(input2));
            else if (input3.equals("mul"))
                calc.mul(Integer.parseInt(input1), Integer.parseInt(input2));
        }

        for (String item : calc.strArr) {
            System.out.println(item);
        }
    }

    public void ex7() {
        var personList = Arrays.asList(
                new Person(1, "Peter", "Jones"),
                new Person(2, "John", "Smith"),
                new Person(3, "Sue", "Anderson"));

                List<Person> newPersonList = personList.stream().map(person -> new Person(person.getId(), person.getFirstName(), "xxx")).collect(Collectors.toList());

        System.out.println(newPersonList);
    }

    public void ex8() {
        var personList = Arrays.asList(
                new Person(1, "Charlie", "Jones"),
                new Person(2, "Zoey", "Smith"),
                new Person(3, "Adam", "Anderson"));
        personList.sort(Comparator.comparing(Person::getFirstName));

        System.out.println(personList);
    }


    public void ex9() {
        var personList = Arrays.asList(
                new Person(1, "Charlie", "Jones"),
                new Person(2, "Zoey", "Smith"),
                new Person(3, "Adam", "Anderson"));

        List<Person> filteredList = personList.stream()
                .filter(p -> p.getLastName().equals("Smith"))
                .collect(Collectors.toList());

        for (Person p : filteredList) {
            System.out.println(p);
        } 
    }

    public class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public void getName() {
            System.out.println(this.name);
        }
    }

    public void ex10() {
        Queue<Cat> queue = new LinkedList<>();

        Cat cat1 = new Cat("Alice");
        Cat cat2 = new Cat("Bob");
        Cat cat3 = new Cat("Charlie");
        Cat cat4 = new Cat("Dan");

        queue.add(cat1);
        queue.add(cat2);
        queue.add(cat3);
        queue.add(cat4);

        while(!queue.isEmpty()) {
            for (Cat item : queue) {
                item.getName();
            }
            queue.remove();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println();
        }

        

    }
    public static void main(String[] args) {
        JavaTwo javaTwo = new JavaTwo();
        javaTwo.ex7();
    }
}


