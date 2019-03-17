package jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_RUN_loop {
	
	    public static void main( String[] args ) throws Exception
	    {
	        System.out.println( "Hello World!" );
	        
	        String url = "jdbc:oracle:thin:@ec2-18-206-120-26.compute-1.amazonaws.com:1521:xe";
			//String url = "jdbc:oracle:thin:@localhost:49161:xe";
			String user = "HR"; // or your username
			String password= "hr";// or your password
			Connection conn = DriverManager.getConnection(url, user, password) ;
			
			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			ResultSet rs = st.executeQuery("SELECT * FROM JOB_HISTORY") ; 
			
			while(rs.next()) {
				System.out.println();
			}
			
			System.out.println("connected ");
	        
	    }
	
	
	
	
	
}
