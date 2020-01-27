package managernegozio;

import java.io.File;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;

import eccezione.ParametroNonCorrettoException;
import model.CategoriaDAO;

/**
 * 
 * @author manlio
 * la classe Categoria gestisce le operazioni di modifica,cancellazione e rimozione di una categoria
 */
public class Categoria {
	
	
private static final long serialVersionUID = 1L;
	
	static CategoriaDAO model= new CategoriaDAO();
	static Negozio negozio=new Negozio();
	
	private String nomeNegozio;
	private String nomeCategoria;
	private String descrizione;
	private String path;
	
	public Categoria()
	{
		this.nomeNegozio="";
		this.nomeCategoria="";
		this.descrizione="";
		this.path="";
	}
	public Categoria(String nomeNegozio, String nomeCategoria,String path, String descrizione)
	{
		this.nomeNegozio=nomeNegozio;
		this.nomeCategoria=nomeCategoria;
		this.descrizione=descrizione;
		this.path=path;
	}
	
	/**
	 * 
	 * @param usernameVenditore
	 * @return Restituisce la collection di tutte le categorie
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
	 * Inserimento di una nuova categoria
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param path
	 * @param descrizione
	 * @return la categoria inserita
	 * @throws SQLException
	 */
	public Categoria addCategoria(String nomeNegozio,String nomeCategoria,String path,String descrizione) throws SQLException {
		
		Categoria categoria = new Categoria(nomeNegozio,nomeCategoria,path,descrizione);
		model.addCategoria(categoria);
		return categoria;
	}
	
	/**
	 * Apre la cartella del negozio per salvare image della categoria
	 * @param nomeNegozio
	 * @param UPLOAD_DIRECTORY
	 * @return
	 */
	public String openCartellaNegozio(String nomeNegozio, String UPLOAD_DIRECTORY) {				
		
		String path=negozio.createCartellaNegozio(nomeNegozio, UPLOAD_DIRECTORY);
		//if(path.equals(UPLOAD_DIRECTORY))
			//return null;
		return path;
	}
	
	/**
	 * Crea il path della Categoria image
	 * @param multiparts
	 * @param nomeNegozio
	 * @param nomeCategoria
	 * @param UPLOAD_DIRECTORY
	 * @return
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
	
	
	public boolean deleteCategory(String nomeNegozio, String nomeCategoria) throws ParametroNonCorrettoException, SQLException{
		if(nomeNegozio==null || nomeCategoria==null) {
			throw new ParametroNonCorrettoException("Nome negozio o categoria non esiste!!!");
		}
		model.deleteCategory(nomeNegozio, nomeCategoria);
		
		return true;
	}
	
	public boolean updatePathCategoria(String nomeNegozio,String nomeCategoria,String urlLogo) throws SQLException {
		return model.updatePathCategoria(nomeNegozio,nomeCategoria, urlLogo);
	}
	
	
	public Categoria getCategoria(String nomeNegozio,String nomeCategoria) throws SQLException {
		return model.getCategoria(nomeNegozio, nomeCategoria);
	}
	
	
	public boolean updateDescrizioneCategoria(String nomeNegozio,String nomeCategoria,String descrizione) throws SQLException {
		return model.updateDescrizioneCategoria(nomeNegozio, nomeCategoria, descrizione);
	}
	
	
	
		
	public String getNomeNegozio() {
		return nomeNegozio;
	}
	public void setNomeNegozio(String nomeNegozio) {
		this.nomeNegozio = nomeNegozio;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
}
