import java.util.ArrayList;
import java.util.Collections;

/*
 * La siguiente solucion funciona para TODOS los test cases
 * 
 * Este ejercicio me lo tomaron en Toptal.
 * Dados 2 string[] uno con el nombre, y otro con el número de teléfono (todos del mismo length = 9) en el cual el i-ésimo elemento del names representa
 * el nombre del contacto con el teléfono i-esimo en el string[] phones.
 * Dados esos dos string[] mas un string num, devolver el NOMBRE de la persona cuyo TELÉFONO incluye esa secuencia de números SEGUIDOS.
 * Si hay más de un match, devolver el nombre alfabéticamente menor (a siempre es < b) de todos los posibles.
 * 
 * ej. jack: 1818181818, norma: 1919191919, fedoco: 000000001
 * si el string num es "1" la func debe devolver "fedoco" porque TODOS incluyen el "1" pero fedoco es alfabéticamente primero.
 * 
 * ej2: jack: 1818181818, norma: 1818191919, fedoco: 000000001
 * si el num es "181" devolver: "jack"
 * si el num es "891" devolver "not possible", porque si bien norma tiene esos numeros, los mismos NO SON CONSECUTIVOS.
 * 
 * Esto último lo aclaraba el ejercicio, lo cual es medio al pedo (quizas para otros lenguajes no) porque el string.contains() ya te lo resuelve a que
 * el primer string CONTENGA CONSECUTIVAMENTE al segundo string... asique :shrugging-shoulders:
 * 
 */

public class PhoneNumbersContacts {
	public static void main(String[] args) {
		String[] names = {"tato", "monkey", "fedoco", "beto"};
		String[] phones = {"8901809", "190000099", "019019018019", "11018999888222"};
		System.out.println(printName(names, phones,"018"));
	}
	
	private static String printName(String[] names, String[] phones, String num) {
		
		ArrayList<String> possibleContacts = new ArrayList<String>();
		for(int i = 0; i < phones.length; i++) {
			if(phones[i].contains(num)) {
				possibleContacts.add(names[i]);
			}
		}
		
		if(!possibleContacts.isEmpty()) {
			Collections.sort(possibleContacts);
			return possibleContacts.get(0);
		}
		
		return "not possible";
	}

	private static String printName2(String[] names, String[] phones, String num) {
		
		ArrayList<Contact> possibleContacts = new ArrayList<Contact>();
		for(int i = 0; i < phones.length; i++) {
			if(phones[i].contains(num)) {
				possibleContacts.add(new Contact(names[i], phones[i]));
			}
		}
		
		if(!possibleContacts.isEmpty()) {
			Collections.sort(possibleContacts);
			return possibleContacts.get(0).getName();
		}
		
		return "not possible";
	}
}

class Contact implements Comparable<Contact> {

	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	@Override
	public int compareTo(Contact o) {
		return this.name.compareTo(o.getName());
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}	
}
