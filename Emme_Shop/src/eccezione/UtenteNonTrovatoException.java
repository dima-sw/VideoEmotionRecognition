package eccezione;

/**
 * Eccezione Utente non trovato
 * @author cetra
 *
 */
public class UtenteNonTrovatoException extends Exception{

	public UtenteNonTrovatoException(String msg) {
		super(msg);
	}
	public UtenteNonTrovatoException() {
		super();
	}
}
