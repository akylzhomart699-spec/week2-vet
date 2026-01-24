package MAIN.main;

import MAIN.exception.InvalidInputException;


public class Pet {
    private String name;
    private String type;

    public Pet(String name, String type) throws InvalidInputException {
        setName(name);
        setType(type);
    }

    public void setName(String name) throws InvalidInputException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Pet name cannot be empty!");
        }
        this.name = name;
    }

    public void setType(String type) throws InvalidInputException {
        if (type == null || type.trim().isEmpty()) {
            throw new InvalidInputException("Pet type cannot be empty!");
        }
        this.type = type;
    }

    public String getName() { return name; }
    public String getType() { return type; }

    @Override
    public String toString() {
        return "Pet{Name='" + name + "', Type='" + type + "'}";
    }
}



