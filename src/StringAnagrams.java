import java.util.HashMap;
import java.util.HashSet;

/*
 * A student is taking a cryptography class and has found anagrams to be very useful. Two strings are anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency. For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

The student decides on an encryption scheme that involves two large strings. The encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Determine this number.

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

Example
a = 'cde'
b = 'dcf'

Delete e from a and f from b so that the remaining strings are a and b which are anagrams. This takes 2 character deletions.

El proximo algoritmo resuelve el 100% de los tests
 */

public class StringAnagrams {

    public static int makeAnagram(String a, String b) {
    // Write your code here
        HashMap<Character, Integer> aCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> bCount = new HashMap<Character, Integer>();
        for(Character c : a.toCharArray()) {
        	if(aCount.get(c) == null) {
        		aCount.put(c, 0);
        	}
        	aCount.put(c, aCount.get(c) + 1);
        }
        for(Character c : b.toCharArray()) {
        	if(bCount.get(c) == null) {
        		bCount.put(c, 0);
        	}
        	bCount.put(c, bCount.get(c) + 1);
        }
        
        System.out.println("a count: "+ aCount);
        System.out.println("b count: "+ bCount);
        
        int minDeletions = 0;
        HashSet<Character> removedA = new HashSet<Character>(aCount.keySet());
        removedA.removeAll(bCount.keySet());
        HashSet<Character> removedB = new HashSet<Character>(bCount.keySet());
        removedB.removeAll(aCount.keySet());
        
        System.out.println(aCount);
        System.out.println(bCount);
        
        for(Character c : removedA) {
        	minDeletions = minDeletions + aCount.get(c);
        }
        for(Character c : removedB) {
        	minDeletions = minDeletions + bCount.get(c);
        }
        
        aCount.keySet().retainAll(bCount.keySet());
        for(Character c : aCount.keySet()) {
        	minDeletions = minDeletions + Math.abs(aCount.get(c) - bCount.get(c));
        }
        
        return minDeletions;
    }
}
