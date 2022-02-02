import java.util.Arrays;

/*
 * Esto surgio de un ejercicio de hackerrank en el que, dado un array tengo que encontrar la mínima
 * cantidad de swaps entre dos enteros para ordenar el array. Y si no me equivoco, el quicksort es
 * el algoritmo más rapido de ordenamiento de un array...
 * Entonces abajo esta la solucion implementando un quicksort. Pero no paso todos los tests...
 * Evidentemente es el mas rapido de ordenamiento para un array random de elementos
 * 
 * Pero en el ejercicio de hackerrank te dan n elementos CONSECUTIVOS, pero desordenados... y sin 
 * duplicados... o sea que quicksort los ordena pero no es el óptimo para este caso en particular,
 * porque hay elementos que probablemente ya se encuentren en su posicion ordenada y con quicksort
 * los estoy swapeando igual
 * 
 * Saque el algoritmo del quicksort de este video de youtube: https://www.youtube.com/watch?v=cnzIChso3cc&ab_channel=Algorithmguru
 */

public class QuickSort {
	
	static int swapCount = 0;
	
	public static void main(String[] args) {
		int[] arr = {2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};
		int tempSwapCount = minimumSwaps(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("swapCount: " + tempSwapCount);
	}
	
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	/*
    	 * Para mí, la menor cantidad de swaps va a estar dada por el algoritmo quicksort...
    	 * así que voy a intentar codificarlo:
    	 */
    	swapCount = 0;
    	recursiveQuickSort(0, arr.length-1, arr);
    	int tempSwapCount = swapCount;
    	swapCount = 0;
    	return tempSwapCount;
    }
    
    private static void recursiveQuickSort(int begin, int end, int[] arr) {
    	if(begin < end) {
        	int i = begin;
        	int pivotIndex = i;
        	int j = i+1;
	    	int pivot = arr[pivotIndex];
	    	while(j < end+1) {
	    		if(arr[j] < pivot) {
	    			i++;
	    			swap(i, j, arr);
	    		}
	    		j++;
	    	}
	    	swap(pivotIndex, i, arr);
	    	recursiveQuickSort(pivotIndex, i-1, arr);
	    	recursiveQuickSort(i+1, j-1, arr);
    	}
    }

	private static void swap(int i, int j, int[] arr) {
		if(i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			swapCount++;
		}
	}
}
