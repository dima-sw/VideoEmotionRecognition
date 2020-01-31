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
	
	/**
	 * Controlla se la descrizione è conforme, lunghezza tra 3 e 500, escluso caratteri # ^ °
	 * @param desc
	 * @return boolean
	 */
	public static boolean isDesc(String desc) {
		if (desc.length()>3 && desc.length()<500) {
			if (desc.contains("#") || desc.contains("^") ||desc.contains("°") ) {
				return false;}
		
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * Controlla se il nome è conforme, lettere e lunghezza tra 1, 25
	 * @param nome
	 * @return boolean
	 */
	public static boolean isName(String nome) {
		if(nome.matches("[A-Za-z]{1,25}$"))
			return true;
		else 
			return false;
	}
	/*public static boolean isNameProdotto(String nome) {
		if(nome.matches("[0-9A-Za-z]{2,25}$"))
			return true;
		else 
			return false;
	}*/
	
	/**
	 * Controlla se l'username e conforme, lettere e numeri, lunghezza tra 3 e 16 caretteri
	 * @param username
	 * @return
	 */
	public static boolean isUsername(String username) {
		if(username.matches("^[0-9a-zA-Z]{3,16}$"))
			return true;
		else 
			return false;
	}
	
	/**
	 * Controlla il formato della strada, lettere e numeri
	 * @param via
	 * @return boolean
	 */
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
	
	/**
	 * Controlla il formato dell'email, deve essere composto da una @ e un . seguito da 2 3 caratteri
	 * @param email
	 * @return boolean
	 */
	public static boolean isEmail(String email) {
		if(email.matches("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
			return true;
		else 
			return false;
	}
	
	/**
	 * Controlla il formato del testo
	 * @param text
	 * @return boolean
	 */
	public static boolean isText(String text) {
		if(text.matches("^([a-zA-Zàèìòù' ]$"))
			return true;
		else 
			return false;
	}
	
	/**Controlla il formato della partita iva italiana, solo numeri 11 cifre.
	 * 
	 * @param iva
	 * @return boolean
	 */
	public static boolean isPivaIT(String iva) {
		if(iva.matches("^[0-9]{11}$"))
			return true;
		else
			return false;
	}
		
	/**
	 * Controlla il cao del formato, 5 cifre
	 * @param cap
	 * @return boolean
	 */
	public static boolean isCap(String cap) {
		if(cap.matches("\\d{5}$"))
			return true;
		else 
			return false;
	}
		
	/**
	 * Controlla il numero di telefono 10 cifre
	 * @param tel
	 * @return boolean
	 */
	public static boolean isPhoneNumber(String tel) {
		if(tel.matches("\\d{10}$"))
			return true;
		else
			return false;
	}
	
	/**
	 * Controlla il formato del prezzo, 1 o 9 cifre, seguito da un punto, seguito da 0 o 2 cifre
	 * @param prezzo
	 * @return boolean
	 */
	public static boolean isPrezzo(String prezzo) {
		if(prezzo.matches("^([0-9]{1,9})\\.([0-9]{0,2})$"))
			return true;
		else
			return false;
	}
	
	/**
	 * Controlla il fermato della quantita, 9 cifre al massimo
	 * @param qta
	 * @return boolean
	 */
	public static boolean isQuantità(String qta) {
		if(qta.matches("[0-9]+$"))
			return true;
		else
			return false;
	}
	
	/**
	 * Controlla il formato dello sconto 2 cifre 
	 * @param sconto
	 * @return boolean
	 */
	public static boolean isSconto(String sconto) {
		if(sconto.matches("[0-9]{0,2}$"))
			return true;
		else
			return false;
	}
	
}
