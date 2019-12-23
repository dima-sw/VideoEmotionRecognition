package eccezione;

public class UtenteNonTrovatoException extends Exception{

	public UtenteNonTrovatoException(String msg) {
		super(msg);
	}
	public UtenteNonTrovatoException() {
		super();
	}
}
