package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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


}
