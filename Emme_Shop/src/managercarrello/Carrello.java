package managercarrello;
import java.util.ArrayList;
import java.util.List;
import managernegozio.Prodotto;

public class Carrello {
	
	public Carrello() {
		this.prodotti = null;
	}
	

	public Carrello(List<Prodotto> prodotti) {
		this.prodotti = new ArrayList<Prodotto>();
	}
	
	public void aggiungiProdotto(Prodotto prodotto) {
		this.prodotti.add(prodotto);
	}
	
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}


	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	
	private List<Prodotto> prodotti;

}
