package managerordine;

import java.util.ArrayList;
/**
 * Permette di gestire una lista di fatture con operazioni aggiunta 
 * @author cetra
 *
 */
public class ArrayFattura {
	
	/**
	 * costruttore che crea una arrylist di fatture vuoto
	 */
	public ArrayFattura() {
		listaFattura = new ArrayList<Fattura>();
	}

	/**
	 * Aggiunge una fattura alla lista
	 * @param f
	 */
	public void add(Fattura f) {
		listaFattura.add(f);
	}

	/**
	 * restituisce la lista delle fatture
	 * @return
	 */
	public  ArrayList<Fattura> getAllFatture(){
		return listaFattura;
	}

	private ArrayList<Fattura> listaFattura;

	}
