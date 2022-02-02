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

public class PrintMinimumBribesOnArray2 {

	public static void main(String[] args) {
		List<Integer> q = Arrays.asList(2, 1, 5, 3, 8,7,6,4);
		minimumBribes(q);
	}

    public static void minimumBribes(List<Integer> q) {
    	int minimumBribes = 0;
    	String response = "";
    	for(Integer i = q.size() - 1; i>=0; i--) {
    		Integer currentElement = q.get(i);
    		if(currentElement.equals(i+1)) {
    			continue;
    		} else if(i-1 >= 0 && q.get(i-1).equals(i+1)) {
    			q.set(i, q.get(i-1));
    			q.set(i-1, currentElement);
    			minimumBribes++;
    		} else if(i-2 >= 0 && q.get(i-2).equals(i+1)) {
    			q.set(i, q.get(i-2));
    			q.set(i-2, q.get(i-1));
    			q.set(i-1, currentElement);
    			minimumBribes = minimumBribes +2;
    		} else {
    			response = "Too chaotic";
    		}
    	}
    	if(response.isEmpty()) {
    		System.out.println(minimumBribes);
    	} else {
    		System.out.println(response);
    	}
    	
    }
	
}
