package Menu;

import database.PersonDAO;
import java.util.Scanner;

public class VetMenu implements Menu {

    private final Scanner scanner;
    private final PersonDAO personDAO;

    public VetMenu() {
        scanner = new Scanner(System.in);
        personDAO = new PersonDAO();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("     VETERINARY CLINIC (WEEK 8, DB)");
        System.out.println("========================================");
        System.out.println("1. Add Person (CREATE)");
        System.out.println("2. View All People (READ)");
        System.out.println("3. View People by Gender");
        System.out.println("4. View People by Age Range (BETWEEN)");
        System.out.println("5. Update Person (Safe)");
        System.out.println("6. Delete Person (Safe, confirm yes/no)");
        System.out.println("7. Search by Name (ILIKE)");
        System.out.println("8. Search by ID");
        System.out.println("9. High Age People (age >= X)");
        System.out.println("10. Count People");
        System.out.println("11. Polymorphism Info");
        System.out.println("12. Update Person (Direct Full Input)");
        System.out.println("13. Delete Person (Direct Confirm y/n)");
        System.out.println("0. Exit");
        System.out.println("========================================");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Please enter a valid number!");
                continue;
            }

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> personDAO.getAllPersons();
                case 3 -> viewByGender();
                case 4 -> viewByAgeRange();
                case 5 -> updatePersonSafe();
                case 6 -> deletePersonSafe();
                case 7 -> searchByName();
                case 8 -> searchById();
                case 9 -> searchByMinAge();
                case 10 -> countPeople();
                case 11 -> polymorphismInfo();
                case 12 -> updatePersonDirect();
                case 13 -> deletePersonDirect();
                case 0 -> {
                    System.out.println("Exiting...");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    // ===================== ADD =====================
    private void addPerson() {
        try {
            System.out.print("Enter full name: ");
            String fullname = scanner.nextLine();

            System.out.print("Enter age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter gender: ");
            String gender = scanner.nextLine();

            boolean ok = personDAO.insertPerson(fullname, age, gender);
            System.out.println(ok ? "✅ Saved to DB" : "❌ Not saved");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== VIEW BY GENDER =====================
    private void viewByGender() {
        System.out.print("Enter gender: ");
        String g = scanner.nextLine();
        personDAO.searchByGender(g);
    }

    // ===================== VIEW BY AGE RANGE =====================
    private void viewByAgeRange() {
        try {
            System.out.print("Min age: ");
            int min = Integer.parseInt(scanner.nextLine());
            System.out.print("Max age: ");
            int max = Integer.parseInt(scanner.nextLine());

            personDAO.searchByAgeRange(min, max);

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== SAFE UPDATE (show current + keep fields) =====================
    private void updatePersonSafe() {
        try {
            System.out.print("Enter person ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            String current = personDAO.getPersonById(id);
            if (current == null) {
                System.out.println("❌ No person found with ID: " + id);
                return;
            }

            System.out.println("Current person:");
            System.out.println(current);

            System.out.print("New full name (press Enter to keep): ");
            String fullname = scanner.nextLine();

            System.out.print("New age (press Enter to keep): ");
            String ageInput = scanner.nextLine();

            System.out.print("New gender (press Enter to keep): ");
            String gender = scanner.nextLine();

            // current format: "id | fullname | age | gender"
            String[] parts = current.split("\\s\\|\\s");
            String oldName = parts[1];
            int oldAge = Integer.parseInt(parts[2]);
            String oldGender = parts[3];

            String finalName = fullname.trim().isEmpty() ? oldName : fullname;
            int finalAge = ageInput.trim().isEmpty() ? oldAge : Integer.parseInt(ageInput);
            String finalGender = gender.trim().isEmpty() ? oldGender : gender;

            boolean ok = personDAO.updatePerson(id, finalName, finalAge, finalGender);
            System.out.println(ok ? "✅ Updated (Safe)!" : "❌ Update failed!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== SAFE DELETE (preview + yes/no) =====================
    private void deletePersonSafe() {
        try {
            System.out.print("Enter person ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            String current = personDAO.getPersonById(id);
            if (current == null) {
                System.out.println("❌ No person found with ID: " + id);
                return;
            }

            System.out.println("Person to delete:");
            System.out.println(current);

            System.out.print("⚠️ Are you sure? (yes/no): ");
            String confirm = scanner.nextLine();

            if (!confirm.equalsIgnoreCase("yes")) {
                System.out.println("❌ Deletion cancelled.");
                return;
            }

            boolean ok = personDAO.deletePerson(id);
            System.out.println(ok ? "✅ Deleted!" : "❌ Delete failed!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== SEARCH NAME =====================
    private void searchByName() {
        System.out.print("Enter name to search: ");
        personDAO.searchByName(scanner.nextLine());
    }

    // ===================== SEARCH ID =====================
    private void searchById() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            String p = personDAO.getPersonById(id);
            System.out.println(p == null ? "❌ Not found" : p);

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== MIN AGE =====================
    private void searchByMinAge() {
        try {
            System.out.print("Enter min age: ");
            int min = Integer.parseInt(scanner.nextLine());
            personDAO.searchByMinAge(min);
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== COUNT =====================
    private void countPeople() {
        System.out.println("✅ Total people in DB: " + personDAO.countPeople());
    }

    // ===================== POLYMORPHISM INFO =====================
    private void polymorphismInfo() {
        System.out.println("""
✅ Polymorphism note:
Project has Owner/Staff/Veterinarian classes.
DB table 'person' currently stores base fields (fullname, age, gender).
To reconstruct subclasses from DB you would add a 'role' column.
""");
    }

    // ===================== UPDATE #2 DIRECT (full input) =====================
    private void updatePersonDirect() {
        try {
            System.out.print("Enter person ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter NEW full name: ");
            String fullname = scanner.nextLine();

            System.out.print("Enter NEW age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter NEW gender: ");
            String gender = scanner.nextLine();

            boolean ok = personDAO.updatePersonDirect(id, fullname, age, gender);
            System.out.println(ok ? "✅ Updated (Direct)!" : "❌ Update failed!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }

    // ===================== DELETE #2 DIRECT (y/n) =====================
    private void deletePersonDirect() {
        try {
            System.out.print("Enter person ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Confirm delete (y/n): ");
            String confirm = scanner.nextLine();

            if (!confirm.equalsIgnoreCase("y")) {
                System.out.println("❌ Deletion cancelled.");
                return;
            }

            boolean ok = personDAO.deletePersonDirect(id);
            System.out.println(ok ? "✅ Deleted (Direct)!" : "❌ Delete failed!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
        }
    }
}


