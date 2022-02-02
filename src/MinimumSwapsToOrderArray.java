import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Ac� vamos a codificar la verdadera solucion de hackerrank... vamos a encontrar exactamente la menor
 * cantidad de swaps en un array de n elementos consecutivos DESORDENADOS
 * Para ello vamos a aplicar este algoritmo: https://www.youtube.com/watch?v=f7IIW0HVUcQ&ab_channel=FullStack
 * 
 * usamos grafos para ver la menor cantidad de swaps:
 * Algoritmo: itero por el array, me fijo el elemento de la 1era posicion, pregunto si ya lo iter�,
 * si no, le pregunto si est� en donde tiene que estar, no? entonces pregunto, d�nde deber�as estar?
 * y marco esa posici�n como que ya lo iter�, y me voy a la posicion en donde deber�a estar, y le 
 * pregunto al numero que est� ah� lo mismo que al anterior y as� hasta cumplir un ciclo (es decir
 * hasta que un numero vuelva al n�mero original). de ese ciclo, la cantidad m�nima de swaps est�
 * dada por n-1, o sea que si el ciclo es de 4 elementos, la cantidad m�nima de swaps va a ser 3. Esto
 * es como una ley... y le creo... si es 2, entonces 1.
 */

public class MinimumSwapsToOrderArray {
	
	public static void main(String[] args) {
		int[] arr = {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};
		System.out.println("Swapcount: " + minimumSwaps(arr));
	}
	
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int swapCount = 0;
    	boolean[] checks = new boolean[arr.length];
    	for(int i = 0; i < arr.length; i++) {
    		int j = i;
    		List<Integer> cycle = new LinkedList<Integer>();
    		while(!checks[j]) {
    			int currentElement = arr[j];
    			checks[j] = true;
    			if(currentElement == (j+1)) {
    				break;
    			} else {
    				cycle.add(currentElement);
    				j = currentElement - 1;
    			}
    		}
    		
    		if(cycle.size() > 1) {
    			swapCount = swapCount + cycle.size() - 1;
    		}
    	}
    	return swapCount;
    }
}
