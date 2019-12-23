package eccezione;

public class NegozioNonEsistenteException extends Exception {

	public NegozioNonEsistenteException(String msg) {
		super(msg);
	}
	public NegozioNonEsistenteException() {
		super();
	}
}
