package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;	
		ResultSet rs = null;
		
		try {
			// responsavel pla coneccao
			conn = DB.getConnection();
			
			// responsavel pelo comando SQL
			st = conn.createStatement();
			
			// Recebe o resultado da Query
			rs = st.executeQuery("select * from department");
			
			while (rs.next()) {
				System.out.println(rs.getInt("id") + ", " + rs.getString("Name"));
				System.out.println(rs.getInt("id")+ ", " + rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
