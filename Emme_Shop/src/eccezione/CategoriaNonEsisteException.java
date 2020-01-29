package eccezione;

public class CategoriaNonEsisteException extends Exception {

	public CategoriaNonEsisteException (String msg) {
		super(msg);
	}
	public CategoriaNonEsisteException() {
		super();
	}
}
