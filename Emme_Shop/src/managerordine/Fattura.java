package managerordine;


/**
 * 
 * @author manlio
 *  la classe Fattura gestisce le operazioni di un ordine
 */
public class Fattura {


	private String username_Cliente;
	private String nomeNegozio;
	private Riferimento listaRiferimento;
	private String dataOrdine;
	private String viaDestinazione;
	private String cittaDestinazione;
	private String capDestinazione;

	private int numFattura;
	
	/**
	 * Costruttore vuoto
	 */
	public Fattura() {
	
		this.numFattura = 0;
		this.username_Cliente = "";
		this.nomeNegozio = "";
		this.dataOrdine = "";
		this.viaDestinazione = "";
		this.cittaDestinazione = "";
		this.capDestinazione = "";
	}
	
	/**
	 * Costruttore che crea una fattura 
	 * @param numFattura
	 * @param username_Cliente
	 * @param nomeNegozio
	 * @param dataOrdine
	 * @param descrizione
	 * @param viaPartenza
	 * @param cittaPartenza
	 * @param capPartenza
	 * @param viaDestinazione
	 * @param cittaDestinazione
	 * @param capDestinazione
	 */
	public Fattura(int numFattura, String username_Cliente, String nomeNegozio,
			String dataOrdine,  String descrizione, String viaPartenza, String cittaPartenza,
			String capPartenza, String viaDestinazione, String cittaDestinazione, String capDestinazione) {
	
		this.numFattura = numFattura;
		this.username_Cliente = username_Cliente;
		this.nomeNegozio = nomeNegozio;
		this.dataOrdine = dataOrdine;
		this.viaDestinazione = viaDestinazione;
		this.cittaDestinazione = cittaDestinazione;
		this.capDestinazione = capDestinazione;
	}
	
	
	
	/**
	 * @return the username_Cliente
	 */
	public String getUsername_Cliente() {
		return username_Cliente;
	}

	/**
	 * @param username_Cliente the username_Cliente to set
	 */
	public void setUsername_Cliente(String username_Cliente) {
		this.username_Cliente = username_Cliente;
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
	 * @return the listaRiferimento
	 */
	public Riferimento getListaRiferimento() {
		return listaRiferimento;
	}

	/**
	 * @param listaRiferimento the listaRiferimento to set
	 */
	public void setListaRiferimento(Riferimento listaRiferimento) {
		this.listaRiferimento = listaRiferimento;
	}

	/**
	 * @return the dataOrdine
	 */
	public String getDataOrdine() {
		return dataOrdine;
	}

	/**
	 * @param dataOrdine the dataOrdine to set
	 */
	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	/**
	 * @return the viaDestinazione
	 */
	public String getViaDestinazione() {
		return viaDestinazione;
	}

	/**
	 * @param viaDestinazione the viaDestinazione to set
	 */
	public void setViaDestinazione(String viaDestinazione) {
		this.viaDestinazione = viaDestinazione;
	}

	/**
	 * @return the cittaDestinazione
	 */
	public String getCittaDestinazione() {
		return cittaDestinazione;
	}

	/**
	 * @param cittaDestinazione the cittaDestinazione to set
	 */
	public void setCittaDestinazione(String cittaDestinazione) {
		this.cittaDestinazione = cittaDestinazione;
	}

	/**
	 * @return the capDestinazione
	 */
	public String getCapDestinazione() {
		return capDestinazione;
	}

	/**
	 * @param capDestinazione the capDestinazione to set
	 */
	public void setCapDestinazione(String capDestinazione) {
		this.capDestinazione = capDestinazione;
	}

	/**
	 * @return the numFattura
	 */
	public int getNumFattura() {
		return numFattura;
	}

	/**
	 * @param numFattura the numFattura to set
	 */
	public void setNumFattura(int numFattura) {
		this.numFattura = numFattura;
	}

	@Override
	public String toString() {
		return "FatturaBean [numFattura=" + numFattura + ", username_Cliente=" + username_Cliente + ", nomeNegozio="
				+ nomeNegozio + ", listaRiferimento=" + listaRiferimento + ", dataOrdine=" + dataOrdine + ", viaDestinazione="
				+ viaDestinazione + ", cittaDestinazione=" + cittaDestinazione + ", capDestinazione=" + capDestinazione
				+ "]";
	}





}