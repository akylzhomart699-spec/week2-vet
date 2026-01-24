package Menu;

import java.util.ArrayList;
import java.util.Scanner;
import MAIN.exception.InvalidInputException;
import MAIN.main.Owner;
import MAIN.main.Person;
import MAIN.main.Veterinarian;
import MAIN.main.Staff;

public class VetMenu implements Menu {
    private ArrayList<Person> people;
    private Scanner scanner;

    public VetMenu() {
        people = new ArrayList<>();
        scanner = new Scanner(System.in);

        try {
            people.add(new Owner("Maduro", 25, 101, "male"));
            people.add(new Veterinarian("Aigerim", 30, "female", "Surgery", 5));
            people.add(new Staff("Dana", 28, "female", "Receptionist"));
        } catch (InvalidInputException e) {
            System.out.println("❌ Error creating test data: " + e.getMessage());
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("     VETERINARY CLINIC MANAGEMENT");
        System.out.println("========================================");
        System.out.println("1. View All People");
        System.out.println("2. Demonstrate Polymorphism");
        System.out.println("3. Add New Owner");
        System.out.println("4. Add New Veterinarian");
        System.out.println("5. Add New Staff");
        System.out.println("6. View Owners Only");
        System.out.println("7. View Veterinarians Only");
        System.out.println("8. View Staff Only");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number!");
                continue;
            }

            switch (choice) {
                case 1 -> showAll();
                case 2 -> demonstratePolymorphism();
                case 3 -> addOwner();
                case 4 -> addVeterinarian();
                case 5 -> addStaff();
                case 6 -> viewOwnersOnly();
                case 7 -> viewVeterinariansOnly();
                case 8 -> viewStaffOnly();
                case 0 -> {
                    System.out.println("Exiting program...");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
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

    private void viewOwnersOnly() {
        for (Person p : people) {
            if (p instanceof Owner) {
                System.out.println(p);
            }
        }
    }

    private void viewVeterinariansOnly() {
        for (Person p : people) {
            if (p instanceof Veterinarian) {
                System.out.println(p);
            }
        }
    }

    private void viewStaffOnly() {
        for (Person p : people) {
            if (p instanceof Staff) {
                System.out.println(p);
            }
        }
    }

    private void addOwner() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Owner newOwner = new Owner(name, age, id, gender);
            people.add(newOwner);
            System.out.println("✅ New owner added: " + newOwner);

        } catch (InvalidInputException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter valid numeric values for age and ID!");
        }
    }

    private void addVeterinarian() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter specialization: ");
            String specialization = scanner.nextLine();

            System.out.print("Enter years of experience: ");
            int experienceYears = Integer.parseInt(scanner.nextLine());

            Veterinarian newVet = new Veterinarian(name, age, gender, specialization, experienceYears);
            people.add(newVet);
            System.out.println("✅ New veterinarian added: " + newVet);

        } catch (InvalidInputException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter valid numeric values for age and experience!");
        }
    }

    private void addStaff() {
        try {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            System.out.print("Enter position: ");
            String position = scanner.nextLine();

            Staff newStaff = new Staff(name, age, gender, position);
            people.add(newStaff);
            System.out.println("✅ New staff added: " + newStaff);

        } catch (InvalidInputException e) {
            System.out.println("❌ Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("❌ Please enter valid numeric values for age!");
        }
    }
}
