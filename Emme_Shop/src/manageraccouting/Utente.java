package manageraccouting;

import java.io.Serializable;

/**
 * Classe Astratta Utente 
 * @author cetra
 *@see java.io.Serializable
 */
public abstract class Utente implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	String username;
	String password;
	
	/**
	 * Costruttore vuoto
	 */
	public Utente()
	{
		this.username="";
		this.password="";
	}
	
	/**
	 * Costruttore con i parametri 
	 * @param username
	 * @param password
	 */
	public Utente(String username, String password) {
		this.username = username;
		this.password= password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	



}
