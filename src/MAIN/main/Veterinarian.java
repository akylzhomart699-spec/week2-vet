package MAIN.main;
import MAIN.exception.InvalidInputException;


public class Veterinarian extends Person implements Treatable {
    private String specialization;
    private int experienceYears;
    private double totalBonus;

    public Veterinarian(String fullName, int age, String gender, String specialization, int experienceYears) throws InvalidInputException {
        super(fullName, age, gender);
        setSpecialization(specialization);
        setExperienceYears(experienceYears);
        this.totalBonus = 0;
    }

    public void setSpecialization(String specialization) throws InvalidInputException {
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidInputException("Specialization cannot be empty!");
        }
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) throws InvalidInputException {
        if (experienceYears < 0) {
            throw new InvalidInputException("Experience cannot be negative!");
        }
        this.experienceYears = experienceYears;
    }

    public void addServiceBonus(double amount) throws InvalidInputException {
        if (amount <= 0) {
            throw new InvalidInputException("Bonus must be positive!");
        }
        totalBonus += amount;
    }

    @Override
    public void introduce() {
        System.out.println("Veterinarian " + fullName + " specializes in " + specialization + ".");
    }

    @Override
    public void treat(Pet pet) {
        System.out.println("Veterinarian " + fullName + " treats pet " + pet.getName());
    }

    @Override
    public String toString() {
        return "Veterinarian{Name='" + fullName + "', Age=" + age + ", Gender='" + gender +
                "', Specialization='" + specialization + "', ExperienceYears=" + experienceYears +
                ", TotalBonus=$" + totalBonus + "}";
    }
}



