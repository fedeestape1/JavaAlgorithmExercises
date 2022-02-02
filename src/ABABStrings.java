
/*
 * You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

Example
s = AABAAB
Remove an A at positions 0 and 3 to make s=ABAB in 2 deletions.

Function Description

Complete the alternatingCharacters function in the editor below.


Esta solucion paso el 100% de los tests
 */

public class ABABStrings {

	public static int alternatingCharacters(String s) {
        char lastChar = s.charAt(0);
        int cont = 0;
        int minimumDeletions = 0;
        for(char c : s.toCharArray()) {
        	if(c == lastChar) {
        		cont++;
        		if(cont > 1) {
        			minimumDeletions++;
        		}
        	} else {
        		cont = 1;
        	}
        	
        	lastChar = c;
        }
        return minimumDeletions;
    }

}
