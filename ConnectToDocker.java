import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectToDocker {
		
	// Load DB2 Driver for JDBC class
	private static final String DB_DRIVER = "com.ibm.db2.jcc.DB2Driver";
	private static final String DB_CONNECTION="jdbc:db2://192.168.99.100:50000/appdynamics";	
	private static final String DB_USER = "db2inst1";
	private static final String DB_PASSWORD = "Dreams707";
@SuppressWarnings("resource")
public static void main(String[] argc) throws ClassNotFoundException, SQLException {
	
      Connection connection = null;
      Statement stmt = null;
      PreparedStatement Db2Stmt = null;
      String sql = null;
      try{
      Class.forName(DB_DRIVER);
      }
      catch (ClassNotFoundException e){
      System.err.println("Please add DB2 JDBC Driver in your Classpath ");
      System.err.println(e.getMessage());
      return;
      }
      System.out.println("DB2 JDBC Driver Registered.");
      try{
    	// Get a connection
      connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
      }
      catch (SQLException e){
      System.err.println("Connection Failed, Pleae check console");
      System.err.println(e.getMessage());
      return;
      }
      if (connection == null) 
      {
      System.out.println("Database Connection Failed.");
      }
      else 
      {
      System.out.println("Database Connection established.");
      }
      try{   // Deleting Old tables 
      System.out.println("Deleting already created Tables...");
      stmt = connection.createStatement();
      String sql1 = "drop table appdynamics.e2eteam";
      stmt.executeUpdate(sql1);
      //DB2 creating table of columns
      
      System.out.println("Creating table in given database...");
      stmt = connection.createStatement();
      sql = "create table appdynamics.e2eteam (id int,name varchar(50),jobrole varchar(30))";
      stmt.executeUpdate(sql);
      System.out.println("Created table in given database..."); 
      stmt = connection.createStatement();
      stmt.executeUpdate(sql); 
         		  
      // Db2 SQL statement to insert data 
      sql = "INSERT into appdynamics.e2eteam (id,name,jobrole) VALUES(?,?,?)";
      Db2Stmt = connection.prepareStatement(sql);

      Db2Stmt.setInt(1,1);
      Db2Stmt.setString(2,"Agastya");
      Db2Stmt.setString(3,"QA1");
      Db2Stmt.executeUpdate();

      Db2Stmt.setInt(1,2);
      Db2Stmt.setString(2,"Manav");
      Db2Stmt.setString(3,"QA2");
      Db2Stmt.executeUpdate();
      
      Db2Stmt.setInt(1,3);
      Db2Stmt.setString(2,"Jnanesh");
      Db2Stmt.setString(3,"QA3");
      Db2Stmt.executeUpdate();
      
      Db2Stmt.setInt(1,4);
      Db2Stmt.setString(2,"Kiran");
      Db2Stmt.setString(3,"QA4");
      Db2Stmt.executeUpdate();
      
      Db2Stmt.setInt(1,5);
      Db2Stmt.setString(2,"Vignesh");
      Db2Stmt.setString(3,"QA5");
      Db2Stmt.executeUpdate();
      
      System.out.println("Values Inserted successfully.");
      
   // Db2 SQL statement to DELETE data
      sql = "DELETE from appdynamics.e2eteam where id = ?";
      Db2Stmt = connection.prepareStatement(sql);
      Db2Stmt.setInt(1,5);
      Db2Stmt.executeUpdate(); 
      
      System.out.println("Few rows have been deleted successfully.");  
}
      catch(SQLException se){
          //Handle errors for JDBC
          se.printStackTrace();
      }// Handle any errors that may have occurred.
      catch (Exception e) {
          e.printStackTrace();
      }
      finally {
          if (Db2Stmt != null) try { Db2Stmt.close(); } catch(Exception e) {}
          if (connection != null) try { connection.close(); } catch(Exception e) {}
      } 
    connection.close();
}
}