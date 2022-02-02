import java.util.HashMap;

/*
 * El siguiente ejercicio consiste en escribir una funcion que tome dos strings. Si el 1er string se puede alterar de forma tal que forme
 * el mismo string2 entonces debe devolver "true", de lo contrario: "false".
 * 
 * El siguiente algoritmo parecería ser uno de los más eficientes. Consiste en iterar el alfabeto 1 sola vez, y la key 2 veces. La 1ra vez del key y del
 * alfabero es para guardar las frecuencias de las letras. La segunda vez del key es para comparar las frecuencias y las ocurrencias. Las ocurrencias
 * tienen que ser sí o sí iguales. Las frecuencias tienen que cumplir: keyFrequency <= alphabetFrequency. Si se cumplen ambos casos: return true, else
 * false
 * 
 */

public class TwoStringsScramble2 {
	
	public static void main(String[] args) {
		System.out.println(StringScramble("rkqoodlw", "world"));
	}

	public static String StringScramble(String str1, String str2) {
		HashMap<Character, Integer> keyCharFrequency = new HashMap<Character, Integer>();
		populateCharFrequencies(str2, keyCharFrequency);
		HashMap<Character, Integer> alphabetCharFrequency = new HashMap<Character, Integer>();
		populateCharFrequencies(str1, alphabetCharFrequency);
		for (Character c : str2.toCharArray()) {
			Integer alphabetFrequency = alphabetCharFrequency.get(c);
			if (alphabetFrequency == null || !(keyCharFrequency.get(c) <= alphabetFrequency)) {
				return "false";
			}
		}
		return "true";
	}

	public static void populateCharFrequencies(String word, HashMap<Character, Integer> charFrequency) {
		for (Character c : word.toCharArray()) {
			if (charFrequency.get(c) == null) {
				charFrequency.put(c, 0);
			}
			charFrequency.put(c, charFrequency.get(c) + 1);
		}
	}
}