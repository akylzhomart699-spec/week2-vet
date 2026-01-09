package MAIN.main;

public class main_vet {
    public static void main(String[] args) {
        // --- Create objects ---
        Owner owner = new Owner("Islambek", 25, 101, "male");
        Veterinarian vet = new Veterinarian("Aigerim", 30, "female", "Surgery", 5);
        Pet pet = new Pet("Barsik", -3, "Persian", ""); // invalid values to show validation
        Service service = new Service("Vaccination", 1.5, "big", "calm", 5000f);

        // --- Print all objects ---
        System.out.println("=== Objects ===");
        System.out.println(owner);
        System.out.println(vet);
        System.out.println(pet);
        System.out.println(service);

        // --- Polymorphism demonstration ---
        System.out.println("\n=== Polymorphism ===");
        Person[] people = { owner, vet }; // one array for different child types
        for (Person p : people) {
            p.introduce(); // overridden differently in Owner and Veterinarian
        }

        // --- Encapsulation (validation in setters) ---
        System.out.println("\n=== Encapsulation (validation) ===");
        owner.setId(-5); // invalid ID triggers validation
        System.out.println("After invalid ID: " + owner);

        pet.setAge(-2); // invalid age triggers validation
        System.out.println("After invalid age: " + pet);

        // --- instanceof and downcasting ---
        System.out.println("\n=== instanceof and downcasting ===");
        if (owner instanceof Owner o) {
            System.out.println("Found Owner: " + o.getFullName() + ", ID=" + o.getId());
            System.out.println("checkSex: " + o.checkSex());
            System.out.println("checkSex2: " + o.checkSex2());
        }
    }
}