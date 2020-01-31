package managerordine;

import java.sql.SQLException;

import eccezione.ParametroNonCorrettoException;
import model.RiferimentoDAO;
/**
 * Contiene i dati permenenti di una fattura, ha i metodi getter e setter per modificare l'oggetto riferimento
 * inoltre permette di gestire arrayriferimento.
 * @author cetra
 *
 */
public class Riferimento {
	
	static RiferimentoDAO model=new RiferimentoDAO();
	
	static ArrayRiferimento arrayriferimento=new ArrayRiferimento();
	
	private int id_prodotto;
	private int numero_Fattura;
	private String nome_Negozio;
	private String nome_Categoria;
	private int qtaOrdinata;
	private int sconto;
	private float prezzoUnitario;
	private int iva;
	private String note;
	private Fattura fatturaRiferimento;
	
	
	
	/**
	 * restituisce la fattura referita
	 * @return Fattura
	 */
	public Fattura getFatturaRiferimento() {
		return fatturaRiferimento;
	}

	/**
	 * setta la fattura riferimento
	 * @param fatturaRiferimento
	 */
	public void setFatturaRiferimento(Fattura fatturaRiferimento) {
		this.fatturaRiferimento = fatturaRiferimento;
	}

	/**
	 * costruttore vuoto
	 */
	public Riferimento()
			{
		this.id_prodotto=0;
		this.numero_Fattura=0;
		this.nome_Negozio="";
		this.nome_Negozio="";
		this.qtaOrdinata=0;
		this.sconto=0;
		this.prezzoUnitario=0;
		this.iva=0;
		
	}
	
	/**
	 * Costruttore che crea un oggetto Riferimento
	 * @param id_prodotto
	 * @param numero_Fattura
	 * @param nome_Negozio
	 * @param nome_Categoria
	 * @param qtaOrdinata
	 * @param sconto
	 * @param prezzoUnitario
	 * @param iva
	 */
	public Riferimento(int id_prodotto, int numero_Fattura, String nome_Negozio,
			String nome_Categoria, int qtaOrdinata, int sconto, float prezzoUnitario,
			int iva)
			{
		this.id_prodotto=id_prodotto;
		
		this.numero_Fattura=numero_Fattura;
		this.nome_Negozio=nome_Negozio;
		this.nome_Negozio=nome_Categoria;
		this.qtaOrdinata=qtaOrdinata;
		this.sconto=sconto;
		this.prezzoUnitario=prezzoUnitario;
		this.iva=iva;
		
	}

	/**
	 * Costruttore che crea un oggetto riferimento con nota
	 * @param id_prodotto
	 * @param numero_Fattura
	 * @param nome_Negozio
	 * @param nome_Categoria
	 * @param qtaOrdinata
	 * @param sconto
	 * @param prezzoUnitario
	 * @param iva
	 * @param note
	 */
	public Riferimento(int id_prodotto, int numero_Fattura, String nome_Negozio, String nome_Categoria,
			int qtaOrdinata, int sconto, float prezzoUnitario, int iva, String note) {
		super();
		this.id_prodotto = id_prodotto;
		this.numero_Fattura = numero_Fattura;
		this.nome_Negozio = nome_Negozio;
		this.nome_Categoria = nome_Categoria;
		this.qtaOrdinata = qtaOrdinata;
		this.sconto = sconto;
		this.prezzoUnitario = prezzoUnitario;
		this.iva = iva;
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "RiferimentoBean [id_prodotto=" + id_prodotto + ", numero_Fattura=" + numero_Fattura + ", nome_Negozio="
				+ nome_Negozio + ", nome_Categoria=" + nome_Categoria + ", qtaOrdinata=" + qtaOrdinata + ", sconto="
				+ sconto + ", prezzoUnitario=" + prezzoUnitario + ", iva=" + iva + ", note=" + note + "]";
	}

	/**
	 * Restituisce una lista di oggetti riferimenti associati ad un negozio
	 * <pre> nomeNegozio diverso da null</pre>
	 * @param nomeNegozio
	 * @return
	 * @throws ParametroNonCorrettoException
	 * @throws SQLException
	 */
	public ArrayRiferimento getArrayRiferimento(String nomeNegozio) throws ParametroNonCorrettoException, SQLException {
		
		if(nomeNegozio==null)
			throw new ParametroNonCorrettoException("Nome negozio non esistente, non è possibile visualizzare le fatture");
		
		this.arrayriferimento=model.getArrayRiferimento(nomeNegozio);
		if (this.arrayriferimento==null) {
			return null;
		}
		else
			return this.arrayriferimento;
	}

	/**
	 * @return the id_prodotto
	 */
	public int getId_prodotto() {
		return id_prodotto;
	}

	/**
	 * @param id_prodotto the id_prodotto to set
	 */
	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	/**
	 * @return the numero_Fattura
	 */
	public int getNumero_Fattura() {
		return numero_Fattura;
	}

	/**
	 * @param numero_Fattura the numero_Fattura to set
	 */
	public void setNumero_Fattura(int numero_Fattura) {
		this.numero_Fattura = numero_Fattura;
	}

	/**
	 * @return the nome_Negozio
	 */
	public String getNome_Negozio() {
		return nome_Negozio;
	}

	/**
	 * @param nome_Negozio the nome_Negozio to set
	 */
	public void setNome_Negozio(String nome_Negozio) {
		this.nome_Negozio = nome_Negozio;
	}

	/**
	 * @return the nome_Categoria
	 */
	public String getNome_Categoria() {
		return nome_Categoria;
	}

	/**
	 * @param nome_Categoria the nome_Categoria to set
	 */
	public void setNome_Categoria(String nome_Categoria) {
		this.nome_Categoria = nome_Categoria;
	}

	/**
	 * @return the qtaOrdinata
	 */
	public int getQtaOrdinata() {
		return qtaOrdinata;
	}

	/**
	 * @param qtaOrdinata the qtaOrdinata to set
	 */
	public void setQtaOrdinata(int qtaOrdinata) {
		this.qtaOrdinata = qtaOrdinata;
	}

	/**
	 * @return the sconto
	 */
	public int getSconto() {
		return sconto;
	}

	/**
	 * @param sconto the sconto to set
	 */
	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	/**
	 * @return the prezzoUnitario
	 */
	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	/**
	 * @param prezzoUnitario the prezzoUnitario to set
	 */
	public void setPrezzoUnitario(float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	/**
	 * @return the iva
	 */
	public int getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(int iva) {
		this.iva = iva;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	
	

	
	
	
	
	
}
