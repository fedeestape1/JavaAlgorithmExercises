/*
 * El siguiente ejercicio consiste en escribir una funcion que tome dos strings. Si el 1er string se puede alterar de forma tal que forme
 * el mismo string2 entonces debe devolver "true", de lo contrario: "false".
 * el algoritmo de abajo funciona para todos los inputs, pero NO ES EFICIENTE... porque prueba absolutamente todas las combinaciones en un 
 * orden definido...
 * Es super ineficiente porque el algoritmo debería ser otro... codificarlo en otra clase...
 */

public class TwoStringsScramble {

  private static boolean finishRecursion = false;
  private static String solution = "false";
  
  public static void main (String[] args) {
	  System.out.println(StringScramble("qwoertypoiuyo", "qpruwooo"));
  }

  public static String StringScramble(String str1, String str2) {
    String key = str2;
    char[] alphabet = str1.toCharArray();

    recursiveMatchingAlgorithm(alphabet, key, 0);

    return solution;
  }

  public static void recursiveMatchingAlgorithm(char[] alphabet, String key, int currentIndex){
    if(currentIndex == key.length() || finishRecursion){
      String possibleMatch = new String(alphabet);
      System.out.println(possibleMatch.substring(0, key.length()));
      if(possibleMatch.substring(0, key.length()).equals(key)){
        solution = "true";
        finishRecursion = true;
      }
    } else{
      for(int i = currentIndex; i<alphabet.length; i++){
        swap(alphabet, i, currentIndex);
        recursiveMatchingAlgorithm(alphabet, key, currentIndex+1);
        swap(alphabet, i, currentIndex);
      }
    }
  }

  public static void swap(char[] alphabet, int i, int currentIndex){
    if(i != currentIndex){
      char aux = alphabet[i];
      alphabet[i] = alphabet[currentIndex];
      alphabet[currentIndex] = aux;
    }
  }
}