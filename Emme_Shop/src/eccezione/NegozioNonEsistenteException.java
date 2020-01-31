package eccezione;

/**
 * Eccezione Negozio non esiste
 * @author cetra
 *
 */
public class NegozioNonEsistenteException extends Exception {

	public NegozioNonEsistenteException(String msg) {
		super(msg);
	}
	public NegozioNonEsistenteException() {
		super();
	}
}
