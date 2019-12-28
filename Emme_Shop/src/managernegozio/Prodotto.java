package managernegozio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import dao.ProdottoDAO;

/**
 * 
 * la classe Prodotto gestisce le operazioni di modifica, cancellazione di un prodotto
 * */
public class Prodotto {
	
	static ProdottoDAO model=new ProdottoDAO();
	
	public Prodotto() {
		this.nomeNegozio = "";
		this.nomeCategoria = "";
		this.nome = "";
		this.idProdotto=0;
		this.iva = 0;
		this.path = " ";
		this.prezzo = 0;
		this.qta = 0;
		this.sconto = 0;
		this.descrizione = "";
	}
	
	public Prodotto(int idProdotto,String nomeNegozio,String nomeCategoria,String nome,int iva, String path, float prezzo, int qta, int sconto, String descrizione) {
		this.nomeNegozio = nomeNegozio;
		this.nomeCategoria = nomeCategoria;
		this.nome = nome;
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
	 * @param id
	 * @return String path dell'id
	 * @throws SQLException
	 */
	public String getPathByID(int id) throws SQLException{
		
		String path=model.getPathByID(id);
		return path;
	}
	
	public Collection<Prodotto> getAllProductBySellerCategory(String venditore,String categoria) throws SQLException{
		return model.getAllProductBySellerCategory(venditore, categoria);
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
     * @return float
     */
	public float getPrezzo() {
		return prezzo;
	}
	
	/**
	 * questo metodo setta il prezzo di un prodotto
	 * @param prezzo è il prezzo da assegnare
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
    /**
     * 
     * @return int
     */
	public int getQuantita() {
		return qta;
	}
	
	/**
	 * questo metodo setta la quantità di un prodotto
	 * @param qtà è la quantità da assegnare
	 */
	public void setQuantita(int qta) {
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
	 * @return the nomeCategoria
	 */
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	/**
	 * @param nomeCategoria the nomeCategoria to set
	 */
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	
	

		private String nomeNegozio;
		private String nomeCategoria;
		private int idProdotto;    
    	private int iva;           
    	private String nome;
		private String path;       
    	private float prezzo;        
    	private int qta;           
    	private int sconto;        
    	private String descrizione;
}
