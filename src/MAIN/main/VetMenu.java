package MAIN.main;

import java.util.ArrayList;
import java.util.Scanner;

public class VetMenu implements Menu {
    private ArrayList<Person> people;
    private Scanner scanner;

    public VetMenu() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);

        try {
            people.add(new Owner("Maduro", 25, 101, "male"));
            people.add(new Veterinarian("Aigerim", 30, "female", "Surgery", 5));
        } catch (InvalidInputException e) {
            System.out.println(" Error creating test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== VETERINARY SYSTEM MENU ===");
        System.out.println("1. Show all people");
        System.out.println("2. Demonstrate polymorphism");
        System.out.println("3. Add new Owner");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter choice: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> showAll();
                    case 2 -> demonstratePolymorphism();
                    case 3 -> addOwner();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println(" Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void showAll() {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    private void demonstratePolymorphism() {
        for (Person p : people) {
            p.introduce();
        }
    }

    private void addOwner() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Owner newOwner = new Owner(name, age, id, gender);
            people.add(newOwner);
            System.out.println(" New owner added: " + newOwner);

        } catch (InvalidInputException e) {
            System.out.println(" Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" General error: " + e.getMessage());
            scanner.nextLine();
        }
    }
}


