package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import managerordine.ArrayRiferimento;
import managerordine.Fattura;
import managerordine.Riferimento;

public class RiferimentoDAO {
	
	private static DataSource ds;
	private static final String TABLE_RIFERIMENTO="riferimento";
	
	
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
	 * @param nomeNegozio
	 * @return ArrayRiferimento lista che contiene tutte le fatture del determinato negozio passato come input
	 * @throws SQLException
	 */
	public synchronized ArrayRiferimento getArrayRiferimento(String nomeNegozio) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayRiferimento riferimenti = null;
		
		String viewOrdineCliente = " SELECT * from riferimento,fattura  WHERE numeroFattura=numero_Fattura AND Nome_Negozio = ?  ORDER BY dataOrdine DESC";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(viewOrdineCliente);
			preparedStatement.setString(1,nomeNegozio);
			
			ResultSet rs =  preparedStatement.executeQuery();
			
			riferimenti=new ArrayRiferimento();
			
			while(rs.next()) {
				
				Riferimento riferimento=new Riferimento();
				riferimento.setId_prodotto(rs.getInt("ID_Prodotto"));
				riferimento.setNumero_Fattura(rs.getInt("numero_Fattura"));
				riferimento.setNome_Negozio(rs.getString("Nome_Negozio"));
				riferimento.setNome_Categoria(rs.getString("Nome_Categoria"));
				riferimento.setNote(rs.getString("nota"));
				riferimento.setQtaOrdinata(rs.getInt("QtaOrdinata"));
				riferimento.setSconto(rs.getInt("sconto"));
				riferimento.setPrezzoUnitario(rs.getFloat("prezzoUnitario"));
				riferimento.setIva(rs.getInt("IVA"));
				
				Fattura fattura=new Fattura();
				fattura.setNumFattura (rs.getInt("numeroFattura"));
				fattura.setUsername_Cliente(rs.getString("username_Cliente"));
				fattura.setDataOrdine(rs.getString("dataOrdine"));
				fattura.setCapDestinazione(rs.getString("capDestinazione"));
				fattura.setCittaDestinazione(rs.getString("citt‡Destinazione"));
				fattura.setViaDestinazione(rs.getString("viaDestinazione"));
				
				riferimento.setFatturaRiferimento(fattura);
				riferimenti.add(riferimento);
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
		return riferimenti;	
	}
	
	
}
