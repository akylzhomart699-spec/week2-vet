package database;

import java.sql.*;

public class PersonDAO {

    // ===================== CREATE =====================
    public boolean insertPerson(String fullname, int age, String gender) {
        String sql = "INSERT INTO person(fullname, age, gender) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fullname);
            ps.setInt(2, age);
            ps.setString(3, gender);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===================== READ ALL =====================
    public void getAllPersons() {
        String sql = "SELECT * FROM person ORDER BY id";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- PERSONS FROM DB ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("fullname") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== READ BY ID =====================
    public String getPersonById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("id") + " | " +
                        rs.getString("fullname") + " | " +
                        rs.getInt("age") + " | " +
                        rs.getString("gender");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ===================== UPDATE #1 (Safe flow uses this) =====================
    // Same SQL, but your MENU does "safe logic" (show current + keep fields).
    public boolean updatePerson(int id, String fullname, int age, String gender) {
        String sql = "UPDATE person SET fullname = ?, age = ?, gender = ? WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fullname);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===================== UPDATE #2 (Direct / Full Input) =====================
    public boolean updatePersonDirect(int id, String fullname, int age, String gender) {
        String sql = "UPDATE person SET fullname = ?, age = ?, gender = ? WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fullname);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===================== DELETE #1 (Safe: preview + yes/no in MENU) =====================
    public boolean deletePerson(int id) {
        String sql = "DELETE FROM person WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===================== DELETE #2 (Direct: simple confirm y/n) =====================
    public boolean deletePersonDirect(int id) {
        String sql = "DELETE FROM person WHERE id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===================== SEARCH BY NAME (ILIKE) =====================
    public void searchByName(String namePart) {
        String sql = "SELECT * FROM person WHERE fullname ILIKE ? ORDER BY fullname";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + namePart + "%");
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- SEARCH RESULTS ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("fullname") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== SEARCH BY AGE RANGE =====================
    public void searchByAgeRange(int minAge, int maxAge) {
        String sql = "SELECT * FROM person WHERE age BETWEEN ? AND ? ORDER BY age DESC";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, minAge);
            ps.setInt(2, maxAge);

            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- AGE RANGE RESULTS ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("fullname") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== SEARCH BY MIN AGE (>=) =====================
    public void searchByMinAge(int minAge) {
        String sql = "SELECT * FROM person WHERE age >= ? ORDER BY age DESC";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, minAge);

            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- MIN AGE RESULTS ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("fullname") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== SEARCH BY GENDER =====================
    public void searchByGender(String gender) {
        String sql = "SELECT * FROM person WHERE gender ILIKE ? ORDER BY fullname";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, gender);

            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- GENDER RESULTS ---");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("fullname") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("gender")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ===================== COUNT =====================
    public int countPeople() {
        String sql = "SELECT COUNT(*) FROM person";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

