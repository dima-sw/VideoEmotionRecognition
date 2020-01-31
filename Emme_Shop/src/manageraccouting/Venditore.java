package manageraccouting;

import java.sql.SQLException;

import eccezione.ParametroNonCorrettoException;
import eccezione.UtenteNonTrovatoException;
import model.VenditoreDAO;

/**
 * La classe rappresenta un Venditore, è una specializzazione di Utente
 * Permette di trovare se un venditore è presente nel database,
 * 
 * @author cetra
 *@see Utente
 */
public class Venditore extends Utente {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Permette di accedere alla classe DAO
	 * @see model.VenditoreDAO
	 */
	static VenditoreDAO model= new VenditoreDAO();
	
	private String nome;
	private String cognome;
	private String email;
	private String sesso;
	private String telefono;
	private String via;
	private String citta;
	private String cap;
	
	/**Costruttore vuoto*/
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
	
	/**
	 * Costruttore che crea un istanza di venditore
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
	 * Controlla che nel database sia presente un istanza di venditore con username e password identiche 
	 * come quelle passate come parametro
	 * 
	 * @param username, username del venditore da cercare
	 * @param password, password del venditore da cercare
	 * @return ritorna l'istanza del utente cercato
	 * @throws SQLException
	 * @throws UtenteNonTrovatoException
	 * @throws ParametroNonCorrettoException
	 */
	public Utente checkLogin(String username, String password) throws SQLException, UtenteNonTrovatoException, ParametroNonCorrettoException {
			if(username==null || password==null)
				throw new ParametroNonCorrettoException("Username e Password inseriti errati");
			
			Utente utente= model.checkLoginSeller(username, password);
			
			if(utente==null)
				throw new UtenteNonTrovatoException("Errore utente non trovato");
			else 
				return utente;
	}
	
	/**
	 *  Crea un nuovo venditore, i parametri sono controllati da javascript e espressioni regolari direttamente all'inserimento.
	 *	<h2>Precondizione</h2>
	 * <pre>
	 * 	username formato: lettere e numeri, min 3, max 16
	 * 	password formato: almeno lettera minuscola e maiuscola, un numero, carattere speciale <br> min 6, max 25
	 * 	nome formato: solo lettere minimo 1 max 25
	 * 	cognome formato: solo lettere minimo 1 max 25
	 * 	email formato: una sola @, un punto con max 3 lettere alla fine.
	 * 	sesso formato: uno dei tre specificati M,F,Other
	 * 	telefono formato: 10 cifre.Senza spazi
	 * 	via formato: lettere e cifre
	 * 	citta formato: lettere e cifre
	 * 	cap formato: 5 cifre
	 * </pre>
	 * @param username, del venditore da inserire
	 * @param password, del venditore da inserire
	 * @param nome , del venditore da inserire
	 * @param cognome, del venditore da inserire
	 * @param email, del venditore da inserire
	 * @param sesso, del venditore da inserire
	 * @param telefono, del venditore da inserire
	 * @param via, del venditore da inserire
	 * @param citta, del venditore da inserire
	 * @param cap, del venditore da inserire
	 * @return ritorna oggetto Venditore appena aggiunto.
	 * @throws SQLException
	 */
	public Venditore addVenditore(String username, String password, String nome, String cognome, String email, String sesso,
			String telefono, String via, String citta, String cap) throws SQLException {
			
		Venditore venditore=new Venditore(username, password, nome, cognome, email, sesso, telefono, via, citta,  cap);
		try {
			model.addVenditore(venditore);
			return venditore;
		}
		catch(SQLException e) {
			throw new SQLException("Creazione venditore fallita, errore: "+e.getMessage());
		}
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

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the sesso
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * @param sesso the sesso to set
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the via
	 */
	public String getVia() {
		return via;
	}

	/**
	 * @param via the via to set
	 */
	public void setVia(String via) {
		this.via = via;
	}

	/**
	 * @return the citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * @param citta the citta to set
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * @return the cap
	 */
	public String getCap() {
		return cap;
	}

	/**
	 * @param cap the cap to set
	 */
	public void setCap(String cap) {
		this.cap = cap;
	}

	
	
	
	
	
}
