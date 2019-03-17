package jdbc.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_RUN2_ResultSet2_Scroll {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		String url = "jdbc:oracle:thin:@ec2-18-206-120-26.compute-1.amazonaws.com:1521:xe";

		String user = "hr"; // or your username
		String password = "hr";// or your password
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("SELECT * FROM JOB_HISTORY");
		while (rs.next()) {
			for (int i = 1; i <= 5; i++) {
				System.out.print(rs.getObject(i) + "----");

			}
			System.out.println();
		}

		rs.first();
		System.out.print(rs.getObject(1) + "----");
		rs.last();
		System.out.print(rs.getRow() + "----");
		// rs.beforeFirst();
		// rs.afterLast();
		System.out.print(rs.getObject(1) + "----");

	}
}