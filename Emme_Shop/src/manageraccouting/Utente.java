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
	
	public Utente()
	{
		this.username="";
		this.password="";
	}
	public Utente(String username, String password) {
		this.username = username;
		this.password= password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	



}
