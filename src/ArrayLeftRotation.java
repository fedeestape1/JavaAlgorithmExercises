
/*
 * dado un array de ints y un int d, por cada int del array, moverlo una posicion a la izquierda
 * y siempre el primer elemento del array pasa al último elemento (porque a la izquierda no hay nada)
 * Tardé 24 / 25 minutos en encontrar la solución más óptima (porque primero encontre una solucion
 * pero no era lo suficientemente eficiente para pasar todos los tests...)
 */

public class ArrayLeftRotation {
	
	// Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	int[] b = new int[a.length];
    	for(int i = 0; i < a.length; i++) {
    		b[i] = a[(i+d) % a.length];
    	}
    	return b;
    }
	
    /*
     * La siguiente solucion anduvo bien para el 80% de los tests, pero el 20% no pasó porque 
     * el algoritmo no es lo suficientemente eficiente... tarda mucho en ejecutar...
     * El algoritmo de arriba paso el 100% de los tests
     */
    static int[] rotLeftBadSolution(int[] a, int d) {

    	int cont = 0;
    	while(cont < d) {
	    	int i = 0;
	    	int firstInt = a[0];
	    	while(i < a.length) {
	    		if(i != a.length - 1) {
	    			a[i] = a[i+1];
	    		}
	    		i++;
	    	}
	    	a[a.length-1] = firstInt;
	    	cont++;
	    }
    	
    	return a;
    }
}
