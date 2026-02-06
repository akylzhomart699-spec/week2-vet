package MAIN.main;

import java.sql.*;

public class DebugConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres"; // базовая db почти всегда есть
        String user = "postgres";
        String pass = "1234";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement()) {

            ResultSet rs = st.executeQuery(
                    "SELECT current_database(), inet_server_addr(), inet_server_port()");
            if (rs.next()) {
                System.out.println("Connected OK!");
                System.out.println("DB: " + rs.getString(1));
                System.out.println("ADDR: " + rs.getString(2));
                System.out.println("PORT: " + rs.getInt(3));
            }

            System.out.println("\nDatabases visible to THIS connection:");
            ResultSet rs2 = st.executeQuery("SELECT datname FROM pg_database ORDER BY datname");
            while (rs2.next()) {
                System.out.println(" - " + rs2.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
