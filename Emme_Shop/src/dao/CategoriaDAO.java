package dao;

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

public class CategoriaDAO {

	private static DataSource ds;
	private static final String TABLE_CATEGORIA = "categoria";
	
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
	 * @param venditore
	 * @return Collection di categorie di quel venditore
	 * @throws SQLException
	 */
	public synchronized Collection<Categoria> getAllCategoryBySeller(String venditore) throws SQLException {
  	  
  	  Connection connection = null;
   	  PreparedStatement preparedStatement = null;
   	  
		  Collection<Categoria> listaCategorie = new LinkedList<Categoria>();

		  String selectSQL = "SELECT categoria.* FROM categoria,negozio WHERE nomeNeg=nome AND usernameVenditore=?";
		  
		try {
			connection = ds.getConnection();
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
					connection.close();
			}
		}
		return listaCategorie;
	}
	
}
