package managernegozio;

import java.sql.SQLException;
import java.util.Collection;

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
