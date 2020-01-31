package managerordine;

import java.util.ArrayList;

import managerordine.Riferimento;
/**
 * Ha le funzionalità per gestire un array di oggetti riferimento
 * @author cetra
 *
 */
public class ArrayRiferimento {
	/**
	 * Costruttore crea un lista riferimento vuota
	 */
	public ArrayRiferimento(){
		listaRiferimento=new ArrayList<Riferimento>();
	}
	
	/**
	 * Aggiunge un riferimento alla lista
	 * @param f
	 */
	public void add(Riferimento f) {
		listaRiferimento.add(f);
	}
	
	/**
	 * restituisce la lista riferimento
	 * @return ArrayList<Riferimento>
	 */
	public ArrayList<Riferimento> getAllRiferimento(){
		return listaRiferimento;
	}
	
	private ArrayList<Riferimento> listaRiferimento;
}
