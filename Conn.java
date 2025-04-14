package project;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "10052022");
            s = c.createStatement();
            
            System.out.println("Database Connection Successful!");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found. Add MySQL Connector JAR to the project.");
        } catch (SQLException e) {
            System.out.println("Database Connection Failed. Check MySQL settings.");
            e.printStackTrace();
        }
    }
}
