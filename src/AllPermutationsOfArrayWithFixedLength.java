import java.util.Arrays;

/*
 * El siguiente algoritmo imprime TODAS LAS COMBINACIONES POSIBLES de un array. Pero si en el array hay elementos repetidos, va a imprimir
 * mas de una vez cada combinacion posible. O sea que es eficiente SOLO para arrays con elementos DIFERENTES...
 * 
 * Para hacerlo eficiente con elementos repetidos
 */

public class AllPermutationsOfArrayWithFixedLength {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		printPermutations(arr, 0, 4);
	}
	
	public static void printPermutations(int[] arr, int currentIndex, int maxLength) {
		if(currentIndex == maxLength) {
			System.out.println(Arrays.toString(arr));
		} else {
			for(int i = currentIndex; i < arr.length; i++) {
				swap(i, currentIndex, arr);
				printPermutations(arr, currentIndex+1, maxLength);
				swap(i, currentIndex, arr);
			}
		}
	}
	
	private static void swap(int i, int j, int[] arr) {
		if(i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
