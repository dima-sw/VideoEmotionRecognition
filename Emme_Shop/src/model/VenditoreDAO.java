package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import manageraccouting.Utente;
import manageraccouting.Venditore;

/**
 * Permette di effettuare le operazioni CRUD per la table Venditore
 * @author cetra
 *
 */
public class VenditoreDAO implements Serializable {
	
	//private static DataSource ds;
	private static final String TABLE_VENDITORE = "venditore";
	
	
	
	/*static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			
			System.out.println(envCtx.INITIAL_CONTEXT_FACTORY);

			ds = (DataSource) envCtx.lookup("jdbc/emmeshop_db");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}*/
	
	/**
	 * Verifica la presenza di un venditore nel database
	 * <pre>Controlla se quello restituito dal database è null</pre>
	 * @param username
	 * @param password
	 * @return Utente
	 * @throws SQLException
	 */
	public synchronized Utente checkLoginSeller(String username,String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Utente bean = new Venditore();

		String selectSQL = "SELECT username,password FROM " + VenditoreDAO.TABLE_VENDITORE + " WHERE username = ? AND password = ?";

		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			
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
					//connection.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				
			}
		}
		

		if(bean.getUsername().trim().equalsIgnoreCase("") || bean==null)
			return null;
		else
			return bean;
	}
	
	/**
	 * Aggiunge un venditore nel database
	 * <pre>Username e password non devono essere giù presenti nel db</pre>
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
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
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
					DriverManagerConnectionPool.releaseConnection(connection);
				}
		}
	}
	

/**
 * Cancella il venditore dal database tramite username
 * <pre>Username deve essere presente nel database</pre>
 * @param username
 * @throws SQLException
 */
public  synchronized void deleteVenditore(String username) throws SQLException {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	String deleteSQL = "DELETE FROM venditore  WHERE username = ? ";
	//System.out.println(nomeNegozio+" "+nomeCategoria);
	try {
		
		//connection = ds.getConnection();
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,username);

		 preparedStatement.executeUpdate();

			connection.commit();

	} finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		} finally {
			if (connection != null)
				//connection.close();
				DriverManagerConnectionPool.releaseConnection(connection);
			
		}
	}
}





	
	
	
}
