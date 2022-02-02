import java.util.Arrays;

/*
 * Dado un int n construir una matriz n*n llena con numeros del 1 al n*n en secuencia espiral:
 * 123
 * 894
 * 765
 * 
 * 
 * Si fuese N*M habría que reemplazar algunas partes del codigo en donde dice n por matriz.length y por matriz[0].length
 */

class ImprimirMatrizEnEspiral {
	
	public static void main(String[] args) {
		new ImprimirMatrizEnEspiral().generateMatrix(9);
	}
    public int[][] generateMatrix(int n) {
        
        int[][] ans = new int[n][n];
        int ri = 0;
        int ci = 0;
        int[] rowDirections = {0, 1, 0, -1};
        int[] columnDirections = {1, 0, -1, 0};
        int directionIndex = 0;
        boolean[][] visited = new boolean[n][n];
        for(int i = 1; i <= n*n; i++){
            System.out.println("row index: "+ri);
            System.out.println("column index: "+ci);
            visited[ri][ci] = true;
            ans[ri][ci] = i;
            System.out.println(Arrays.deepToString(ans));
            int candidateRow = ri + rowDirections[directionIndex];
            int candidateColumn = ci + columnDirections[directionIndex];
            if(0<=candidateRow && candidateRow<n && 0<=candidateColumn && candidateColumn<n && !visited[candidateRow][candidateColumn]){
                ri = candidateRow;
                ci = candidateColumn;
            } else{
                directionIndex = (directionIndex+1) % 4;
                ri = ri + rowDirections[directionIndex];
                ci = ci + columnDirections[directionIndex];
            }
        }
        
        return ans;
    }
}