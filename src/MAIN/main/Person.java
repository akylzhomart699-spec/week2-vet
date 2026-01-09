package MAIN.main;

public class Person {
    // Protected fields: accessible in child classes but hidden from outside
    protected String fullName;
    protected int age;
    protected String gender; // extra field for demonstration

    // Constructor with parameters
    public Person(String fullName, int age, String gender) {
        setFullName(fullName);   // validation inside setter
        setAge(age);             // validation inside setter
        setGender(gender);       // validation inside setter
    }

    // Default constructor
    public Person() {
        this.fullName = "Unknown Person"; // default name
        this.age = 0;                     // default age
        this.gender = "Unknown";          // default gender
    }

    // Getters: allow controlled access to protected fields
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    // Setters with validation logic
    public void setFullName(String fullName) {
        // Name cannot be empty
        if (fullName != null && !fullName.isEmpty()) {
            this.fullName = fullName;
        } else {
            System.out.println("Error: Name cannot be empty!");
            this.fullName = "Unknown Person"; // fallback value
        }
    }

    public void setAge(int age) {
        // Age must be non-negative, otherwise set to 0
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Error: Age cannot be negative! Setting to 0.");
            this.age = 0;
        }
    }

    public void setGender(String gender) {
        // Gender cannot be empty
        if (gender != null && !gender.isEmpty()) {
            this.gender = gender;
        } else {
            System.out.println("Error: Gender cannot be empty!");
            this.gender = "Unknown"; // fallback value
        }
    }

    // Extra method for demonstration
    public void introduce() {
        System.out.println("Hello, my name is " + fullName +
                ", I am " + age + " years old, gender: " + gender + ".");
    }

    // toString method: returns object info in readable format
    @Override
    public String toString() {
        return "Person{Name='" + fullName + "', Age=" + age + ", Gender='" + gender + "'}";
    }
}