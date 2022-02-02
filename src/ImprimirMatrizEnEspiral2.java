import java.util.LinkedList;
import java.util.List;

/*
 * dada una matriz n*m devolver una lista de enteros cuyo orden de elementos sea el equivalente a recorrer la matriz en espiarl
 */

class ImprimirMatrizEnEspiral2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        
        int ri = 0;
        int ci = 0;
        int[] rowDirection = {0, 1, 0, -1};
        int[] columnDirection = {1, 0, -1, 0};
        int directionIndex = 0;
        boolean[][] visited = new boolean[rowLength][columnLength];
        for(int i = 0; i<rowLength*columnLength; i++){
            visited[ri][ci] = true;
            ans.add(matrix[ri][ci]);
            System.out.println(ans);
            int rowCandidate = ri + rowDirection[directionIndex];
            int columnCandidate = ci + columnDirection[directionIndex];
            if(0<=rowCandidate && rowCandidate<rowLength && 0<= columnCandidate && columnCandidate< columnLength && !visited[rowCandidate][columnCandidate]){
                ri = rowCandidate;
                ci = columnCandidate;
            } else{
                directionIndex = (directionIndex + 1) % 4;
                ri = ri + rowDirection[directionIndex];
                ci = ci + columnDirection[directionIndex];
            }
        }
        
        return ans;
    }
}