package managernegozio;

import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import eccezione.NegozioNonEsistenteException;
import eccezione.ParametroNonCorrettoException;

import model.NegozioDAO;
/**
 * La classe negozio permette di aggiungere un negozio, creare la cartella del negozio sul server
 * restituire oggetto negozio di un determinato venditore
 * @author cetra
 *
 */
public class Negozio implements Serializable {

	/**
	 * Permette di accedere alla classe DAO
	 */
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
	
	/**
	 * costruttore vuoto
	 */
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
	
	/**
	 * Costruttore che crea un istanza di negozio
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
	 */
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
		 * Restituisce il negozio associato ad un venditore
		 * <pre>Il parametro usernameVenditore è controllato nella servlet</pre>
		 * 
		 * @param usernameVenditore, venditore su cui fare la ricerca
		 * @return Negozio, oggetto negozio del determinato venditore, altrimenti lancia un eccezione
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
		 * Aggiunge un nuovo negozio nel Database
		 * <pre>I parametri di input vengono controllati sia lato cliente nelle jsp che lato server nelle servlet.
		 * per riferimento abbiamo un tabella dei formati nel RAD</pre>
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
		 * @return Negozio, ritorna oggetto negozio appenna aggiunto, altrimenti si genera un eccezione in caso di errore.
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
		
		/**
		 * Crea la cartella negozio se non esiste altrimenti la apre e ritorna il path
		 * @param nomeNegozio
		 * @param UPLOAD_DIRECTORY
		 * @return String UPLOAD_DIRECTORY path della cartella
		 */
		public String createCartellaNegozio(String nomeNegozio, String UPLOAD_DIRECTORY) {				
			UPLOAD_DIRECTORY+="\\"+nomeNegozio;
			if(!(new File(UPLOAD_DIRECTORY)).exists())
				new File(UPLOAD_DIRECTORY).mkdir();
			return UPLOAD_DIRECTORY;
		}
		
		/**
		 * Crea il la stringa del path per il logo del negozio
		 * @param multiparts
		 * @param nomeNegozio
		 * @param UPLOAD_DIRECTORY
		 * @return stringa del path
		 * @throws Exception
		 */
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
		
		/**
		 * Modifica url del path del logo negozio
		 * @param nomeNegozio
		 * @param urlLogo
		 * @return boolean, true se andato a buon fine la modifica altrimenti false
		 * @throws SQLException
		 */
		public boolean updateLogoNegozio(String nomeNegozio,String urlLogo) throws SQLException {
			return model.updateLogoNegozio(nomeNegozio, urlLogo);
		}
		
		
		/**
		 * Restituire il negozio passato come parametro il nome del negozio
		 * @param nomeNegozio il nome del negozio
		 * @return negozio
		 * @throws SQLException
		 * @throws ParametroNonCorrettoException 
		 */
		public Negozio getNegozioByName(String nomeNegozio) throws SQLException, ParametroNonCorrettoException {
			if (nomeNegozio==null) {
				throw new ParametroNonCorrettoException("nome negozio non esiste riprova ad accedere");
					
			}
			return model.getNegozioByName(nomeNegozio);
		}

		/**
		 * @return the nomeNegozio
		 */
		public String getNomeNegozio() {
			return nomeNegozio;
		}

		/**
		 * @param nomeNegozio the nomeNegozio to set
		 */
		public void setNomeNegozio(String nomeNegozio) {
			this.nomeNegozio = nomeNegozio;
		}

		/**
		 * @return the usernameVenditore
		 */
		public String getUsernameVenditore() {
			return usernameVenditore;
		}

		/**
		 * @param usernameVenditore the usernameVenditore to set
		 */
		public void setUsernameVenditore(String usernameVenditore) {
			this.usernameVenditore = usernameVenditore;
		}

		/**
		 * @return the design
		 */
		public String getDesign() {
			return design;
		}

		/**
		 * @param design the design to set
		 */
		public void setDesign(String design) {
			this.design = design;
		}

		/**
		 * @return the colore
		 */
		public String getColore() {
			return colore;
		}

		/**
		 * @param colore the colore to set
		 */
		public void setColore(String colore) {
			this.colore = colore;
		}

		/**
		 * @return the partitaIva
		 */
		public String getPartitaIva() {
			return partitaIva;
		}

		/**
		 * @param partitaIva the partitaIva to set
		 */
		public void setPartitaIva(String partitaIva) {
			this.partitaIva = partitaIva;
		}

		/**
		 * @return the dataIscrizione
		 */
		public String getDataIscrizione() {
			return dataIscrizione;
		}

		/**
		 * @param dataIscrizione the dataIscrizione to set
		 */
		public void setDataIscrizione(String dataIscrizione) {
			this.dataIscrizione = dataIscrizione;
		}

		/**
		 * @return the descrizione
		 */
		public String getDescrizione() {
			return descrizione;
		}

		/**
		 * @param descrizione the descrizione to set
		 */
		public void setDescrizione(String descrizione) {
			this.descrizione = descrizione;
		}

		/**
		 * @return the via
		 */
		public String getVia() {
			return via;
		}

		/**
		 * @param via the via to set
		 */
		public void setVia(String via) {
			this.via = via;
		}

		/**
		 * @return the citta
		 */
		public String getCitta() {
			return citta;
		}

		/**
		 * @param citta the citta to set
		 */
		public void setCitta(String citta) {
			this.citta = citta;
		}

		/**
		 * @return the cap
		 */
		public String getCap() {
			return cap;
		}

		/**
		 * @param cap the cap to set
		 */
		public void setCap(String cap) {
			this.cap = cap;
		}

		/**
		 * @return the logo
		 */
		public String getLogo() {
			return logo;
		}

		/**
		 * @param logo the logo to set
		 */
		public void setLogo(String logo) {
			this.logo = logo;
		}

		
		

}

