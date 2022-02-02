import java.util.ArrayList;

public class AgileEngineHardExcercise {
	
	private int[] nums;
	private ArrayList<String> solutions;
	private char[] alphabet = new char[] {'R','G','B'};
	
    public String solution(int[] nums) {
    	this.nums = nums;
    	solutions = new ArrayList<String>();
        
        possibleStrings(new StringBuilder());
        if(solutions.isEmpty())
        	return "impossible";
        return solutions.get(0);
    }
    
    public void possibleStrings(StringBuilder currentWord) {
        // If the current string has reached it's maximum length
        if(currentWord.length() == this.nums.length) {
        	if(areSumEquals(currentWord.toString())) {
				System.out.println("HEMOS ENCONTRADO UN GANADOR!: " + currentWord);
				solutions.add(currentWord.toString());
			} else {
				System.out.println(currentWord);
			}

        // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for(char c : alphabet) {
                currentWord.append(c);
                possibleStrings(currentWord);
                currentWord.deleteCharAt(currentWord.toString().length()-1);
            }
        }
    }
    
    public boolean areSumEquals(String word) {
		ArrayList<Integer> erres = new ArrayList<Integer>();
		ArrayList<Integer> ges = new ArrayList<Integer>();
		ArrayList<Integer> bes = new ArrayList<Integer>();
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == 'R')
				erres.add(this.nums[i]);
			else if(word.charAt(i) == 'G')
				ges.add(this.nums[i]);
			else if(word.charAt(i) == 'B')
				bes.add(this.nums[i]);
		}
				
		int sumErre = 0;
		for(int j = 0; j < erres.size(); j++) {
			sumErre += erres.get(j);
		}
		int sumGes = 0;
		for(int a = 0; a < ges.size(); a++) {
			sumGes += ges.get(a);
		}
		int sumBes = 0;
		for(int b = 0; b < bes.size(); b++) {
			sumBes += bes.get(b);
		}
		
		if(sumErre == 0 && sumGes == 0 && sumBes == 0)
			return false;
		return (sumErre == sumGes && sumGes == sumBes);
    }
}