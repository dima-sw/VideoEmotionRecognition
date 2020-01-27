package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import manageraccouting.GestoreAccouting;
import manageraccouting.Utente;

public class GestoreAccoutingDAO {

	private static DataSource ds;
	private static final String TABLE_GESTOREACCOUTING = "gestoreaccouting";
	
	
	
	
	public synchronized Utente checkLoginAdmin(String username,String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Utente bean = new GestoreAccouting();

		String selectSQL = "SELECT username,password FROM " + GestoreAccoutingDAO.TABLE_GESTOREACCOUTING + " WHERE username = ? AND password = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setUsername(rs.getString("username"));
				bean.setPassword(rs.getString("password"));
			}

		} 
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		

		if(bean.getUsername().trim().equalsIgnoreCase("") || bean==null)
			return null;
		else
			return bean;
	}
}
