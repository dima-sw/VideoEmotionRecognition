package managernegozio;

import java.io.File;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;

import dao.CategoriaDAO;
import eccezione.ParametroNonCorrettoException;

/**
 * 
 * @author manlio
 * la classe Categoria gestisce le operazioni di modifica,cancellazione e rimozione di una categoria
 */
public class Categoria {
	
	
private static final long serialVersionUID = 1L;
	
	static CategoriaDAO model= new CategoriaDAO();
	
	
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
	
	public String createCartellaNegozio(String nomeNegozio, String UPLOAD_DIRECTORY) {				
		UPLOAD_DIRECTORY+="\\"+nomeNegozio;
		if(!(new File(UPLOAD_DIRECTORY)).exists())
			new File(UPLOAD_DIRECTORY).mkdir();
		return UPLOAD_DIRECTORY;
	}
	
	public String createPathLogo(List<FileItem> multiparts, String nomeNegozio,String nomeCategoria,String UPLOAD_DIRECTORY) throws Exception {
		
		String urlLogo="";
		
		for(FileItem item : multiparts){
            if(!item.isFormField()){
                String name = new File(item.getName()).getName();
                int index = name.indexOf(".");
                String estensione= name.substring(index);
                item.write( new File(UPLOAD_DIRECTORY + File.separator + nomeNegozio+estensione));
                urlLogo="images/negozi/"+nomeNegozio+"/"+nomeCategoria+estensione;
                updateLogoCategoria(nomeNegozio,nomeCategoria,urlLogo);
            }
		}  
		return urlLogo;
	}
	
	public boolean updateLogoCategoria(String nomeNegozio,String nomeCategoria,String urlLogo) throws SQLException {
		return model.updatePathCategoria(nomeNegozio,nomeCategoria, urlLogo);
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
