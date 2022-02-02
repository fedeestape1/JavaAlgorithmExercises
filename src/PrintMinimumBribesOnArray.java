import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Te dan una lista q de enteros desordenada. Cada entero representa la posición que le corresponde en
 * la fila, es decir, entero 1 representa la posicion 0 del array, el 2 la posicion 1 y asi...
 * Cada entero puede SOBORNAR al elemento más cercano para adelantarse en la fila, pero puede
 * sobornar como mucho a 2 elementos (más no).
 * Programar una funcion que, dada una lista q imprima por pantalla el número mínimo de sobornos
 * que tuvo que haber para llegar a la lista q. PERO si al menos un entero soborno a más de uno
 * tenes que imprimir "Too chaotic" (o too chaotic o el mín de sobornos)
 * 
 * Este ej no lo pude resolver solo, tuve que mirar un video en youtube para resolverlo... pero
 * entendí el algoritmo y lo programé a continuación...
 */

public class PrintMinimumBribesOnArray {

	public static void main(String[] args) {
		List<Integer> q = Arrays.asList(2, 1, 5, 3, 4);
		minimumBribes(q);
	}
	
    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
    // Write your code here
        int bribesCount = 0;
        boolean tooChaotic = false;
        for(int i = q.size()-1; i >= 0; i--) {
        	Integer currentElement = q.get(i);
        	int currentPosition = i+1;
        	if(currentElement != currentPosition) {
        		if(i-1 >= 0 && q.get(i-1) == currentPosition) {
        			q.set(i, q.get(i-1));
        			q.set(i-1, currentElement);
        			bribesCount++;
        		} else if(i-2 >= 0 && q.get(i-2) == currentPosition) {
        			q.set(i, q.get(i-2));
        			q.set(i-2, q.get(i-1));
        			q.set(i-1, currentElement);
        			bribesCount += 2;
        		} else {
        			System.out.println("Too chaotic");
        			tooChaotic = true;
        			break;
        		}
        	}
        }
        if(!tooChaotic) {
        	System.out.println(bribesCount);
        }
    }
	
}
