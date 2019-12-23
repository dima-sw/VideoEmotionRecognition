package eccezione;

public class ParametroNonCorrettoException extends Exception{
	
	public ParametroNonCorrettoException() {
		super();
	}
	public ParametroNonCorrettoException(String msg) {
		super(msg);
	}
}
