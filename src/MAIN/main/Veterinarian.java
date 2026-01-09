package MAIN.main;

public class Veterinarian extends Person {
    // Private fields specific to Veterinarian
    private String specialization;   // e.g. "Surgery", "Dentistry"
    private int experienceYears;     // years of practice
    private double totalBonus;       // bonus earned from services

    // Constructor with parameters
    public Veterinarian(String fullName, int age, String gender, String specialization, int experienceYears) {
        super(fullName, age, gender); // call parent constructor
        this.specialization = specialization;
        setExperienceYears(experienceYears); // validation inside setter
        this.totalBonus = 0;
    }

    // Default constructor
    public Veterinarian() {
        super(); // calls default constructor of Person
        this.specialization = "General";
        this.experienceYears = 0;
        this.totalBonus = 0;
    }

    // Getters
    public String getSpecialization() { return specialization; }
    public int getExperienceYears() { return experienceYears; }
    public double getTotalBonus() { return totalBonus; }

    // Setters with validation
    public void setSpecialization(String specialization) {
        if (specialization != null && !specialization.isEmpty()) {
            this.specialization = specialization;
        } else {
            System.out.println("Error: Specialization cannot be empty!");
            this.specialization = "General";
        }
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        } else {
            System.out.println("Error: Experience cannot be negative! Setting to 0.");
            this.experienceYears = 0;
        }
    }

    // Method to add bonus from completed services
    public void addServiceBonus(double amount) {
        if (amount > 0) {
            totalBonus += amount;
        } else {
            System.out.println("Error: Bonus amount must be positive!");
        }
    }

    // toString method for readable output
    @Override
    public String toString() {
        return "Veterinarian{Name='" + fullName +
                "', Age=" + age +
                ", Gender='" + gender +
                "', Specialization='" + specialization +
                "', ExperienceYears=" + experienceYears +
                ", TotalBonus=$" + totalBonus + "}";
    }
}