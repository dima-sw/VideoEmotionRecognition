package control;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author cetra
 *classe che contiene metodi statici per la validazione dei vari campi degli utenti
 */
public class Controlli {
	
	private static FileWriter file;

	public Controlli()throws IOException{
		file=new FileWriter("log.txt");
	}
	
	public static boolean isName(String nome) {
		if(nome.matches("[A-Za-z]{1,25}$"))
			return true;
		else 
			return false;
	}
	
	public static boolean isUsername(String username) {
		if(username.matches("^[0-9a-zA-Z]{3,16}$"))
			return true;
		else 
			return false;
	}
	
	public static boolean isStreet(String via) {
		if(via.matches("^[0-9a-zA-Z ]+$"))
			return true;
		else 
			return false;
	}
	
	/**
	 * possibile formato di una password: alfanumerica, minimo 8, massimo 16 caratteri
	almeno una maiuscola una minuscola ed una cifra almeno una maiuscola, una minuscola ed una cifra
	funzione che restituisca true se la pwd è corretta, false altrimenti
	 * @param passw
	 * @return
	 */
	public static boolean isPassword(String passw) {
		if(passw.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[_.,\\-+*!#@?])([a-zA-Z0-9_.,\\-+*!#@?]{6,25})"))
			return true;
		else 
			return false;
	}
	
	public static boolean isEmail(String email) {
		if(email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
			return true;
		else 
			return false;
	}
	
	public static boolean isText(String text) {
		if(text.matches("^([a-zA-Zàèìòù' ]$"))
			return true;
		else 
			return false;
	}
	
	public static boolean isPivaIT(String iva) {
		if(iva.matches("^[0-9]{11}$"))
			return true;
		else
			return false;
	}
		
	public static boolean isCap(String cap) {
		if(cap.matches("\\d{5}$"))
			return true;
		else 
			return false;
	}
		
	public static boolean isPhoneNumber(String tel) {
		if(tel.matches("\\d{10}$"))
			return true;
		else
			return false;
	}
	
	public static boolean isPrezzo(String prezzo) {
		if(prezzo.matches("^([0-9]{1,9})\\.([0-9]{0,2})$"))
			return true;
		else
			return false;
	}
	
	public static boolean isQuantità(String qta) {
		if(qta.matches("[0-9]+$"))
			return true;
		else
			return false;
	}
	
	public static boolean isSconto(String sconto) {
		if(sconto.matches("[0-9]{0,2}$"))
			return true;
		else
			return false;
	}
	
}
