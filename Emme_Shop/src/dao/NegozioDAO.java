package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import managernegozio.Negozio;


public class NegozioDAO {

	private static DataSource ds;
	private static final String TABLE_NEGOZIO="negozio";
	
	
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
	
	public synchronized Negozio getNegozio(String usernameVenditore) throws SQLException {
  	  
  	  Connection connection = null;
   	  PreparedStatement preparedStatement = null;
   	  Negozio negozioBean = null;
   	  
		  String selectSQL = "SELECT * FROM " + NegozioDAO.TABLE_NEGOZIO+" WHERE usernameVenditore=?";
		  
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, usernameVenditore);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				
				negozioBean=new Negozio();
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
					connection.close();
			}
		}
		return negozioBean;
	}
	
	
	
}
