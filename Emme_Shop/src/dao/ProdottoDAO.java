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

import managernegozio.Prodotto;


public class ProdottoDAO {
	
	private static DataSource ds;
	private static final String TABLE_PRODOTTO="prodotto";
	
	
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
	 * @param id prodotto
	 * @return string path dell'imagine per id 
	 * @throws SQLException
	 */
	public synchronized String getPathByID(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		String viewOrdineCliente = " SELECT path from prodotto  WHERE IdProdotto = ?";
		String path="";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(viewOrdineCliente);
			preparedStatement.setInt(1,id);
			
			ResultSet result =  preparedStatement.executeQuery();
			
			
			while(result.next()) {
				path=result.getString("path");
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
		return path;
	}
	
	
	public synchronized Collection<Prodotto> getAllProductBySellerCategory(String venditore,String categoria) throws SQLException {
  	  
  	  Connection connection = null;
   	  PreparedStatement preparedStatement = null;
   	  
		  Collection<Prodotto> listaProdotti = new LinkedList<Prodotto>();
		  String selectSQL = "SELECT prodotto.* FROM prodotto,negozio WHERE Nome_Negozio=negozio.nome AND usernameVenditore=? AND Nome_Categoria=?";
		
		
		  
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,venditore);
			preparedStatement.setString(2,categoria);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto prodottoBean = new Prodotto();

				prodottoBean.setNomeNegozio(rs.getString("Nome_Negozio"));
				prodottoBean.setDescrizione(rs.getString("descrizione"));
				prodottoBean.setIdProdotto(rs.getInt("IdProdotto"));
				prodottoBean.setIva(rs.getInt("iva"));
				prodottoBean.setNome(rs.getString("nome"));
				prodottoBean.setNomeCategoria(rs.getString("Nome_Categoria"));
				prodottoBean.setPath(rs.getString("path"));
				prodottoBean.setPrezzo(rs.getFloat("prezzo"));
				prodottoBean.setQuantita(rs.getInt("qta"));
				prodottoBean.setSconto(rs.getInt("sconto"));
				
				listaProdotti.add(prodottoBean);
				
				
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
		return listaProdotti;
	}



}
