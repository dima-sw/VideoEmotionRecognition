package managernegozio;

import java.io.File;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;

import eccezione.CategoriaNonEsisteException;
import eccezione.ParametroNonCorrettoException;
import model.CategoriaDAO;

/**
 * la classe Categoria gestisce le operazioni di modifica,cancellazione e rimozione di una categoria
 * costruzine del path per inserimento delle imagini
 * @author cetra
 * 
 */
public class Categoria {
	
	
private static final long serialVersionUID = 1L;
	
	/**
 	* Permette di accedere alla classe DAO
 	* @see model.CategoriaDAO
 	*/
	static CategoriaDAO model= new CategoriaDAO();
	/**
	 * Permete di accedere alla classe DAO
	 * @see model.Negozio
	 */
	static Negozio negozio=new Negozio();
	
	private String nomeNegozio;
	private String nomeCategoria;
	private String descrizione;
	private String path;
	
	/**
	 * Costruttore vuoto
	 */
	public Categoria()
	{
		this.nomeNegozio="";
		this.nomeCategoria="";
		this.descrizione="";
		this.path="";
	}
	
	/**
	 * Costruttore crea istanza di Categoria
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param path
	 * @param descrizione
	 */
	public Categoria(String nomeNegozio, String nomeCategoria,String path, String descrizione)
	{
		this.nomeNegozio=nomeNegozio;
		this.nomeCategoria=nomeCategoria;
		this.descrizione=descrizione;
		this.path=path;
	}
	
	/**
	 *  Restituisce tutte le categorie di un determinato venditore, o lancia eccezione in caso venditore non esiste
	 * @param usernameVenditore, del venditore per restituire tutte le categorie associate
	 * @return ritorna la collezione delle categorie di un determinato venditore
	 * @throws SQLException
	 * @throws ParametroNonCorrettoException
	 */
	public Collection<Categoria> getAllCategoryBySeller(String usernameVenditore) throws SQLException, ParametroNonCorrettoException{
		if(usernameVenditore==null)
			throw new ParametroNonCorrettoException("Username Sbagliato del venditore: "+usernameVenditore);
		else
			return model.getAllCategoryBySeller(usernameVenditore);
	}
	
	
	/**
	 * Aggiunge una nuova categoria per un determinato negozio 
	 * <h2>Precondizione</h2>
	 * <pre>
	 *  nomeNegozio formato: lettere e numeri min 3, max 16
	 *  nomeCategoria formato: lettere e numeri min 3, max 16 
	 *  path percorso dove si trova image sul server inserita automaticamente 
	 *  descrizione formato: lettere cifre min 3 max 500
	 * </pre>
	 * 
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param path
	 * @param descrizione
	 * @return categoria aggiunta 
	 * @throws SQLException
	 */
	public Categoria addCategoria(String nomeNegozio,String nomeCategoria,String path,String descrizione) throws SQLException {
		
		Categoria categoria = new Categoria(nomeNegozio,nomeCategoria,path,descrizione);
		model.addCategoria(categoria);
		return categoria;
	}
	
	/**
	 * Crea la cartella nel server per un determinato negozio
	 * @param nomeNegozio, nome che viene dato alal cartella 
	 * @param UPLOAD_DIRECTORY, stringa path base del server
	 * @return String del path della cartella appena creato
	 */
	public String openCartellaNegozio(String nomeNegozio, String UPLOAD_DIRECTORY) {				
		
		String path=negozio.createCartellaNegozio(nomeNegozio, UPLOAD_DIRECTORY);
		//if(path.equals(UPLOAD_DIRECTORY))
			//return null;
		return path;
	}
	
	/**
	 * Crea il path per inserimento dell'image della categoria
	 *
	 * @param multiparts, lista
	 * @param nomeNegozio, serve per la composizione del path
	 * @param nomeCategoriaImage, serve per la composizione del path
	 * @param UPLOAD_DIRECTORY, stringa base del path per la costruzione
	 * @return String del path dove per image della categoria
	 * @throws Exception
	 */
	public String createPathCategoriaImage(List<FileItem> multiparts, String nomeNegozio,String nomeCategoriaImage,String UPLOAD_DIRECTORY) throws Exception {
		
		String urlLogo="";
		
		for(FileItem item : multiparts){
            if(!item.isFormField()){
                String name = new File(item.getName()).getName();
                int index = name.indexOf(".");
                String estensione= name.substring(index);
                item.write( new File(UPLOAD_DIRECTORY + File.separator + nomeCategoriaImage+estensione));
                urlLogo="images/negozi/"+nomeNegozio+"/"+nomeCategoriaImage+estensione;
                
                updatePathCategoria(nomeNegozio,nomeCategoriaImage,urlLogo);
            }
		}  
		return urlLogo;
	}
	
	
	/**
	 * Cancella la categoria di un determinato negozio
	 * @param nomeNegozio, nome del negozio di cui cancellare la categoria
	 * @param nomeCategoria, nome della categoria da cancellare
	 * @return boolean true se la cancellazione avviene con successo altrimenti lancia un eccezione
	 * @throws ParametroNonCorrettoException
	 * @throws SQLException
	 */
	public boolean deleteCategory(String nomeNegozio, String nomeCategoria) throws ParametroNonCorrettoException, SQLException{
		if(nomeNegozio==null || nomeCategoria==null) {
			throw new ParametroNonCorrettoException("Nome negozio o categoria non esiste!!!");
		}
		model.deleteCategory(nomeNegozio, nomeCategoria);
		
		return true;
	}
	
	/**
	 * Modifica il path dell'imagine della categoria
	 * <pre>
	 * i parametri di input sono controllati dalla servlet che chiama il metodo
	 * </pre>
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param urlLogo 
	 * @return boolean True se andato a buon fine
	 * @throws SQLException
	 */
	public boolean updatePathCategoria(String nomeNegozio,String nomeCategoria,String urlLogo) throws SQLException {
		boolean flag= model.updatePathCategoria(nomeNegozio,nomeCategoria, urlLogo);
		if(flag)
			return true;
		else {
			return false;
		}
	}
	
	/**
	 * Restituisce oggetto categoria di un determinato negozio specificando il nome.
	 * <pre>
	 * I paramtri di input sono controllati dalla servlet, prelevati dalla sessione 
	 * </pre>
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @return Categoria, dato il nome negozio e il nome categoria
	 * @throws SQLException
	 */
	public Categoria getCategoria(String nomeNegozio,String nomeCategoria) throws SQLException {
		Categoria cat= model.getCategoria(nomeNegozio, nomeCategoria);
		
			return cat;
	}
	
	/**
	 * Modifica la descrizione di una categoria 
	 * <pre>
	 * i parametri rispettano i formati e sono controllati sia da javascript che sul server
	 * </pre>
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param descrizione
	 * @return boolean True in caso di successo della modifica altrimenti false
	 * @throws SQLException
	 */
	public boolean updateDescrizioneCategoria(String nomeNegozio,String nomeCategoria,String descrizione) throws SQLException {
		return model.updateDescrizioneCategoria(nomeNegozio, nomeCategoria, descrizione);
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
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}
