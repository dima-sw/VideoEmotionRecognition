package managernegozio;

import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import dao.ClienteDAO;
import dao.NegozioDAO;
import eccezione.NegozioNonEsistenteException;

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
		 *
		 *Restituisce il negozio del venditore passato come username
		 *
		 * @param usernameVenditore 
		 * @return Negozio
		 * @throws SQLException
		 * @throws NegozioNonEsistenteException 
		 */
		public Negozio getNegozio(String usernameVenditore) throws SQLException, NegozioNonEsistenteException {
			
			Negozio negozio=model.getNegozio(usernameVenditore);
			if (negozio==null)
				throw new NegozioNonEsistenteException("negozio del Venitore: "+usernameVenditore+" non trovato");
			else
				return negozio;
		}

		/**
		 * Aggiunge un nuovo negozio, i parametri di ingresso sono controllati al momento dell'inserimento con javascript
		 * 
		 * @param nomeNegozio
		 * @param usernameVenditore
		 * @param template
		 * @param colore
		 * @param partitaIva
		 * @param dataIscrizione
		 * @param descrizione
		 * @param via
		 * @param citta
		 * @param cap
		 * @param Logo
		 * @return Negozio restituisce il negozio creato
		 * @throws SQLException
		 */
		public Negozio addNegozio(String nomeNegozio, String usernameVenditore, String template, String colore, String partitaIva,
				String dataIscrizione, String descrizione, String via, String citta, String cap, String Logo) throws SQLException {
			
			Negozio negozio=new Negozio( nomeNegozio, usernameVenditore, template, colore, partitaIva,
				 dataIscrizione, descrizione, via, citta, cap, Logo);
			try {
				model.addNegozio(negozio);
				return negozio;
			}
			catch (SQLException e) {
				throw new SQLException("Creazione del nuovo negozio fallita, errore: "+e.getMessage());
				
			}
			
		}
		

		public String createCartellaNegozio(String nomeNegozio, String UPLOAD_DIRECTORY) {				
			UPLOAD_DIRECTORY+="\\"+nomeNegozio;
			if(!(new File(UPLOAD_DIRECTORY)).exists())
				new File(UPLOAD_DIRECTORY).mkdir();
			return UPLOAD_DIRECTORY;
		}
		
		public String createPathLogo(List<FileItem> multiparts, String nomeNegozio, String UPLOAD_DIRECTORY) throws Exception {
			
			String urlLogo="";
			
			for(FileItem item : multiparts){
                if(!item.isFormField()){
                    String name = new File(item.getName()).getName();
                    int index = name.indexOf(".");
                    String estensione= name.substring(index);
                    item.write( new File(UPLOAD_DIRECTORY + File.separator + nomeNegozio+estensione));
                    urlLogo="images/negozi/"+nomeNegozio+"/"+nomeNegozio+estensione;
                    
                    updateLogoNegozio(nomeNegozio,urlLogo);
                }
			}  
			return urlLogo;
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

