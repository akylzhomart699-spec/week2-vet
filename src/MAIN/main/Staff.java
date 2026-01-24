package MAIN.main;
import MAIN.exception.InvalidInputException;

import MAIN.main.Person;

public class Staff extends Person {
    private String position; // должность сотрудника

    public Staff(String fullName, int age, String gender, String position) throws InvalidInputException {
        super(fullName, age, gender);
        setPosition(position);
    }

    public void setPosition(String position) throws InvalidInputException {
        if (position == null || position.trim().isEmpty()) {
            throw new InvalidInputException("Position cannot be empty!");
        }
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void introduce() {
        System.out.println("Staff member " + fullName + " works as " + position + ".");
    }

    @Override
    public String toString() {
        return "Staff{Name='" + fullName + "', Age=" + age + ", Gender='" + gender + "', Position='" + position + "'}";
    }
}
