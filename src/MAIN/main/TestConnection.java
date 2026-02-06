package MAIN.main;

import database.DatabaseConnection;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        System.out.println("Using URL: " + DatabaseConnection.URL);

        try (Connection con = DatabaseConnection.getConnection()) {
            System.out.println("✅ Connected to DB!");
            System.out.println("Catalog (db name): " + con.getCatalog());
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}
