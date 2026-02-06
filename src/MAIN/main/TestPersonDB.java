package MAIN.main;

import database.PersonDAO;

public class TestPersonDB {
    public static void main(String[] args) {

        PersonDAO dao = new PersonDAO();

        dao.insertPerson("Maduro", 25, "male");
        dao.insertPerson("Aigerim", 30, "female");

        dao.getAllPersons();
    }
}
