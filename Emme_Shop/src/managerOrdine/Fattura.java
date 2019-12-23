package managerOrdine;

import java.util.Date;

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
	
	public Fattura() {
	
		this.numFattura = 0;
		this.username_Cliente = "";
		this.nomeNegozio = "";
		this.dataOrdine = "";
		this.viaDestinazione = "";
		this.cittaDestinazione = "";
		this.capDestinazione = "";
	}
	
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
	
	
	
	
	public int getNumFattura() {
		return numFattura;
	}
	public void setNumFattura(int last_inserted_id) {
		this.numFattura = last_inserted_id;
	}
	public String getUsername_Cliente() {
		return username_Cliente;
	}
	public void setUsername_Cliente(String username_Cliente) {
		this.username_Cliente = username_Cliente;
	}
	public String getNomeNegozio() {
		return nomeNegozio;
	}
	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}
	public Riferimento getListaProdotti() {
		return listaRiferimento;
	}
	public void setListaRiferimenti(Riferimento riferimenti) {
		this.listaRiferimento = riferimenti;
	}
	public String getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(String dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public String getViaDestinazione() {
		return viaDestinazione;
	}
	public void setViaDestinazione(String viaDestinazione) {
		this.viaDestinazione = viaDestinazione;
	}
	public String getCittaDestinazione() {
		return cittaDestinazione;
	}
	public void setCittaDestinazione(String cittaDestinazione) {
		this.cittaDestinazione = cittaDestinazione;
	}
	public String getCapDestinazione() {
		return capDestinazione;
	}
	public void setCapDestinazione(String capDestinazione) {
		this.capDestinazione = capDestinazione;
	}
	
	@Override
	public String toString() {
		return "FatturaBean [numFattura=" + numFattura + ", username_Cliente=" + username_Cliente + ", nomeNegozio="
				+ nomeNegozio + ", listaRiferimento=" + listaRiferimento + ", dataOrdine=" + dataOrdine + ", viaDestinazione="
				+ viaDestinazione + ", cittaDestinazione=" + cittaDestinazione + ", capDestinazione=" + capDestinazione
				+ "]";
	}





}
