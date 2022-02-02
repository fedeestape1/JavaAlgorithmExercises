import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent (N,S,W,E) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:


Input: grid = [
[2,1,1],
[1,1,0],
[0,1,1]]
Output: 4
 */

class BFSRottingOranges {
    public int orangesRotting(int[][] grid) {
        HashSet<Integer[]> rottenIndexes = new HashSet<Integer[]>();
        int actualFresh = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    rottenIndexes.add(new Integer[]{i,j});
                } else if(grid[i][j] == 1){
                    actualFresh++;
                }
            }
        }
        
        LinkedList<Integer[]> queue = new LinkedList<Integer[]>();
        HashSet<List<Integer>> visited = new HashSet<List<Integer>>();
        for(Integer[] indexes : rottenIndexes){
            queue.add(indexes);
            visited.add(Arrays.asList(indexes));
        }
        
        
        
        int minutes = 0;
        Integer[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int currentLayer = rottenIndexes.size();
        int neighbours = 0;
        boolean shouldCount = false;
        while(!queue.isEmpty()){
            queue.forEach(a -> System.out.print(Arrays.toString(a)));
            System.out.println();
            Integer[] current = queue.removeFirst();
            for(Integer[] direction : directions){
                Integer ni = current[0] + direction[0];
                Integer nj = current[1] + direction[1];
                if(ni < 0 || ni >= grid.length || nj < 0 || nj >= grid[0].length || visited.contains(Arrays.asList(new Integer[]{ni, nj}))) {
                    continue;
                }
                
                if(grid[ni][nj] == 1){
                    queue.add(new Integer[]{ni, nj});
                    visited.add(Arrays.asList(new Integer[]{ni, nj}));
                    neighbours++;
                    shouldCount = true;
                    actualFresh--;
                }
            }
            
            currentLayer--;
            if(currentLayer == 0){
                currentLayer = neighbours;
                neighbours = 0;
                if(shouldCount){
                    minutes++;
                    shouldCount = false;
                }
            }
        }
        
        return actualFresh == 0 ? minutes : -1;
    }
}