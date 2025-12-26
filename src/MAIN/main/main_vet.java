package MAIN.main;

public class main_vet {
    public static void main(String[] args) {

        System.out.println("=== Vet Clinics Astana ===\n");

        Pat pet1 = new Pat("Rex", 7, "mongrel", "rabies");
        Owner owner1 = new Owner("Trump", 25, 1, "Male");
        Service service1 = new Service("Wash", 0.5, "big", "middle", 12000);

        System.out.println("--- INITIAL STATE ---");
        System.out.println(pet1);
        System.out.println(owner1);
        System.out.println(service1);
        System.out.println();

        System.out.println("--- TESTING GETTERS ---");
        System.out.println("Pet name: " + pet1.getName());
        System.out.println("Owner name: " + owner1.getName());
        System.out.println("Service price: " + service1.getPrice());
        System.out.println();

        System.out.println("--- TESTING SETTERS ---");
        pet1.setProblem("injury");
        owner1.setsex("Female");
        service1.setprice(15000);

        System.out.println("Updated pet: " + pet1);
        System.out.println("Updated owner: " + owner1);
        System.out.println("Updated service: " + service1);
        System.out.println();

        System.out.println("--- TESTING ADDITIONAL METHODS ---");
        System.out.println("Pet decision: " + pet1.check_problem(pet1.getProblem()));
        System.out.println("Pet selling: " + pet1.chek_sell());
        System.out.println("Owner privilege: " + owner1.check_sex());
        System.out.println("Queue status: " + owner1.check_sex2());
        System.out.println("Service price type: " + service1.chek_size());
        System.out.println("Discount applied: " + service1.apply_discount(owner1.getSex()));
        System.out.println();

        System.out.println("--- FINAL SUMMARY ---");
        System.out.println(pet1);
        System.out.println(owner1);
        System.out.println(service1);

        System.out.println("\n=== Program Complete ===");
    }
}
