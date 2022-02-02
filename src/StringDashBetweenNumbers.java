import java.util.ArrayList;

/*
 * El siguiente ejercicio me lo tomaron para entrar a Toptal (lo resolvi josha)
 * Consiste en dado un string que puede contener numeros, "-" y " " tiene que devolver los mismos números pero agrupados de a 3 en 3 separados por
 * un guion medio "-". El último grupo puede terminar en una cantidad de 2 números. o bien los DOS ultimos en una cantidad de 2 números. Pero NINGUNO
 * puede terminar en cantidad de 1 número.
 * Restriccion: el input siempre va a tener AL MENOS 2 números
 * 
 * Para esta solución (me costó) pero usé String.join (no lo conocia hasta acá).
 */

public class StringDashBetweenNumbers {
	public static void main(String[] args) {
//		System.out.println(convertStringNumbers("1 -2   3"));//deberia devolver "123"
//		System.out.println(convertStringNumbers("1 -2   34"));//deberia devolver "12-34"
//		System.out.println(convertStringNumbers("12   3-4-2"));//deberia devolver "123-42"
//		System.out.println(convertStringNumbers("- 1     2"));//deberia devolver "12"
		System.out.println(convertStringNumbers("   5 -1   9    0   234"));//deberia devolver "519-02-34"
//		System.out.println(convertStringNumbers("1 -2   34  90900"));//deberia devolver "123-490-900"
	}

	public static String convertStringNumbers(String word2) {
		
		String firstFilter = word2.replace(" ", "");
		String secondFilter = firstFilter.replace("-", "");
		String word = secondFilter;
		
		ArrayList<String> groups = new ArrayList<String>();
		if(word.length() % 3 == 0) {
			for(int i = 1; i <= word.length(); i++) {
				if(i % 3 == 0) {
					groups.add(word.substring(i - 3, i));
				}
			}
		} else if(word.length() % 3 == 2) {
			String addAtLast = word.substring(word.length() - 2, word.length());
			for(int i = 1; i <= word.length(); i++) {
				if(i % 3 == 0) {
					groups.add(word.substring(i - 3, i));
				}
			}
			groups.add(addAtLast);
		} else if(word.length() % 3 == 1) {
			String addAtLast = word.substring(word.length() - 2, word.length());
			String addPrevToLast = word.substring(word.length() - 4, word.length() - 2);
			for(int i = 1; i <= word.length()-2; i++) {
				if(i % 3 == 0) {
					groups.add(word.substring(i - 3, i));
				}
			}
			groups.add(addPrevToLast);
			groups.add(addAtLast);
		}
		
		return String.join("-", groups);
	}
}
