package managerOrdine;


public class Riferimento {
	
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
	
	public Fattura getFatturaRiferimento() {
		return fatturaRiferimento;
	}

	public void setFatturaRiferimento(Fattura fatturaRiferimento) {
		this.fatturaRiferimento = fatturaRiferimento;
	}

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
	
	public int getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(int i) {
		this.id_prodotto = i;
	}
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	public int getNumero_Fattura() {
		return numero_Fattura;
	}

	public void setNumero_Fattura(int i) {
		this.numero_Fattura = i;
	}

	public String getNome_Negozio() {
		return nome_Negozio;
	}

	public void setNome_Negozio(String nome_Negozio) {
		this.nome_Negozio = nome_Negozio;
	}

	public String getNome_Categoria() {
		return nome_Categoria;
	}

	public void setNome_Categoria(String nome_Categoria) {
		this.nome_Categoria = nome_Categoria;
	}

	public int getQtaOrdinata() {
		return qtaOrdinata;
	}

	public void setQtaOrdinata(int i) {
		this.qtaOrdinata = i;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}

	public void setPrezzoUnitario(float prezzoUnitario) {
		this.prezzoUnitario = prezzoUnitario;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

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
	
	
	
	
	
}
