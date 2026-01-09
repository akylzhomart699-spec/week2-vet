package MAIN.main;

// Owner class represents a pet owner in the veterinary system
public class Owner extends Person {
    // Private field specific to Owner
    private int id;

    // Constructor with parameters
    public Owner(String name, int age, int id, String gender) {
        super(name, age, gender); // call parent constructor
        setId(id);                // validate ID
    }

    // Default constructor
    public Owner() {
        super(); // calls default constructor of Person
        this.id = 0;
    }

    // Getter
    public int getId() { return id; }

    // Setter with validation
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Error: ID must be positive! Setting to 0.");
            this.id = 0;
        }
    }

    // Extra methods for demonstration
    public String checkSex() {
        if ("female".equalsIgnoreCase(gender)) {
            return "Treat someone to tea";
        } else {
            return "Nothing special";
        }
    }

    public String checkSex2() {
        if ("female".equalsIgnoreCase(gender)) {
            return "Without waiting in line";
        } else {
            return "Wait in line";
        }
    }

    // Overridden method from Person
    @Override
    public void introduce() {
        System.out.println("Owner " + fullName + " is here to pay for services.");
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "Owner{Name='" + fullName + "', Age=" + age +
                ", Gender='" + gender + "', ID=" + id + "}";
    }
}