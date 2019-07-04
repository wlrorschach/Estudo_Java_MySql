package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(""
					+ "INSERT INTO seller"
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES"
					+ "(?, ?, ?, ?, ?)");
	
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			
			//st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			
		} catch (SQLException e) {
			
		}
	
	}
}
