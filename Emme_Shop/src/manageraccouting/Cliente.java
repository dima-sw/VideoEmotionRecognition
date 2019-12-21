package manageraccouting;

import java.sql.SQLException;

import dao.ClienteDAO;

public class Cliente extends Utente{
	private static final long serialVersionUID = 1L;
	
	static ClienteDAO model= new ClienteDAO();
	
	private String nome;
	private String cognome;
	private String email;
	private String sesso;
	private String telefono;
	private String via;
	private String citta;
	private String cap;
	
	public Cliente()
	{
		super();
		this.nome = "";
		this.cognome = "";
		this.email = "";
		this.sesso = "";
		this.telefono = "";
		this.via = "";
		this.citta = "";
		this.cap = "";
	}
/**
 * 
 * @param username
 * @param password
 * @param nome
 * @param cognome
 * @param email
 * @param sesso
 * @param telefono
 * @param via
 * @param citta
 * @param cap
 */

	public Cliente(String username, String password, String nome, String cognome, String email, String sesso,
			String telefono, String via, String citta, String cap) 
	{
		super(username, password);
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.telefono = telefono;
		this.via = via;
		this.citta = citta;
		this.cap = cap;
	}

	
	/**
	 * verifica se i dati inseriti corrispondono ad un utente nel database
	 * 
	 * @param user
	 * @param password
	 * @return Utente
	 * @throws SQLException
	 */
	public Utente checkLogin(String user,String password) throws SQLException {
		
		return model.checkLoginClient(user, password);
	}
	
	
	
	
	/**
	 * 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * 
	 * @return String cognome
	 */
	public String getCognome() {
		return cognome;
	}
	/**
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	/**
	 * 
	 * @return String email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return String sesso
	 */
	public String getSesso() {
		return sesso;
	}
	/**
	 * 
	 * @param sesso
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	/**
	 * 
	 * @return String telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * 
	 * @return String via
	 */
	public String getVia() {
		return via;
	}
	/**
	 * 
	 * @param via
	 */
	public void setVia(String via) {
		this.via = via;
	}
	/**
	 * 
	 * @return String citta
	 */
	public String getCitta() {
		return citta;
	}
	/**
	 * 
	 * @param citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	/**
	 * 
	 * @return String cap
	 */
	public String getCap() {
		return cap;
	}
	/**
	 * 
	 * @param cap
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	
}
