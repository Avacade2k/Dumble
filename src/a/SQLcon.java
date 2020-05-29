package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLcon {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	static String search;
	static String currentDatabase;
	static String currentColumn;

	static boolean connectSQL() {

		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);
			return false;
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/Dumble?serverTimezone=UTC", "root", "");
			return true;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}
	
	static void stateSQL() {

		try {	
			PreparedStatement bearbaseStatement = conn.prepareStatement("SELECT * FROM bearbase WHERE `Character` like '%"+search+"%' OR `Origin` like '%"+search+"%' OR `Creator` like '%"+search+"%' OR `Notes` like '%"+search+"%'");

			rs = bearbaseStatement.executeQuery();

			// ResultSet return
			while (rs.next()) {
				System.out.println("Name: "+rs.getString(1)+" Origin: "+rs.getString(2)+" Creator: "+rs.getString(3)+" Desc: "+rs.getString(4));

			}

			conn.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			
		}

	}

}