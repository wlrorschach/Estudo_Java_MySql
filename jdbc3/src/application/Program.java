package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
					+ "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS); // retorna o id gerado
	
			st.setString(1, "Sherkock Holmes");
			st.setString(2, "holmes@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("22/04/1898").getTime()));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
				ResultSet rs = st.getGeneratedKeys();
				
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
				
			if (rowsAffected > 0) {
				
			} else {
				System.out.println("No rows affected!");
			}
			
			
		} catch (SQLException e) {
			
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	
	}
}
