package qr_govyaha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 
public class Insert_data {
 
    public static void main(String[] args) throws SQLException {
 
        String url = "jdbc:postgresql://localhost:5432/qr_data";
        String user = "postgres";
        String password = "12345";
 
        Connection myConn = null;
        Statement myStmt = null;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Input applicant's name: ");
        String a_name = in.nextLine();
        System.out.println("Input supervisor's name: ");
        String s_name = in.nextLine();
        System.out.println("Input address: ");
        String add = in.nextLine();
        System.out.println("Input the topic of appeal: ");
        String topic = in.nextLine();
        System.out.println("Input content of appeal: ");
        String content = in.nextLine();
        in.close();
 
        try {
            myConn = DriverManager.getConnection(url, user, password);
 
            myStmt = myConn.createStatement();
 
            String sql = "insert into users " + " (applicant, supervisor, address, subject, content)"
                    + " values (" + "'"+ a_name + " ', " + "'"+ s_name + " ', " + "'"+ add + " ', " + "'"+ topic + " ', " + "'" + content + " ')";
            myStmt.executeUpdate(sql);
 
            System.out.println("Insert complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myStmt != null) {
                myStmt.close();
            }
 
            if (myConn != null) {
                myConn.close();
            }
        }
    }
}
