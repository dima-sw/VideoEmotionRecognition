package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import manageraccouting.Cliente;
import manageraccouting.Utente;

public class ClienteDAO {


	private static DataSource ds;
	private static final String TABLE_CLIENTE = "cliente";
	
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			System.out.println(envCtx.INITIAL_CONTEXT_FACTORY);

			ds = (DataSource) envCtx.lookup("jdbc/emmeshop_db");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
		
	/**
	 * 
	 * @param username
	 * @param password
	 * @return Utente 
	 * @throws SQLException
	 */
		public synchronized Utente checkLoginClient(String username,String password) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Cliente bean = new Cliente();

			String selectSQL = "SELECT * FROM " + ClienteDAO.TABLE_CLIENTE + " WHERE username = ? AND password = ?";

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					bean.setUsername(rs.getString("username"));
					bean.setPassword(rs.getString("password"));
				    bean.setCap(rs.getString("cap"));
				    bean.setCitta(rs.getString("città"));
				    bean.setVia(rs.getString("via"));
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
	
