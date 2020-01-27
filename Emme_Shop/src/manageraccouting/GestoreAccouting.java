package manageraccouting;

import java.sql.SQLException;

import model.GestoreAccoutingDAO;

public class GestoreAccouting extends Utente{

	private static final long serialVersionUID = 1L;

	static GestoreAccoutingDAO model=new GestoreAccoutingDAO();
	
	private String nome;
	private String cognome;
	private String email;
	private String sesso;
	private String telefono;
	
	public GestoreAccouting()
	{
		super();
		this.nome = "";
		this.cognome = "";
		this.email = "";
		this.sesso = "";
		this.telefono = "";
	}
	
	public GestoreAccouting(String username, String password, String nome, String cognome, String email, String sesso,
			String telefono) 
	{
		super(username,password);
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.sesso = sesso;
		this.telefono = telefono;
	}
	
	/**
	 * Verifica se i dati inseriti corrispondono ad un utente nel database
	 * 
	 * @param username
	 * @param password
	 * @return Utente
	 * @throws SQLException 
	 */
	public Utente checkLogin(String username, String password) throws SQLException {
		
		return model.checkLoginAdmin(username, password);
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


}
