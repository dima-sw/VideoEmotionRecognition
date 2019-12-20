package managernegozio;

/**
 * 
 * la classe Prodotto gestisce le operazioni di modifica, cancellazione di un prodotto
 * */
public class Prodotto {
	
	public Prodotto() {
		this.idProdotto=0;
		this.iva = 0;
		this.path = " ";
		this.prezzo = 0;
		this.qta = 0;
		this.sconto = 0;
		this.descrizione = "";
	}
	
	public Prodotto(int idProdotto, int iva, String path, int prezzo, int qta, int sconto, String descrizione) {
		this.idProdotto = idProdotto;
		this.iva = iva;
		this.path = path;
		this.prezzo = prezzo;
		this.qta = qta;
		this.sconto = sconto;
		this.descrizione = descrizione;
	}
	
    /**
     * 
     * @return int
     */
	public int getIdProdotto() {
		return idProdotto;
	}
	
	/**
	 * questo metodo setta l'id di un prodotto
	 * @param id è l'id da assegnare
	 */
	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}
    /**
     * 
     * @return int
     */
	public int getIva() {
		return iva;
	}
	
	/**
	 * questo metodo setta l'iva di un prodotto
	 * @param iva è l'iva da assegnare
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}
	
    /**
     * 
     * @return string
     */
	public String getPath() {
		return path;
	}
	
	/**
	 * questo metodo setta il path dove è contenuta l'immagine del prodotto
	 * @param path è il path da assegnare
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
    /**
     * 
     * @return int
     */
	public int getPrezzo() {
		return prezzo;
	}
	
	/**
	 * questo metodo setta il prezzo di un prodotto
	 * @param prezzo è il prezzo da assegnare
	 */
	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
    /**
     * 
     * @return int
     */
	public int getQta() {
		return qta;
	}
	
	/**
	 * questo metodo setta la quantità di un prodotto
	 * @param qtà è la quantità da assegnare
	 */
	public void setQta(int qta) {
		this.qta = qta;
	}
	
    /**
     * 
     * @return int
     */
	public int getSconto() {
		return sconto;
	}
	
	/**
	 * questo metodo setta lo sconto di un prodotto
	 * @param sconto è la sconto da assegnare
	 */
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}
	
    /**
     * 
     * @return string
     */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * questo metodo setta la descrizione di un prodotto
	 * @param descrizione è la descrizione da assegnare
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
		private int idProdotto;    
    	private int iva;           
   	private String path;       
    	private int prezzo;        
    	private int qta;           
    	private int sconto;        
    	private String descrizione;
}