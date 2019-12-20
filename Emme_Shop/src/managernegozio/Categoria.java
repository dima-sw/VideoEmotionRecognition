package managernegozio;

/**
 * 
 * @author manlio
 * la classe Categoria gestisce le operazioni di modifica,cancellazione e rimozione di una categoria
 */
public class Categoria {
	
	public Categoria(String nomeCategoria, String descrizione, String path) {
		this.nomeCategoria = nomeCategoria;
		this.descrizione = descrizione;
		this.path = path;
	}
	
	public Categoria() {
		this.nomeCategoria = " ";
		this.descrizione = " ";
		this.path = " ";
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	/**
	 * questo metodo assegna il nome di una categoria
	 * @param nomeCategoria il nome della categoria da assegnare
	 */
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * questo metodo assegna una descrizione
	 * @param descrizione il nome della categoria da assegnare
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * 
	 * @return String
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * questo metodo assegna il path dove è contenuta l'immagine della categoria
	 * @param path il path da assegnare
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	private String nomeCategoria;
	private String descrizione;
	private String path;
}
