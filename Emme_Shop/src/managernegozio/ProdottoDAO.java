package managernegozio;

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

import com.mysql.jdbc.Statement;

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
	
/**
 * Aggiunge un prodotto alla categoria specificata
 * @param prodotto
 * @return Prodotto aggiunto
 * @throws SQLException
 */
public synchronized Prodotto addProdotto(Prodotto prodotto) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertProdotto = "INSERT INTO " + TABLE_PRODOTTO
				               +" (Nome_Negozio,Nome_Categoria,iva,path,prezzo,nome,qta,sconto,descrizione)"
				               +" VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertProdotto,Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1,prodotto.getNomeNegozio());
			preparedStatement.setString(2,prodotto.getNomeCategoria());
			preparedStatement.setInt(3,prodotto.getIva());
			preparedStatement.setString(4,prodotto.getPath());
			preparedStatement.setFloat(5,prodotto.getPrezzo());
			preparedStatement.setString(6,prodotto.getNome());
			preparedStatement.setInt(7,prodotto.getQuantita());
			preparedStatement.setInt(8,prodotto.getSconto());
			preparedStatement.setString(9,prodotto.getDescrizione());
			
			
			/* controlliamo se il negozio ha quella particolare categoria di prodotto
			 * se isCategoria ritorna false allora non c'è l'ha e 
			 *  quindi aggiungiamo la categoria a quel negozio nella tabella Categoria 
			 *  con il metodo addCategoria */
			/*if(!isCategoria(prodotto.getNomeNegozio(),prodotto.getNomeCategoria())) {
				/* creiamo il bean categoria */
				/*CategoriaBean categ = new CategoriaBean();
				categ.setNomeNegozio(prodotto.getNomeNegozio());
				categ.setNomeCategoria(prodotto.getNomeCategoria());
				categ.setDescrizione(prodotto.getDescrizione());*/
				/*Aggiungiamo il bean categoria  alla tabella categoria  */
			    /*addCategoria(categ);
			}*/
			
			preparedStatement.execute();
			int last_inserted_id=0;
			ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next())
            	 last_inserted_id = rs.getInt(1);
            
            prodotto.setIdProdotto( last_inserted_id);
			connection.commit();

		} finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			} finally {
				if(connection!=null)
					connection.close();
			}
		}

		
		return prodotto;
		
	}

/**
 * Ritorna true o false a seconda se il path è stato modificato
 * @param nomeNegozio
 * @param nomeCategoria
 * @param id
 * @param logo
 * @return boolean
 * @throws SQLException
 */
	public synchronized boolean updatePathProdotto(String nomeNegozio,String nomeCategoria,int id,String logo) throws SQLException {
	 
	 Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean flag=false;
		
		
		String update = "UPDATE " + TABLE_PRODOTTO
				                 +" SET path= ? "
				                 +" where Nome_Negozio= ? AND Nome_Categoria=? AND IdProdotto=?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(update);
			preparedStatement.setString(1,logo);
			preparedStatement.setString(2,nomeNegozio);
			preparedStatement.setString(3,nomeCategoria);
			preparedStatement.setInt(4,id);
			
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
					connection.close();
			}
		 }
		return flag;
}

	
	
public  synchronized boolean deleteProduct (int id ) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int result = 0;

		String deleteSQL = "DELETE FROM prodotto WHERE IdProdotto = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,id);

			result = preparedStatement.executeUpdate();

			
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

public synchronized Prodotto getProductById(int idProdotto) throws SQLException {
	  
	  Connection connection = null;
 	  PreparedStatement preparedStatement = null;
 	  
 	  
 	  Prodotto prodottoBean=null;
		  
		  String selectSQL = "SELECT * FROM prodotto WHERE IdProdotto=?";
		  
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,idProdotto);
			
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				prodottoBean = new Prodotto();

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
			}

			connection.commit();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return prodottoBean;
	}


public synchronized boolean updateProdotto(Prodotto bean) throws SQLException {
	 
	 Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean flag=false;
		
		String update = "UPDATE " + ProdottoDAO.TABLE_PRODOTTO
				                 +" SET iva= ? ,path= ? ,prezzo= ? , nome= ?, qta= ? , sconto= ?, descrizione= ?  "
				                 +" where IdProdotto= ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(update);
			
			preparedStatement.setInt(1,bean.getIva());
			preparedStatement.setString(2,bean.getPath());
			preparedStatement.setFloat(3,bean.getPrezzo());
			preparedStatement.setString(4,bean.getNome());
			preparedStatement.setInt(5,bean.getQuantita());
			preparedStatement.setInt(6,bean.getSconto());
			preparedStatement.setString(7,bean.getDescrizione());
			preparedStatement.setInt(8,bean.getIdProdotto());
			
			
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
					connection.close();
			}
		 }
		return flag;
}








}
