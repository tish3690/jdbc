package jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class DB_RUN_result {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		//
		/*
		 * connection string : 1 , jdbc 2 , vendor name for example : oracle mysql
		 * mariadb posgress 3 , sub type : driver type 4 , hostname 5 , port name 6 ,
		 * SID / Service
		 * 
		 */

		// String url = "jdbc:oracle:thin:@YOUR-EC2-HOSTNAME-GOES-HERE:1521:xe";
		String url = "jdbc:oracle:thin:@ec2-18-206-120-26.compute-1.amazonaws.com:1521:xe";
		String user = "HR"; // or your username
		String password = "HR";// or your password
		Connection conn = DriverManager.getConnection(url, user, password);

		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = st.executeQuery("SELECT * FROM job_history");
		ResultSetMetaData rsmd = rs.getMetaData();

		int colCount = rsmd.getColumnCount();
		System.out.println("colCountb :  " + colCount);
		System.out.println(" column name rsmd.getColumnName(1) : " + rsmd.getColumnName(1));

		/// find out column name of all the columns from the resultset
		// rs.next();
		for (int i = 1; i <= colCount; i++) {
			System.out.println(rsmd.getColumnName(i) + " -- ");
		}

		// System.out.println(rs.getInt(4) );

		/// try to print out all the value from all other column on this row

		System.out.println("connected ");

	}
}
