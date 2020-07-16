package qr_govyaha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class Delete_data {
 
    public static void main(String[] args) throws SQLException {
 
        String url = "jdbc:postgresql://localhost:5432/qr_data";
        String user = "postgres";
        String password = "12345";
        //String error= "status";
 
        Connection myConn = null;
        Statement myStmt = null;
 
        /*Scanner in = new Scanner(System.in);
        System.out.print("Input the id of the row that you would like to delete:");
        int id = in.nextInt();
        in.close();*/
        
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(url, user, password);
 
            // 2. Create a statement
            myStmt = myConn.createStatement();
 
            // 3. Execute SQL query
            String sql = "delete from users where id='1'";/* + id + '*/
 
            int rowsAffected = myStmt.executeUpdate(sql);
 
            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Delete complete.");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
            if (myStmt != null) {
                myStmt.close();
            }
 
            if (myConn != null) {
                myConn.close();
            }
        }
    }
}