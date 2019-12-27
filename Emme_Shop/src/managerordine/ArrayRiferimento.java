package managerordine;

import java.util.ArrayList;

import managerordine.Riferimento;

public class ArrayRiferimento {
	public ArrayRiferimento(){
		listaRiferimento=new ArrayList<Riferimento>();
	}
	
	public void add(Riferimento f) {
		listaRiferimento.add(f);
}
	
	public ArrayList<Riferimento> getAllRiferimento(){
		return listaRiferimento;
	}
	
	private ArrayList<Riferimento> listaRiferimento;
}
