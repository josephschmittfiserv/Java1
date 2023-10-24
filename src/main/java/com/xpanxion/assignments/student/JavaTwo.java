package com.xpanxion.assignments.student;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    return lastName;
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
    //     Person getPerson();
    // }

    // class Person {
    //     private int id;
    //     private String name;

    //     public Person(int id, String name) {
    //         this.id = id;
    //         this.name = name;
    //     }

    //     @Override
    //     public String toString() {
    //         String[] names = new String[3];
    //         names = name.split(" ", 2);
    //         return String.format("\nPerson{id='%d', \nfirstName='%s', \nlastName='%s'}", id, names[0], names[1]);
    //     }
    // }

    // class Repository implements DataAccess {
    //     private Map<Integer, Person> personMap;

    //     public Repository() {
    //         personMap = new HashMap<>();
    //         personMap.put(1, new Person(1, "John Doe"));
    //     }

    //     @Override
    //     public Person getPerson() {
    //         return personMap.get(1);
    //     }
    // }

    // public void ex5() {
    //     var repository = new Repository();
    //     var p = repository.getPerson();
    //     System.out.println(p);
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

        personList.stream().map(e -> e.setLastName("xxx")).collect(Collectors.toList());
        

        System.out.println(personList);
    }

    public static void main(String[] args) {
        JavaTwo javaTwo = new JavaTwo();
        javaTwo.ex7();
    }
}
