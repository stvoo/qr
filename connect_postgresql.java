package qr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connect_postgresql {
	 public Connection getConnection() {
		 	Connection conn1 = null;
	        String url = "jdbc:postgresql://localhost:5432/qr_data";
	        String user = "postgres";
	        String password = "12345";
	        try {
	        	conn1 = DriverManager.getConnection(url, user, password);
	        	if(conn1 != null) {
	        		System.out.println("Connected to database");
	        	}
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        }
	        return conn1;
	 }
}
