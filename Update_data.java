package qr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;



 
public class Update_data {

	public static void main(String[] args) throws SQLException{
    	String answer= "yes";
    	Update_resolution(args);
    }
    
    public static void Update_resolution (String [] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/database2";
        String user = "postgres";
        String password = "12345";
        String new_data, new_dataa, new_dataaa;
        int id;
        int idd;
       
 
        Connection myConn = null;
        Statement myStmt = null;       
                
 
        try {
            myConn = DriverManager.getConnection(url, user, password);
 
            myStmt = myConn.createStatement();
 
            java.util.Scanner in = new Scanner(System.in);
            System.out.print("Input new data for the field resolution: ");
            if (in.hasNext()) {
            	new_data = in.nextLine();
            	System.out.print("Input the id of the citizen: ");
            	try {
                	while(!in.hasNextInt()) {
                		System.out.println("That is not a valid input, try again.");
                        in.nextInt();
                	}
                } catch (InputMismatchException e) {
                	System.out.print(e.getMessage()); 
                }
                id = in.nextInt(); 
            String sql = "update users set resolution='" + new_data + " ' where id='" + id + "'";
            System.out.print("Input new data for the field status: ");
            new_dataa = in.nextLine();
            if (in.hasNext()) {
                new_dataa = in.nextLine();
                System.out.print("Input the id of the citizen: ");
                try {
                	while(!in.hasNextInt()) {
                		System.out.println("That is not a valid input, try again.");
                        in.nextInt();
                	}
                } catch (InputMismatchException e) {
                	System.out.print(e.getMessage()); 
                }
                id = in.nextInt(); 
             String sql1 = "update users set status='" + new_dataa + " ' where id='" + id + "'";
               
             
             System.out.print("Input new data for the field notes: ");
                new_dataaa = in.nextLine();
                if (in.hasNext()) {
                    new_dataaa = in.nextLine();
                    System.out.print("Input the id of the citizen: ");
                    try {
                    	while(!in.hasNextInt()) {
                    		System.out.println("That is not a valid input, try again.");
                            in.nextInt();
                    	}
                    } catch (InputMismatchException e) {
                    	System.out.print(e.getMessage()); 
                    }
                    id = in.nextInt(); 
            
            String sql2 = "update users set notes='" + new_dataaa + " ' where id='" + id + "'";
            
            int rowsAffected = myStmt.executeUpdate(sql);
            int rowsAffected1 = myStmt.executeUpdate(sql1);
            int rowsAffected2 = myStmt.executeUpdate(sql2);
            in.close();
 
            System.out.println("Rows affected: " + rowsAffected1);
            System.out.println("Update complete.");
            
        }}}}
      
    
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
        
    }}
