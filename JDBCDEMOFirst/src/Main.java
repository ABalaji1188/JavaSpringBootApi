import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;


public class Main {

    private static final String url="jdbc:mysql://localhost:3306/JDBCdemo";
    private static final String username ="root";
    private static final String password="Root#123";
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        try{

        Connection con= DriverManager.getConnection(url,username,password);
        Statement st=con.createStatement();
            while (true) {
                System.out.println("\n===== Staff CRUD Operations =====");
                System.out.println("1. Insert Staff");
                System.out.println("2. View All Staff");
                System.out.println("3. Update Staff");
                System.out.println("4. Delete Staff");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertStaff(con, scanner);
                        break;
                    case 2:
                        viewStaff(con);
                        break;
                    case 3:
                        updateStaff(con, scanner);
                        break;
                    case 4:
                        deleteStaff(con, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        con.close();
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1️⃣ Insert Staff Data
    private static void insertStaff(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Name: ");
        String name = scanner.next();
        System.out.print("Enter Department: ");
        String department = scanner.next();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO staff (name, department, salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, department);
        pstmt.setDouble(3, salary);
        int rowsInserted = pstmt.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Staff added successfully!");
        }
    }

    // 2️⃣ View All Staff
    private static void viewStaff(Connection conn) throws SQLException {
        String sql = "SELECT * FROM staff";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\nID | Name | Department | Salary");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("department") + " | " + rs.getDouble("salary"));
        }
    }

    // 3️⃣ Update Staff Data
    private static void updateStaff(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Staff ID to Update: ");
        int id = scanner.nextInt();
        System.out.print("Enter New Name: ");
        String name = scanner.next();
        System.out.print("Enter New Department: ");
        String department = scanner.next();
        System.out.print("Enter New Salary: ");
        double salary = scanner.nextDouble();

        String sql = "UPDATE staff SET name = ?, department = ?, salary = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        pstmt.setString(2, department);
        pstmt.setDouble(3, salary);
        pstmt.setInt(4, id);
        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Staff updated successfully!");
        } else {
            System.out.println("Staff not found!");
        }
    }

    // 4️⃣ Delete Staff Data
    private static void deleteStaff(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Staff ID to Delete: ");
        int id = scanner.nextInt();

        String sql = "DELETE FROM staff WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        int rowsDeleted = pstmt.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Staff deleted successfully!");
        } else {
            System.out.println("Staff not found!");
        }
    }
}