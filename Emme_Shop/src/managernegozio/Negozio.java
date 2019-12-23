package managernegozio;

import java.io.Serializable;
import java.sql.SQLException;

import dao.ClienteDAO;
import dao.NegozioDAO;

/**
 * 
 * @author manlio
 * la classe Negozio gestisce le operazioni di aggiunta,rimozione,modifca di un prodotto e categoria
 *
 */
public class Negozio implements Serializable {

	static NegozioDAO model= new NegozioDAO();

	private String nomeNegozio;
	private String usernameVenditore;
	private String design;
	private String colore;
	private String partitaIva;
	private String dataIscrizione;
	private String descrizione;
	private String via;
	private String citta;
	private String cap;
	private String logo;
	
	public Negozio() {
		this.nomeNegozio = "";
		this.usernameVenditore = "";
		this.design = "";
		this.colore = "";
		this.partitaIva  ="";
		this.dataIscrizione = "";
		this.descrizione = "";
		this.via = "";
		this.citta = "";
		this.cap = "";
		this.logo = "";
	}
	
	public Negozio(String nomeNegozio, String usernameVenditore, String template, String colore, String partitaIva,
				String dataIscrizione, String descrizione, String via, String citta, String cap, String Logo) {
			this.nomeNegozio = nomeNegozio;
			this.usernameVenditore = usernameVenditore;
			this.design = template;
			this.colore = colore;
			this.partitaIva = partitaIva;
			this.dataIscrizione = dataIscrizione;
			this.descrizione = descrizione;
			this.via = via;
			this.citta = citta;
			this.cap = cap;
			this.logo = Logo;
		}
		
		/**
		 * Restituisce il negozio del venditore passato come username
		 * @param username
		 * @return Negozio
		 * @throws SQLException
		 */
		public Negozio getNegozio(String username) throws SQLException {
		
			return model.getNegozio(username);
		}

		/**
		 * 
		 * @param negozio
		 * @throws SQLException
		 */
		public Negozio addNegozio(String nomeNegozio, String usernameVenditore, String template, String colore, String partitaIva,
				String dataIscrizione, String descrizione, String via, String citta, String cap, String Logo) throws SQLException {
			
			Negozio negozio=new Negozio( nomeNegozio, usernameVenditore, template, colore, partitaIva,
				 dataIscrizione, descrizione, via, citta, cap, Logo);
			
			model.addNegozio(negozio);
			return negozio;
		}
		
		public boolean updateLogoNegozio(String nomeNegozio,String urlLogo) throws SQLException {
			return model.updateLogoNegozio(nomeNegozio, urlLogo);
		}

		
		
		
		public String getLogo() {
			return this.logo;
		}



		public void setLogo(String logo) {
			this.logo = logo;
		}



		public String getNomeNegozio() {
			return nomeNegozio;
		}
	
		public void setNomeNegozio(String nomeNegozio) {
			this.nomeNegozio = nomeNegozio;
		}
		
		public String getUsernameVenditore() {
			return usernameVenditore;
		}
		
		public void setUsernameVenditore(String usernameVenditore) {
			this.usernameVenditore = usernameVenditore;
		}
		
		public String getDesign() {
			return design;
		}
		
		public void setDesign(String design) {
			this.design = design;
		}
		
		public String getColore() {
			return colore;
		}
		
		public void setColore(String colore) {
			this.colore = colore;
		}
		
		public String getPartitaIva() {
			return partitaIva;
		}
		
		public void setPartitaIva(String partitaIva) {
			this.partitaIva = partitaIva;
		}
		
		public String getDataIscrizione() {
			return dataIscrizione;
		}
		
		public void setDataIscrizione(String dataIscrizione) {
			this.dataIscrizione = dataIscrizione;
		}
		
		public String getDescrizione() {
			return descrizione;
		}
		
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}
		
		public String getVia() {
			return via;
		}
		
		public void setVia(String via) {
			this.via = via;
		}
		
		public String getCitta() {
			return citta;
		}
		
		public void setCitta(String citta) {
			this.citta = citta;
		}
		
		public String getCap() {
			return cap;
		}
		
		public void setCap(String cap) {
			this.cap = cap;
		}

		
		


}

