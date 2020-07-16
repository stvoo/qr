package hui;

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
    	//Update_status(args); 
    	/*Scanner in = new Scanner(System.in);
		System.out.print("Would you like to update the field 'notes'?");
        if (in.hasNext()) {
        	String column = in.nextLine();
        	in.close();
        	if (column.equalsIgnoreCase(answer)) {
        	try {
    			Update("notes");
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    		}
        }*/
    }
    
    public static void Update_resolution (String [] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/database2";
        String user = "postgres";
        String password = "12345";
        //String column1 = "status";
        String new_data, new_dataa, new_dataaa;
        int id;
        int idd;
        //String error = "status";
       
 
        Connection myConn = null;
        Statement myStmt = null;
        
        
        //System.out.print("You can update one of the columns: resolution, status. Input the column's name that you would like to update: ");
        //String column = in.nextLine();
        //if (column.equalsIgnoreCase(error)) {
        //	System.out.print("Input new data: ");
        //    boolean new_data = in.nextBoolean();
        //} else {
       
                
 
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(url, user, password);
 
            // 2. Create a statement
            myStmt = myConn.createStatement();
 
            // 3. Execute SQL query
            java.util.Scanner in = new Scanner(System.in);
            //Scanner in = new Scanner(System.in);
            //пегнкчьм
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
            //in.close();
            //Scanner inn = new Scanner(System.in);
            //ярюрся
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
            
            //System.out.print("Input the id of the citizen: ");
            
            //idd = in.nextInt();
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

    /*public static void Update_status (String [] args) throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/database2";
        String user = "postgres";
        String password = "12345";
        //String column1 = "status";
        String new_data;
        int id;
        //String error = "status";
       
 
        Connection myConn = null;
        Statement myStmt = null;
        
        Scanner in1 = new Scanner(System.in);
        //System.out.print("You can update one of the columns: resolution, status. Input the column's name that you would like to update: ");
        //String column = in.nextLine();
        //if (column.equalsIgnoreCase(error)) {
        //	System.out.print("Input new data: ");
        //    boolean new_data = in.nextBoolean();
        //} else {
       
        System.out.print("Input new data for the field status: ");
        if (in1.hasNext()) {
        new_data = in1.nextLine();
        System.out.print("Input the id of the citizen: ");
        id = in1.nextInt();
        in1.close();
        
 
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(url, user, password);
 
            // 2. Create a statement
            myStmt = myConn.createStatement();
 
            // 3. Execute SQL query
            String sql = "update users set notes='" + new_data + " ' where id='" + id + "'";
 
            int rowsAffected = myStmt.executeUpdate(sql);
 
            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Update complete.");
            
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
}*/