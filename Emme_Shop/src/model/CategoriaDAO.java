package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import managernegozio.Categoria;
/**
 * Posside le operazioni di gestione la table Categoria all'interno del database
 * @author cetra
 *
 */
public class CategoriaDAO implements Serializable {

//	private static DataSource ds;
	private static final String TABLE_CATEGORIA = "categoria";
	
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
	 * Restituisce una lista di categorie di un determinato venditore
	 * @param venditore
	 * @return Collection<Categoria>, lista di categoria
	 * @throws SQLException
	 */
	public synchronized Collection<Categoria> getAllCategoryBySeller(String venditore) throws SQLException {
  	  
  	  Connection connection = null;
   	  PreparedStatement preparedStatement = null;
   	  
		  Collection<Categoria> listaCategorie = new LinkedList<Categoria>();

		  String selectSQL = "SELECT categoria.* FROM categoria,negozio WHERE nomeNeg=nome AND usernameVenditore=?";
		  
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,venditore);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Categoria categoriaBean = new Categoria();

				categoriaBean.setNomeNegozio(rs.getString("nomeNeg"));
				categoriaBean.setNomeCategoria(rs.getString("nomeCategoria"));
				categoriaBean.setDescrizione(rs.getString("descrizione"));
				categoriaBean.setPath(rs.getString("path"));
				
				
				listaCategorie.add(categoriaBean);
				
				
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
		return listaCategorie;
	}
	
	/**
	 * Aggiunge una nuova categoria
	 * <pre> 
	 * Il nome del negozio, nome venditore deve essere già presente nel database
	 * Il nome della categoria non può essere inserito in caso sia già presente con lo stesso nome, nome del venditore, negozio
	 * </pre>
	 * @param categoria
	 * @throws SQLException
	 */
	public synchronized void addCategoria(Categoria categoria) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertCateg ="INSERT INTO " + CategoriaDAO.TABLE_CATEGORIA
				               +"(nomeNeg,nomeCategoria,descrizione,path)"
				               +"VALUES(?,?,?,?)";
		
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(insertCateg);
			
			preparedStatement.setString(1,categoria.getNomeNegozio());
			preparedStatement.setString(2,categoria.getNomeCategoria());

			preparedStatement.setString(3,categoria.getDescrizione());
			preparedStatement.setString(4,categoria.getPath());
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
	 * Modifica il path della categoria
	 * <pre>nel caso il path non sia già aggiunto lo inserisce
	 * il parametro nomeNegozio deve essere presente nel database
	 * il parametro nomeCategoria deve essere riferito al nomeNegozio è deve essere presente nel db
	 *</pre>
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param logo
	 * @return boolean true in caso di successo della modifica
	 * @throws SQLException
	 */
	public synchronized boolean updatePathCategoria(String nomeNegozio,String nomeCategoria,String logo) throws SQLException {
	 
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean flag=false;
		
		String update = "UPDATE " + CategoriaDAO.TABLE_CATEGORIA
				                 +" SET path= ? "
				                 +" where nomeNeg= ? AND nomeCategoria=? ";
		
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1,logo);
			preparedStatement.setString(2,nomeNegozio);
			preparedStatement.setString(3,nomeCategoria);
			
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
					//connection.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				
			}
		 }
		return flag;
}
	
	/**
	 * Restituisce la categoria di un determinato negozio
	 * <pre>
	 * nel database deve essere presente il negozio, e la categoria associata a quel negozio
	 * </pre>
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @return restituisce la categoria 
	 * @throws SQLException
	 */
	public synchronized Categoria getCategoria(String nomeNegozio,String nomeCategoria) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Categoria bean=new Categoria();
		
		String categ ="SELECT * FROM categoria"
	               +" WHERE nomeNeg=? AND nomeCategoria=? ";
		
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(categ);
			
			preparedStatement.setString(1,nomeNegozio);
			preparedStatement.setString(2,nomeCategoria);
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
			
				String negozio=rs.getString("nomeNeg");
				String categoria=rs.getString("nomeCategoria");
				String descrizione=rs.getString("descrizione");
				String path=rs.getString("path");
				bean.setNomeNegozio(negozio);
				bean.setNomeCategoria(categoria);
				bean.setDescrizione(descrizione);
				bean.setPath(path);
			}
			
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
		
		return bean;
		
	}
	
	/**
	 * Modifica la descrizione di una categoria
	 * <pre>
	 * nel database devono essere presente nome negozio e il nome categoria associato al negozio
	 * <pre>
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param descrizione
	 * @return flag boolean true se la modifica avviene altrimenti false
	 * @throws SQLException
	 */
	public synchronized boolean updateDescrizioneCategoria(String nomeNegozio, String nomeCategoria, String descrizione) throws SQLException
	{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean flag=false;
		
		String update = "UPDATE " + CategoriaDAO.TABLE_CATEGORIA
				                 +" SET descrizione= ? "
				                 +" where nomeNeg= ? AND nomeCategoria=? ";
		
		try {
			//connection = ds.getConnection();
			connection = DriverManagerConnectionPool.getDbConnection();
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1,descrizione);
			preparedStatement.setString(2,nomeNegozio);
			preparedStatement.setString(3,nomeCategoria);
			
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
					//connection.close();
					DriverManagerConnectionPool.releaseConnection(connection);
				
			}
		 }
		return flag;
		
	
	}


/**
 * Cancella la categoria di un determinato negozio
 * <pre> 
 * il nome negozio e la categoria associata, da cancellare devono essere presenti nel db
 * </pre>
 * @param nomeNegozio
 * @param nomeCategoria
 * @return boolean true se la cancellazione avviene con successo
 * @throws SQLException
 */
public  synchronized boolean deleteCategory(String nomeNegozio, String nomeCategoria ) throws SQLException {
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	

	String deleteSQL = "DELETE FROM categoria  WHERE nomeNeg = ? AND nomeCategoria = ? ";
	//System.out.println(nomeNegozio+" "+nomeCategoria);
	try {
		
		//connection = ds.getConnection();
		connection = DriverManagerConnectionPool.getDbConnection();
		preparedStatement = connection.prepareStatement(deleteSQL);
		preparedStatement.setString(1,nomeNegozio);
		preparedStatement.setString(2,nomeCategoria);

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
	return true;
}





	
	
	
}
