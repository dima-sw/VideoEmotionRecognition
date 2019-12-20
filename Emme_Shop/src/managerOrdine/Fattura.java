package managerOrdine;

import java.util.Date;



/**
 * 
 * @author manlio
 *  la classe Fattura gestisce le operazioni di un ordine
 */
public class Fattura {
	

	public Fattura(int numeroFattura, Date dataOrdine, String viaDestinaziomne, String citt‡Destinazione,
			int capDestinazione) {
		
		this.numeroFattura = numeroFattura;
		this.dataOrdine = dataOrdine;
		this.viaDestinazione = viaDestinaziomne;
		this.citt‡Destinazione = citt‡Destinazione;
		this.capDestinazione = capDestinazione;
	}
	

	public Fattura() {
		this.numeroFattura = 0;
		this.dataOrdine = new Date();
		this.viaDestinazione = "";
		this.citt‡Destinazione = "";
		this.capDestinazione = 0;
	}

	
	
	
	/**
	 * @return the numeroFattura
	 */
	public int getNumeroFattura() {
		return numeroFattura;
	}
	/**
	 * @param numeroFattura the numeroFattura to set
	 */
	public void setNumeroFattura(int numeroFattura) {
		this.numeroFattura = numeroFattura;
	}
	/**
	 * @return the dataOrdine
	 */
	public Date getDataOrdine() {
		return dataOrdine;
	}
	/**
	 * @param dataOrdine the dataOrdine to set
	 */
	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	/**
	 * @return the viaDestinaziomne
	 */
	public String getViaDestinaziomne() {
		return viaDestinazione;
	}
	/**
	 * @param viaDestinaziomne the viaDestinaziomne to set
	 */
	public void setViaDestinaziomne(String viaDestinaziomne) {
		this.viaDestinazione = viaDestinaziomne;
	}
	/**
	 * @return the citt‡Destinazione
	 */
	public String getCitt‡Destinazione() {
		return citt‡Destinazione;
	}
	/**
	 * @param citt‡Destinazione the citt‡Destinazione to set
	 */
	public void setCitt‡Destinazione(String citt‡Destinazione) {
		this.citt‡Destinazione = citt‡Destinazione;
	}
	/**
	 * @return the capDestinazione
	 */
	public int getCapDestinazione() {
		return capDestinazione;
	}
	/**
	 * @param capDestinazione the capDestinazione to set
	 */
	public void setCapDestinazione(int capDestinazione) {
		this.capDestinazione = capDestinazione;
	}
	private int numeroFattura;
	private Date dataOrdine;
	private String viaDestinazione;
	private String citt‡Destinazione;
	private int capDestinazione;
}
