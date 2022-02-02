/*
 * Dada una matriz de enteros de 6x6, hallar la suma mayor de todos sus hourglass (en total son 16
 * hourglass)
 * Un hourglass es el conjunto de elementos de un array como el siguiente:
 * a b c
 *   d
 * e f g
 * 
 * La siguiente solucion paso todos los tests. Tardé 17 minutos en resolverlo
 */

public class HourglassSumMatrix {

	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int row = 0;
        int biggestSum = 0;
        while(row <= 3){
            int col = 0;
            while(col <= 3){
                int sum = arr[row][col] + arr[row][col+1] + arr[row][col+2]
                + arr[row+1][col+1] + arr[row+2][col] + arr[row+2][col+1]
                + arr[row+2][col+2];
                if(sum > biggestSum || (row == 0 && col == 0)){
                    biggestSum = sum;
                }
                col++;
            }
            row++;
        }
        return biggestSum;
    }
}
