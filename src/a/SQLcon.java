package a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLcon {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	static String search;
	static ArrayList<String> bearbaseResult = new ArrayList<String>();
	static ArrayList<String> ikeanamesResult = new ArrayList<String>();
	static ArrayList<String> masterscpResult = new ArrayList<String>();

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
			PreparedStatement ikeanamesStatement = conn.prepareStatement("SELECT * FROM ikea_names WHERE `name` like '%"+search+"%' OR `description` like '%"+search+"%'");
			PreparedStatement masterscpStatement = conn.prepareStatement("SELECT * FROM masterscplist WHERE `Title` like '%"+search+"%' OR `Classification` like '%"+search+"%' OR `Type` like '%"+search+"%' OR `Author` like '%"+search+"%' OR `Leaked_info` like '%"+search+"%'");

			rs = bearbaseStatement.executeQuery();
			
			String result;

			// ResultSet return
			while (rs.next()) {
				result = "Name: "+rs.getString(1)+" Origin: "+rs.getString(2)+" Creator: "+rs.getString(3)+" Desc: "+rs.getString(4);
				bearbaseResult.add(result);
			}
			
			rs = ikeanamesStatement.executeQuery();

			// ResultSet return
			while (rs.next()) {
				result = "Name: "+rs.getString(1)+" Desc: "+rs.getString(2)+" Extra: "+rs.getString(3);
				ikeanamesResult.add(result);
			}
			
			rs = masterscpStatement.executeQuery();

			// ResultSet return
			while (rs.next()) {
				result = "SCP: "+rs.getInt(1)+" Title: "+rs.getString(2)+" Classification: "+rs.getString(4)+" Type: "+rs.getString(5);
				masterscpResult.add(result);
			}
			
			System.out.println(bearbaseResult.get(0).toString());
			System.out.println(ikeanamesResult.get(0).toString());
			System.out.println(masterscpResult.get(0).toString());

			conn.close();

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			
		}

	}

}