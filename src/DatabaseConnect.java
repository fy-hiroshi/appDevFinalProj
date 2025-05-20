import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConnect {
    private final DatabaseInfo dbInfo;

    public DatabaseConnect(DatabaseInfo dbInfo) {
        this.dbInfo = dbInfo;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbInfo.getDatabaseUrl(), dbInfo.getUsername(), dbInfo.getPassword());
    }

    public boolean addStudent(String name, double science, double english, double math, double mapeh,
            double filipino, double esp, double ap, double average) {
        String query = "INSERT INTO students (name, science, english, math, mapeh, filipino, esp, ap, average) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setDouble(2, science);
            stmt.setDouble(3, english);
            stmt.setDouble(4, math);
            stmt.setDouble(5, mapeh);
            stmt.setDouble(6, filipino);
            stmt.setDouble(7, esp);
            stmt.setDouble(8, ap);
            stmt.setDouble(9, average);

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getAllStudents() {
        ArrayList<String> studentList = new ArrayList<>();
        String query = "SELECT * FROM students";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Name: ").append(rs.getString("name")).append("\n");
                sb.append("Science: ").append(rs.getDouble("science")).append("\n");
                sb.append("English: ").append(rs.getDouble("english")).append("\n");
                sb.append("Math: ").append(rs.getDouble("math")).append("\n");
                sb.append("MAPEH: ").append(rs.getDouble("mapeh")).append("\n");
                sb.append("Filipino: ").append(rs.getDouble("filipino")).append("\n");
                sb.append("ESP: ").append(rs.getDouble("esp")).append("\n");
                sb.append("AP: ").append(rs.getDouble("ap")).append("\n");
                sb.append("Average: ").append(String.format("%.2f", rs.getDouble("average"))).append("\n");
                sb.append("--------------------------------------------------\n");
                studentList.add(sb.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public String searchStudentByName(String name) {
        String query = "SELECT * FROM students WHERE name = ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Name: ").append(rs.getString("name")).append("\n");
                sb.append("Science: ").append(rs.getDouble("science")).append("\n");
                sb.append("English: ").append(rs.getDouble("english")).append("\n");
                sb.append("Math: ").append(rs.getDouble("math")).append("\n");
                sb.append("MAPEH: ").append(rs.getDouble("mapeh")).append("\n");
                sb.append("Filipino: ").append(rs.getDouble("filipino")).append("\n");
                sb.append("ESP: ").append(rs.getDouble("esp")).append("\n");
                sb.append("AP: ").append(rs.getDouble("ap")).append("\n");
                sb.append("Average: ").append(String.format("%.2f", rs.getDouble("average"))).append("\n");
                return sb.toString();
            } else {
                return "Student not found.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while searching.";
        }
    }

    public boolean updateStudentGrades(String name, double science, double english, double math, double mapeh,
            double filipino, double esp, double ap, double average) {
        String query = "UPDATE students SET science = ?, english = ?, math = ?, mapeh = ?, filipino = ?, " +
                "esp = ?, ap = ?, average = ? WHERE name = ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, science);
            stmt.setDouble(2, english);
            stmt.setDouble(3, math);
            stmt.setDouble(4, mapeh);
            stmt.setDouble(5, filipino);
            stmt.setDouble(6, esp);
            stmt.setDouble(7, ap);
            stmt.setDouble(8, average);
            stmt.setString(9, name);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(String name) {
        String query = "DELETE FROM students WHERE name = ?";
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
