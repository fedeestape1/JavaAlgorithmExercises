/*
 * dada una matriz de n * m, contar todas las submatrices de todos los tamaños (1x1, 1x2, 1x3, 1xn, 2x1,2x2,2xn,...nxm) que se compongan de 1
 * Los elementos de la matriz SOLO tienen 1s y 0s.
 * 
 * 
 * El algoritmo siguiente es SUPER eficiente. la complejidad es O(N x M x M), es decir, recorro todos los elementos de la matríz y por cada elemento
 * recorro toda la fila (no toda la matriz / sub matriz, sino toda la fila del elemento actual).
 * Por cada celda voy a sumarle al RESULTADO FINAL la cantidad de posibilidades, tomando como referencia la celda actual, todas las posibilidades de
 * las submatrices considerando que la celda actual es la celda de MAS ABAJO A LA DERECHA (BOTTOM RIGHT) de las sub matrices... y voy contando todas
 * esas posibilidades
 * 
 * Para esto SÓLO se necesita un array height[mat[0].length] (array de tamaño M) que vaya actualizando el height[j] la altura acumulada de arriba
 * a abajo por cada columna. Con esto ya tengo ABSOLUTAMENTE TODO lo que necesito...
 * 
 */


class MatrixCountSubMatrixOfOnes {
    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length, height[] = new int[n], res = 0; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;   //  height of histogram;
                for (int k = j, min = height[j]; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    res += min;
                }
            }
        }
        return res;
    }
}