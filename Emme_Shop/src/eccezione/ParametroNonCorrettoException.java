package eccezione;

/**
 * Eccezione parametro non corretto
 * @author cetra
 *
 */
public class ParametroNonCorrettoException extends Exception{
	
	public ParametroNonCorrettoException() {
		super();
	}
	public ParametroNonCorrettoException(String msg) {
		super(msg);
	}
}
