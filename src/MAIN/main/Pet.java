package MAIN.main;

// Pet class represents an animal in the veterinary system
public class Pet {
    private String name;
    private int age;          // age should be integer, not double
    private String breed;
    private String problem;

    // Constructor with parameters
    public Pet(String name, int age, String breed, String problem) {
        setName(name);
        setAge(age);
        setBreed(breed);
        setProblem(problem);
    }

    // Default constructor
    public Pet() {
        this.name = "Unknown Pet";
        this.age = 0;
        this.breed = "Unknown Breed";
        this.problem = "No Problem";
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getBreed() { return breed; }
    public String getProblem() { return problem; }

    // Setters with validation
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Pet name cannot be empty!");
            this.name = "Unknown Pet";
        }
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Error: Age cannot be negative! Setting to 0.");
            this.age = 0;
        }
    }

    public void setBreed(String breed) {
        if (breed != null && !breed.isEmpty()) {
            this.breed = breed;
        } else {
            System.out.println("Error: Breed cannot be empty!");
            this.breed = "Unknown Breed";
        }
    }

    public void setProblem(String problem) {
        if (problem != null && !problem.isEmpty()) {
            this.problem = problem;
        } else {
            System.out.println("Error: Problem cannot be empty!");
            this.problem = "No Problem";
        }
    }

    // Extra method: check problem severity
    public String checkProblem() {
        if ("rabies".equalsIgnoreCase(problem)) {
            return "Requires urgent isolation";
        } else {
            return "Can be treated normally";
        }
    }

    // Extra method: adoption or donation suggestion
    public String checkAdoption() {
        if ("mongrel".equalsIgnoreCase(breed)) {
            return "Suggest donation to animal shelter";
        } else {
            return "Eligible for adoption";
        }
    }

    // toString method for readable output
    @Override
    public String toString() {
        return "Pet{Name='" + name + "', Age=" + age +
                ", Breed='" + breed + "', Problem='" + problem + "'}";
    }
}