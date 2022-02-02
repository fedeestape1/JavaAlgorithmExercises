
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 * 
 */

public class PlayerRanks 
{
    public static void main( String[] args )
    {
    	ArrayList<Integer> eso = new ArrayList<Integer>();
    	eso.add(50);
    	eso.add(25);
    	eso.add(50);
    	eso.add(100);
    	System.out.println(numPlayers(3, eso));
    }
    
    public static int numPlayers(int k, List<Integer> scores) {
    	Collections.sort(scores, Collections.reverseOrder());
    	Integer lastScore = scores.get(0);
    	int rank = 1;
    	int index = 1;
    	int qualifiers = 0;
        for(Integer score : scores) {
        	if(score != lastScore) {
        		rank = index;
        	}
        	lastScore = score;
        	index++;
        	if(rank <= k) {
        		qualifiers++;
        	}
        }
        
        return qualifiers;
    }

	public static int numPlayersBadSolution(int k, List<Integer> scores) {
        Collections.sort(scores, Collections.reverseOrder());
        
        ArrayList<Integer> ranks = new ArrayList<Integer>();
        HashMap<Integer, Integer> scoreCounts = new HashMap<Integer,Integer>();
        
        for(Integer score : scores){
            if(scoreCounts.get(score) == null){
                scoreCounts.put(score, 0);
            }
            scoreCounts.put(score, scoreCounts.get(score) + 1);
        }
        System.out.println(scores);
        System.out.println(scoreCounts);
        
        //[100,50,50,25]
        //100->1, 50->2, 25->1 
        int i = 1;
        int a = 1;
        while(i <= scores.size()){
        	
        	int j = 0;
        	int length = scoreCounts.get(scores.get(i-1));
            while(j < length){
            	System.out.println(i);
                ranks.add(a);
                j = j+1;
                i = i+1;
            }
            a = i;
        }
        
        System.out.println(ranks);
        
        int qualifiers = 0;
        for(int rank : ranks) {
        	if(rank <= k) {
        		qualifiers++;
        	}
        }
        
        return qualifiers;
    }
    
}
