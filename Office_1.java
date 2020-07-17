package qr;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;

public class Office_1 extends Read_qr{

	public static void main(String[] args) throws NotFoundException, WriterException, IOException, SQLException {
		System.out.println("Hello, user!\nFill the new form.");
		try {
			Insert_data.main(args);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("QR-code is creating...");
		Dinamyc_connection.main(args);
		
		try {
			Office_2.main(args);
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Delete_data.main(args);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Read_qr.main(args);
		String[] query = a.split(" ");
		try {
			Proc(query[0],query[1],query[2], query[3], query[4], query[5], query[6], query[7]);
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


static void Proc(String str_1, String str_2, String str_3, String str_4, String str_5, 
		String str_6, String str_7, String str_8) throws SQLException, WriterException, IOException, NotFoundException{
    
    String url = "jdbc:postgresql://localhost:5432/qr_data";
    String user = "postgres";
    String password = "12345";
    
    Connection myConn = null;
    Statement myStmt = null;
    
    try {
        myConn = DriverManager.getConnection(url, user, password);

        myStmt = myConn.createStatement();

        String sql = "insert into users " + " (applicant, supervisor, address, subject, content, resolution, status)"
                + " values (" + "'"+ str_1 + " ', " + "'"+ str_2 + " ', " + "'"+ str_3 + " ', " + "'"+ str_4 + " ', "
        		+ "'" + str_5 + " ', " + "'" + str_6 + "', " + "'"+ str_7 + " ', " + "'" + str_8 + "')";
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
