package managerordine;

import java.util.ArrayList;

public class ArrayFattura {
	
	
	public ArrayFattura() {
		listaFattura = new ArrayList<Fattura>();
	}

	public void add(Fattura f) {
		listaFattura.add(f);
	}

	public  ArrayList<Fattura> getAllFatture(){
		return listaFattura;
	}

	private ArrayList<Fattura> listaFattura;

	}
