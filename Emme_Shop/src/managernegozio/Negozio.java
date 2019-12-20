package managernegozio;

/**
 * 
 * @author manlio
 * la classe Negozio gestisce le operazioni di aggiunta,rimozione,modifca di un prodotto e categoria
 *
 */
public class Negozio {

	public Negozio(String nome, String design, String descrizione, String via, String città, int cap, String logo) {
		this.nome = nome;
		this.design = design;
		this.descrizione = descrizione;
		this.via = via;
		this.città = città;
		this.cap = cap;
		this.logo = logo;
	}
	
	/**
	 * 
	 * @return string
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * Questo metodo settare il nome del negozio
	 * @param nome è il nome del negozio nuovo da assegnare
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * 
	 * @return string
	 */
	public String getDesign() {
		return design;
	}
	
	/**
	 * Questo metodo setta il layout del menu
	 * @param design è il nome del design da assegnare
	 */
	public void setDesign(String design) {
		this.design = design;
	}
	/**
	 * 
	 * @return string
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * Questo metodo setta una descrizione al negozio
	 * @param descrizione è il nome della descrizione da assegnare
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * 
	 * @return string
	 */
	public String getVia() {
		return via;
	}
	/**
	 * Questo metodo setta la via del negozio
	 * @param  via è la via da assegnare
	 */
	public void setVia(String via) {
		this.via = via;
	}
	/**
	 * 
	 * @return string
	 */
	public String getCittà() {
		return città;
	}
	
	/**
	 * Questo metodo setta la città del negozio
	 * @param città è la città da assegnare
	 */
	public void setCittà(String città) {
		this.città = città;
	}
	/**
	 * 
	 * @return int
	 */
	public int getCap() {
		return cap;
	}
	/**
	 * Questo metodo setta il cap al negozio
	 * @param cap è il cap del negozio  da assegnare
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}
	/**
	 * 
	 * @return string
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * Questo metodo setta il logo del negozio
	 * @param logo è il logo del negozio  da assegnare
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	
	private String nome;
	private String design;
	private String descrizione;
	private String via;
	private String città;
	private int cap;
	private String logo;

}

