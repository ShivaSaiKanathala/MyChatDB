package application;

import java.sql.Connection; //A class represents connection with database
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class database {
	private static Connection getConnection()
	{

		try {
			String url = "jdbc:mysql://127.0.0.1:3306/myfirstdb"; //You need to create "MyFirstDatabase" schema in the MySQL
			String username = "root";
			String password = "root";
			String driver_name = "com.mysql.jdbc.Driver"; //Tell the type of translator
		
			//load the translator
			Class.forName(driver_name);
			System.out.println("Successfully find driver!");
			
			//Initialize the connection to the database
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println("The database is connected successfully!");
			
			return conn;
			
		} catch (ClassNotFoundException e) {
			System.out.println("No driver exist!");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //Tell Java what the driver gonna to use
		catch (SQLException e) {
			
			System.out.println("Database Not Found!");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void createTable() throws SQLException
	{
		Connection conn = getConnection(); 
		
		String sql_command = "CREATE TABLE IF NOT EXISTS Info"
				+ "(first VARCHAR(1000), "
				+ "last VARCHAR(1000), "
				+ "gender VARCHAR(1000), "
				+ "month VARCHAR(1000), "
				+ "date VARCHAR(1000), "
				+ "year VARCHAR(1000), "
				+ "hob VARCHAR(10), "
				+ "url VARCHAR(1000))";
		
		Statement stmt = conn.createStatement(); //create a postman by connection
		System.out.println("from table");
		stmt.executeUpdate(sql_command); //modify the database by executing sql_command
		stmt.close();
		conn.close();
		

	}
	
	
	public static void insertRecords(String a,String b,String gender,String month, String date, String year, String hob, String c) throws SQLException
	{
		Connection conn = getConnection(); //Similar to socket
		Statement stmt = conn.createStatement(); //create a postman by connection
		System.out.println(a.toString());
		String query = " insert into Info (first, last, gender, month, date, year,hob, url)"
		        + " values (?, ?, ?, ?, ?, ?, ?,?)";
		 PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, a.toString());
	      preparedStmt.setString (2,b.toString());
	      preparedStmt.setString(3, gender.toString());
	      preparedStmt.setString(4, month.toString());
	      preparedStmt.setString(5, date.toString());
	      preparedStmt.setString(6, year.toString());
	      preparedStmt.setString(7, hob.toString());
	      preparedStmt.setString(8, c.toString());
	      preparedStmt.execute();
	      conn.close();
		
		
	}
	

	
}
