package MAIN.main;
import MAIN.exception.InvalidInputException;


public class Owner extends Person {
    private int id;

    public Owner(String name, int age, int id, String gender) throws InvalidInputException {
        super(name, age, gender);
        setId(id);
    }

    public Owner() {
        super();
        this.id = 0;
    }

    public void setId(int id) throws InvalidInputException {
        if (id <= 0) {
            throw new InvalidInputException("ID must be positive!");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public void introduce() {
        System.out.println("Owner " + fullName + " is here to pay for services.");
    }

    @Override
    public String toString() {
        return "Owner{Name='" + fullName + "', Age=" + age + ", Gender='" + gender + "', ID=" + id + "}";
    }
}


