package eccezione;

/**
 * Eccezzione categoria non esiste
 * @author cetra
 *
 */
public class CategoriaNonEsisteException extends Exception {

	public CategoriaNonEsisteException (String msg) {
		super(msg);
	}
	public CategoriaNonEsisteException() {
		super();
	}
}
