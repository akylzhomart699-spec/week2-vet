package MAIN.main;

import java.util.Scanner;

public class main_vet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Создание объектов
        Owner owner = new Owner("Maduro", 25, 101, "male");
        Veterinarian vet = new Veterinarian("Aigerim", 30, "female", "Surgery", 5);
        Pet pet = new Pet("Barsik", -3, "Persian", "");
        Service service = new Service("Vaccination", 1.5, "big", "calm", 5000f);
        Person o1 = new Owner("Madara", 25, 101, "male");

        int choice;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Show all objects");
            System.out.println("2. Demonstrate polymorphism");
            System.out.println("3. Test validation");
            System.out.println("4. Downcasting demo");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- OBJECTS ---");
                    System.out.println(owner);
                    System.out.println(vet);
                    System.out.println(pet);
                    System.out.println(service);
                    break;

                case 2:
                    System.out.println("\n--- POLYMORPHISM ---");
                    Person[] people = { owner, vet };
                    for (Person p : people) {
                        p.introduce(); // overridden
                    }
                    break;

                case 3:
                    System.out.println("\n--- VALIDATION TEST ---");
                    owner.setId(-5);
                    pet.setAge(-2);
                    System.out.println("Owner after invalid ID: " + owner);
                    System.out.println("Pet after invalid age: " + pet);
                    break;

                case 4:
                    System.out.println("\n--- DOWNCASTING ---");
                    if (owner instanceof Owner o) {

                        System.out.println("Owner name: " + o1.getFullName());
                        System.out.println("checkSex: " + o.checkSex());
                        System.out.println("checkSex2: " + o.checkSex2());
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 0);
    }
}
