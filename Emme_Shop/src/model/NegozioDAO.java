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

import managernegozio.Negozio;

/**
 * Realizza le operazioni da effettuare con li databese riferite alla table Negozio
 * @author cetra
 *
 */
public class NegozioDAO implements Serializable {

	//private static DataSource ds;
	private static final String TABLE_NEGOZIO="negozio";
	
	/*
	static {
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
	 * Restituisce il negozio di un venditore
	 * <pre>
	 * Il venditore deve essere presente nel db e deve aver creato un negozio
	 * </pre>
	 * @param usernameVenditore
	 * @return Negozio, riferito ad un venditore
	 * @throws SQLException
	 */
	public synchronized Negozio getNegozio(String usernameVenditore) throws SQLException {
  	  
  	  Connection connection = null;
   	  PreparedStatement preparedStatement = null;
   	  Negozio negozio = null;
   	  
		  String selectSQL = "SELECT * FROM " + NegozioDAO.TABLE_NEGOZIO+" WHERE usernameVenditore=?";
		  
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, usernameVenditore);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				negozio=new Negozio();
				negozio.setNomeNegozio(rs.getString("nome"));
				negozio.setUsernameVenditore(rs.getString("usernameVenditore"));
				negozio.setDesign(rs.getString("design"));
				negozio.setColore(rs.getString("colore"));
				negozio.setPartitaIva(rs.getString("Piva"));
				negozio.setDataIscrizione(rs.getString("dataIscrizione"));
				negozio.setVia(rs.getString("via"));
				negozio.setCitta(rs.getString("città"));
				negozio.setCap(rs.getString("cap"));
				negozio.setLogo(rs.getString("logo"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
				//	connection.close();
				DriverManagerConnectionPool.releaseConnection(connection);
				
			}
		}
		return negozio;
	}
	

	/**
	 * Aggiunge un negozio nel db
	 * <pre>
	 * il negozio deve rispettare il formato per essere inserito
	 * <pre>
	 * @param negozio
	 * @throws SQLException
	 */
	public synchronized void addNegozio(Negozio negozio) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertNegozio = "INSERT INTO " + NegozioDAO.TABLE_NEGOZIO
				+ "(nome,usernameVenditore,design,colore,Piva,dataIscrizione,descrizione,via,città,cap,logo)"
				+"VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertNegozio);
			
			preparedStatement.setString(1,negozio.getNomeNegozio());
			preparedStatement.setString(2,negozio.getUsernameVenditore());
			preparedStatement.setString(3,negozio.getDesign());
			preparedStatement.setString(4,negozio.getColore());
			preparedStatement.setString(5,negozio.getPartitaIva());
			preparedStatement.setString(6,negozio.getDataIscrizione());
			preparedStatement.setString(7, negozio.getDescrizione());
			preparedStatement.setString(8, negozio.getVia());
			preparedStatement.setString(9, negozio.getCitta());
			preparedStatement.setString(10,negozio.getCap());
			preparedStatement.setString(11,negozio.getLogo());

			preparedStatement.execute();
			
			connection.commit();

		} finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} finally {
				if(connection!=null)
					//connection.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				
			}
		}
	}
	
	/**
	 * Modifica il path del logo del negozio
	 * <pre>
	 * Il negozio deve essere già presente
	 * </pre>
	 * @param nomeNegozio
	 * @param logo
	 * @return boolean, true se avvenuto la modifica
	 * @throws SQLException
	 */
	public synchronized boolean updateLogoNegozio(String nomeNegozio,String logo) throws SQLException {
		 
		 Connection connection = null;
			PreparedStatement preparedStatement = null;
			boolean flag=false;
			
			String update = "UPDATE " + NegozioDAO.TABLE_NEGOZIO
					                 +" SET logo= ? "
					                 +" where nome= ? ";
			
			try {
				//connection = ds.getConnection();
				connection = DriverManagerConnectionPool.getDbConnection();
				preparedStatement = connection.prepareStatement(update);
				preparedStatement.setString(1,logo);
				preparedStatement.setString(2,nomeNegozio);
				
				preparedStatement.executeUpdate();
				
				connection.commit();

				flag=true;
				}

			 finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (connection != null)
					//	connection.close();
					DriverManagerConnectionPool.releaseConnection(connection);
					
				}
			 }
			return flag;
	 }
	
	/**
	 * Restituisce il nome del negozio 
	 * <pre>Il negozio deve essere già presente con nome uguale al parametro negozio</pre>
	 * @param negozio
	 * @return Negozio 
	 * @throws SQLException
	 */
	public synchronized Negozio getNegozioByName(String negozio) throws SQLException {
  	  
  	  Connection connection = null;
   	  PreparedStatement preparedStatement = null;
   	  Negozio negozioBean = null;
   	  
		  String selectSQL = "SELECT * FROM " + NegozioDAO.TABLE_NEGOZIO+" WHERE nome=?";
		  
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, negozio);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				negozioBean = new Negozio();
				negozioBean.setNomeNegozio(rs.getString("nome"));
				negozioBean.setUsernameVenditore(rs.getString("usernameVenditore"));
				negozioBean.setDesign(rs.getString("design"));
				negozioBean.setColore(rs.getString("colore"));
				negozioBean.setPartitaIva(rs.getString("Piva"));
				negozioBean.setDataIscrizione(rs.getString("dataIscrizione"));
				negozioBean.setVia(rs.getString("via"));
				negozioBean.setCitta(rs.getString("città"));
				negozioBean.setCap(rs.getString("cap"));
				negozioBean.setLogo(rs.getString("logo"));
				
			}

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
		return negozioBean;
	}
	
	/**
	 * Cancella un negozio
	 * @param nomeNegozio
	 * @throws SQLException
	 */
	public  synchronized void deleteShop(String nomeNegozio ) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		

		String deleteSQL = "DELETE FROM negozio  WHERE nome = ? ";
		//System.out.println(nomeNegozio+" "+nomeCategoria);
		try {
			
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1,nomeNegozio);

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
