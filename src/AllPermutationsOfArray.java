import java.util.Arrays;

/*
 * El siguiente algoritmo imprime TODAS LAS COMBINACIONES POSIBLES de un array. Pero si en el array hay elementos repetidos, va a imprimir
 * mas de una vez cada combinacion posible. O sea que es eficiente SOLO para arrays con elementos DIFERENTES...
 * 
 * Para hacerlo eficiente con elementos repetidos no sé cómo habría que hacer sinceramente... habría que investigar
 */

public class AllPermutationsOfArray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		printPermutations(arr, 0);
	}
	
	public static void printPermutations(int[] arr, int currentIndex) {
		if(currentIndex == arr.length-1) {
			System.out.println(Arrays.toString(arr));
		} else {
			for(int i = currentIndex; i<arr.length; i++) {
				swap(i, currentIndex, arr);
				printPermutations(arr, currentIndex+1);
				swap(i, currentIndex, arr);
			}
		}
	}

	private static void swap(int i, int currentIndex, int[] arr) {
		if(i != currentIndex) {
			int aux = arr[i];
			arr[i] = arr[currentIndex];
			arr[currentIndex] = aux;
		}
	}
}
