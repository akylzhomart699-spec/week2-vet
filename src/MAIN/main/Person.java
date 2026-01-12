package MAIN.main;

public abstract class Person {
    protected String fullName;
    protected int age;
    protected String gender;

    public Person(String fullName, int age, String gender) throws InvalidInputException {
        setFullName(fullName);
        setAge(age);
        setGender(gender);
    }

    public Person() {
        this.fullName = "Unknown";
        this.age = 0;
        this.gender = "Unknown";
    }

    public void setFullName(String fullName) throws InvalidInputException {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new InvalidInputException("Name cannot be empty!");
        }
        this.fullName = fullName;
    }

    public void setAge(int age) throws InvalidInputException {
        if (age < 0) {
            throw new InvalidInputException("Age cannot be negative!");
        }
        this.age = age;
    }

    public void setGender(String gender) throws InvalidInputException {
        if (gender == null || gender.trim().isEmpty()) {
            throw new InvalidInputException("Gender cannot be empty!");
        }
        this.gender = gender;
    }

    public abstract void introduce();

    @Override
    public String toString() {
        return "Person{Name='" + fullName + "', Age=" + age + ", Gender='" + gender + "'}";
    }
}
