package manageraccouting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class VenditoreDAO {
	
	private static DataSource ds;
	private static final String TABLE_VENDITORE = "venditore";
	
	
	
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
	 * @return
	 * @throws SQLException
	 */
	public synchronized Utente checkLoginSeller(String username,String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Utente bean = new Venditore();

		String selectSQL = "SELECT username,password FROM " + VenditoreDAO.TABLE_VENDITORE + " WHERE username = ? AND password = ?";

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
	
	/**
	 * 
	 * @param venditore
	 * @throws SQLException
	 */
	public synchronized void addVenditore(Venditore venditore)throws SQLException{

		Connection connection=null;
		PreparedStatement preparedStatement = null;

		String insertVenditore="INSERT INTO "+VenditoreDAO.TABLE_VENDITORE
				+"(username,password,nome,cognome,email,sesso,telefono,via,città,cap)"
				+"VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {	
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertVenditore);

			preparedStatement.setString(1,venditore.getUsername());
			preparedStatement.setString(2,venditore.getPassword());
			preparedStatement.setString(3,venditore.getNome());
			preparedStatement.setString(4,venditore.getCognome());
			preparedStatement.setString(5,venditore.getEmail());
			preparedStatement.setString(6,venditore.getSesso());
			preparedStatement.setString(7,venditore.getTelefono());
			preparedStatement.setString(8,venditore.getVia());
			preparedStatement.setString(9,venditore.getCitta());
			preparedStatement.setString(10,venditore.getCap());

			preparedStatement.execute();
			connection.commit();

		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				if(connection!=null)
					connection.close();
			}
		}
	}
	
	
}
