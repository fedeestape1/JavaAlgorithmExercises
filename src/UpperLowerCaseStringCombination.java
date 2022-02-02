import java.util.ArrayList;
import java.util.List;

/*
 * La solucion de abajo se me ocurrió a mí y fue MUY eficiente en tiempo y aceptable en ESPACIO... y sirve para el 100% de los test cases
 * 
 * Dado un string que tiene numeros y letras, devolver una lista de strings del mismo string pero con mayusculas y minusculas y sus combinaciones de
 * mayusculas y minusculas
 * 
 * ejemplo: "a1bc" deberia devolver 8 combinaciones ["a1bc", "a1bC", "a1Bc", "a1BC", ...]. "123" debería devolver sólo una combinacion ["123"], etc
 * 
 */

public class UpperLowerCaseStringCombination {
	
	public static void main(String[] args) {
		System.out.println(new UpperLowerCaseStringCombination().letterCasePermutation("a1b2c"));
	}
	
    public List<String> letterCasePermutation(String s) {
        char[] alphabet = s.toCharArray();
        
        List<String> words = new ArrayList<String>();
        
        allPossibilities(alphabet, 0, words);
        return words;
    }
    
    void allPossibilities(char[] alphabet, int currentIndex, List<String> words){
        if(currentIndex == alphabet.length){
            words.add(new String(alphabet));
        } else if(Character.isLetter(alphabet[currentIndex])){
            allPossibilities(alphabet, currentIndex+1, words);
            convertCase(currentIndex, alphabet);
            allPossibilities(alphabet, currentIndex+1, words);
        } else{
            allPossibilities(alphabet, currentIndex+1, words);
        }
    }
    
    void convertCase(int i, char[] alphabet){
        if(Character.isLowerCase(alphabet[i])){
            alphabet[i] = Character.toUpperCase(alphabet[i]);
        } else{
            alphabet[i] = Character.toLowerCase(alphabet[i]);
        }
    }
}