package manageraccouting;

import java.sql.SQLException;

import dao.VenditoreDAO;

public class Venditore extends Utente {

	private static final long serialVersionUID = 1L;
	
	static VenditoreDAO model= new VenditoreDAO();
	
	private String nome;
	private String cognome;
	private String email;
	private String sesso;
	private String telefono;
	private String via;
	private String citta;
	private String cap;
	
	public Venditore()
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
	
	public Venditore(String username, String password, String nome, String cognome, String email, String sesso,
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
	 * @param username
	 * @param password
	 * @return Utente
	 * @throws SQLException
	 */
	public Utente checkLogin(String username, String password) throws SQLException {
		
			return model.checkLoginSeller(username, password);
	}
	
	public Venditore addVenditore(String username, String password, String nome, String cognome, String email, String sesso,
			String telefono, String via, String citta, String cap) throws SQLException {
			
		Venditore venditore=new Venditore(username, password, nome, cognome, email, sesso, telefono, via, citta,  cap);
		model.addVenditore(venditore);
		return venditore;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	
	
	
}
