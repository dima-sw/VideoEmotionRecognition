package managernegozio;

import java.io.File;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;

import eccezione.ParametroNonCorrettoException;

/**
 * 
 * la classe Prodotto gestisce le operazioni di modifica, cancellazione di un prodotto
 * */
public class Prodotto {
	
	static ProdottoDAO model=new ProdottoDAO();
	static Categoria categoria=new Categoria();
	
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
	private int prova = 0;
	
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
	/**
	 * restituisce tutti i prodotti relativa a quella categoria di quel venditore.
	 * @param venditore
	 * @param categoria
	 * @return Collection<Prodotto> può essere anche vuota
	 * @throws SQLException
	 * @throws ParametroNonCorrettoException 
	 */
	public Collection<Prodotto> getAllProductBySellerCategory(String venditore,String categoria) throws SQLException, ParametroNonCorrettoException{
		if (venditore==null || categoria==null) {
			throw new ParametroNonCorrettoException("Venditore o categoria non esiste!!! riprova");
		}
		Collection<Prodotto> prodotti=model.getAllProductBySellerCategory(venditore, categoria);
		return prodotti;
	}
	
	public Prodotto addProdotto(Prodotto prodotto) throws SQLException, ParametroNonCorrettoException {
		if (prodotto==null) {
			throw new ParametroNonCorrettoException("Prodotto inserito non valido!!");
		}
		Prodotto prod=model.addProdotto(prodotto);
		
		return prod;
	}
	
	
	public String openCartellaNegozio(String nomeNegozio, String UPLOAD_DIRECTORY) {				
		/*
		UPLOAD_DIRECTORY+="\\"+nomeNegozio;
		if(!(new File(UPLOAD_DIRECTORY)).exists())
			new File(UPLOAD_DIRECTORY).mkdir();
		return UPLOAD_DIRECTORY;*/
		String path=categoria.openCartellaNegozio(nomeNegozio, UPLOAD_DIRECTORY);
		//if(path.equals(UPLOAD_DIRECTORY))
			//return null;
		return path;
	}
	
	/**
	 *  Crea il path del image prodotto
	 * @param multiparts
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param nomeProdottoImage   id del prodotto
	 * @param UPLOAD_DIRECTORY
	 * @return String path del logo
	 * @throws Exception
	 */
	public String createPathProdottoImage(List<FileItem> multiparts, String nomeNegozio,String nomeCategoria,int nomeProdottoImage,String UPLOAD_DIRECTORY) throws Exception {
		
		String urlLogo="";
		
		 for(FileItem item : multiparts){
             if(!item.isFormField()){
                 String name = new File(item.getName()).getName();
                 int index = name.indexOf(".");
                 String estensione= name.substring(index);
                 item.write( new File(UPLOAD_DIRECTORY + File.separator + nomeProdottoImage+estensione));
                 urlLogo="images/negozi/"+nomeNegozio+"/"+nomeProdottoImage+estensione;
                 
                 updatePathProdotto(nomeNegozio,nomeCategoria,nomeProdottoImage,urlLogo);
                 
              }
		}  
		return urlLogo;
	}
	
	/**
	 * Modifica il path dell'image del prodotto
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param id
	 * @param logo
	 * @return boolean 
	 * @throws SQLException
	 */
	public boolean updatePathProdotto(String nomeNegozio, String nomeCategoria, int id, String logo) throws SQLException {
		
		model.updatePathProdotto(nomeNegozio, nomeCategoria, id, logo);
		
		return true;
	}
	
	public   boolean deleteProduct (int id ) throws SQLException {
		return model.deleteProduct(id);
	}
	
	public Prodotto getProductById(int idProdotto) throws SQLException {
		return model.getProductById(idProdotto);
	}
	
	public boolean updateProdotto(Prodotto bean) throws SQLException {
		return model.updateProdotto(bean);
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
	
	

	
	

		
}
