import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * test case 1 passed = {"A       .-", " B       -...", " C       -.-.", " D       -..", " E       .", " F       ..-.", " G       --.", " H       ....", " I       ..", " J       .---", " K       -.-", " L       .-..", " M       --", " N       -.", " O       ---", " P       .--.", " Q       --.-", " R       .-.", " S       ...", " T       -", " U       ..-", " V       ...-", " W       .--", " X       -..-", " Y       -.--", " Z       --..", " 0       ------", " 1       .-----", " 2       ..---", " 3       ...--", " 4       ....-", " 5       .....", " 6       -....", " 7       --...", " 8       ---..", " 9       ----.", " *", " AN", " EARTHQUAKE", " EAT", " GOD", " HATH", " IM", " READY", " TO", " WHAT", " WROTH", " *", " .--.....--   .....--....", " --.----..   .--.-.----..", " .--.....--   .--.", " ..-.-.-....--.-..-.--.-.", " ..--   .-...--..-.--", " ----        ..--", " *"}
 * test case 2 passed = [A       .-, B       -..., C       -.-., D       -.., E       ., F       ..-., G       --., H       ...., I       .., J       .---, K       -.-, L       .-.., M       --, N       -., O       ---, P       .--., Q       --.-, R       .-., S       ..., T       -, U       ..-, V       ...-, W       .--, X       -..-, Y       -.--, Z       --.., 0       ------, 1       .-----, 2       ..---, 3       ...--, 4       ....-, 5       ....., 6       -...., 7       --..., 8       ---.., 9       ----., *, AN, EARTHQUAKE, EAT, GOD, HATH, IM, READY, TO, WHAT, WROTH, *, --.----.., *]
 * test case 3 passed = [A       .-, B       -..., C       -.-., D       -.., E       ., F       ..-., G       --., H       ...., I       .., J       .---, K       -.-, L       .-.., M       --, N       -., O       ---, P       .--., Q       --.-, R       .-., S       ..., T       -, U       ..-, V       ...-, W       .--, X       -..-, Y       -.--, Z       --.., 0       ------, 1       .-----, 2       ..---, 3       ...--, 4       ....-, 5       ....., 6       -...., 7       --..., 8       ---.., 9       ----., *, AN, EARTHQUAKE, EAT, GOD, HATH, IM, READY, TO, WHAT, WROTH, *, .--.-.----.., *]
 * test case 4 passed = [A       .-, B       -..., C       -.-., D       -.., E       ., F       ..-., G       --., H       ...., I       .., J       .---, K       -.-, L       .-.., M       --, N       -., O       ---, P       .--., Q       --.-, R       .-., S       ..., T       -, U       ..-, V       ...-, W       .--, X       -..-, Y       -.--, Z       --.., 0       ------, 1       .-----, 2       ..---, 3       ...--, 4       ....-, 5       ....., 6       -...., 7       --..., 8       ---.., 9       ----., *, AN, EARTHQUAKE, EAT, GOD, HATH, IM, READY, TO, WHAT, WROTH, *, ..--, *]
 * test case 5 passed = [A       .-, B       -..., C       -.-., D       -.., E       ., F       ..-., G       --., H       ...., I       .., J       .---, K       -.-, L       .-.., M       --, N       -., O       ---, P       .--., Q       --.-, R       .-., S       ..., T       -, U       ..-, V       ...-, W       .--, X       -..-, Y       -.--, Z       --.., 0       ------, 1       .-----, 2       ..---, 3       ...--, 4       ....-, 5       ....., 6       -...., 7       --..., 8       ---.., 9       ----., *, AN, EARTHQUAKE, EAT, GOD, HATH, IM, READY, TO, WHAT, WROTH, *, .--.....-- .....--.... --.----.. .--.-.----.. .--.....-- .--. ..-.-.-....-, ..-- ..--          ..--, *]
 * test case 6 passed = [A       .-, B       -..., C       -.-., D       -.., E       ., F       ..-., G       --., H       ...., I       .., J       .---, K       -.-, L       .-.., M       --, N       -., O       ---, P       .--., Q       --.-, R       .-., S       ..., T       -, U       ..-, V       ...-, W       .--, X       -..-, Y       -.--, Z       --.., 0       ------, 1       .-----, 2       ..---, 3       ...--, 4       ....-, 5       ....., 6       -...., 7       --..., 8       ---.., 9       ----.,        *   , AN, EARTHQUAKE, EAT, GOD, HATH, IM, READY, TO, WHAT, WROTH, *, .--.....-- , .....--....,   * ]
 * test case 7 NOT PASSED = {"A .-", " B -...", " C -.-.", " D -..", " E .", " F ..-.", " G --.", " H ....", " I ..", " J .---", " K -.-", " L .-..", " M --", " N -.", " O ---", " P .--.", " Q --.-", " R .-.", " S ...", " T -", " U ..-", " V ...-", " W .--", " X -..-", " Y -.--", " Z --..", " 0 ------", " 1 .-----", " 2 ..---", " 3 ...--", " 4 ....-", " 5 .....", " 6 -....", " 7 --...", " 8 ---..", " 9 ----.", " *", " *", " .--.....-- .....--....", " --.----.. .--.-.----..", " .--.....-- .--.", " ..-.-.-....--.-..-.--.-.", " ..-- .-...--..-.--", " ---- ..--", " *"}
 * test case 8 NOT PASSED = {"A       .-", " B       -...", " C       -.-.", " D       -..", " E       .", " F       ..-.", " G       --.", " H       ....", " I       ..", " J       .---", " K       -.-", " L       .-..", " M       --", " N       -.", " O       ---", " P       .--.", " Q       --.-", " R       .-.", " S       ...", " T       -", " U       ..-", " V       ...-", " W       .--", " X       -..-", " Y       -.--", " Z       --..", " 0       ------", " 1       .-----", " 2       ..---", " 3       ...--", " 4       ....-", " 5       .....", " 6       -....", " 7       --...", " 8       ---..", " 9       ----.", " *", " AN", " EARTHQUAKE", " EAT", " GOD", " HATH", " IM", " READY", " TO", " WHAT", " WROTH", " *", " .-.-.-..-..--...-", " *"}
 */

/*
 * Comments by the candidate, Federico Estape: This code seems fine for all test cases, but for some reason the hackerrank page was marking two test
 * cases as failed. I debugged and I think they are okey... Above you can see the inputs of the two failing test cases (7 and 8).
 * Regarding 7: there are no context words... so for all morse words I'm printing "No matching word found" as they ask in the requirements.
 * Regarding 8: There is no other match for the ONLY morse code other than READY and I'm suffixing "?" because it only matches in the first 3 characters
 * 
 * Then below you can find the code refactored, delegating each part of the algorithm to different methods to keep it easier to maintain and read.
 */
public class MorseCodeSalesForceHackerRank {
    
/*
 * Complete the function below.
 */

    static void doIt(String[] input) {
        HashMap<Character, String> morseTable = new HashMap<Character, String>();
        HashMap<String, ArrayList<String>> contextWords = new HashMap<String, ArrayList<String>>();
        
        //first we populate the morseTable: A => .-, B => -... etc
        int i = 0;
        String line;
		i = populateMorseTable(input, morseTable, i);
        
        //second we populate the contextWords traduced into morseCode: .--.....-- => [WHAT], etc
        i++;
        i = populateContextWords(input, morseTable, contextWords, i);
        
        //Finally we print the traduced morse words...
        i++;
        line = input[i];
        while(line.indexOf("*") == -1){
            String filter1 = line.replace("\n", " ");
            String filter2 = filter1.trim().replaceAll(" +", " ");
            
            String[] morseWords = filter2.split(" ");
            for(String morseWord : morseWords){
                //First the happy cases with or without "!"
                if(contextWords.get(morseWord) != null){
                    if(contextWords.get(morseWord).size() > 1){
                        System.out.println(contextWords.get(morseWord).get(0) + "!");
                    } else{
                        System.out.println(contextWords.get(morseWord).get(0));
                    }
                } else{ //Then the unhappy cases: with suffix "?" or "No matching word found"
                    String traducedWord = getHalfMatchString(contextWords, morseWord);
                    System.out.println(traducedWord);
                }
            }
            
            i++;
            line = input[i];
        }
    }

	private static String getHalfMatchString(HashMap<String, ArrayList<String>> contextWords, String morseWord) {
		String traducedWord = "No matching word found";
		HashMap<Integer, ArrayList<String>> possibleTraducedWords = new HashMap<Integer, ArrayList<String>>();
		int max = 0;
		
		//We need to keep track of all the possible words from the context that matches the prefix of the morse word, and the id will be the longest
		//match...
		for(int i = 1; i <= morseWord.length(); i ++){
		    String possibleKeyMatch = morseWord.substring(0, i);
		    for(String key : contextWords.keySet()){
		        if(i<key.length() && key.substring(0,i).contains(possibleKeyMatch)){
		            if(possibleTraducedWords.get(i) == null){
		                possibleTraducedWords.put(i, new ArrayList<String>());
		            }
		            possibleTraducedWords.get(i).add(key);
		            max = Math.max(max, i);
		        }
		    }
		}
		//we order the possibleTraducedWords to get the one with fewest extra elements
		for(ArrayList<String> list : possibleTraducedWords.values()){
		    list.sort((string1, string2) -> Integer.compare(string1.length(), string2.length()));
		}
		if(max != 0){
		    traducedWord = contextWords.get(possibleTraducedWords.get(max).get(0)).get(0) + "?";
		}//If no matches return "No matching word found"
		return traducedWord;
	}

	private static int populateContextWords(String[] input, HashMap<Character, String> morseTable,
			HashMap<String, ArrayList<String>> contextWords, int i) {
		String line;
		line = input[i];
        line = line.replace(" ", "");
        while(!line.equals("*")){
            StringBuilder sb = new StringBuilder();
            for(Character c : line.toCharArray()){
                sb.append(morseTable.get(c));
            }
            if(contextWords.get(sb.toString()) == null){
                contextWords.put(sb.toString(), new ArrayList<String>());
            }
            contextWords.get(sb.toString()).add(line);
            
            i++;
            line = input[i];
            line = line.replace(" ", "");
        }
        //We order the ArrayLists in contextWords by length in ascending order to get the shortest later
        for(ArrayList<String> list : contextWords.values()){
            list.sort((string1, string2) -> Integer.compare(string1.length(), string2.length()));
        }
		return i;
	}

	private static int populateMorseTable(String[] input, HashMap<Character, String> morseTable, int i) {
		String line = input[i];
        line = line.replace(" ", "");
        while(!line.equals("*")){
            morseTable.put(line.charAt(0), line.substring(1, line.length()));
            i++;
            line = input[i];
            line = line.replace(" ", "");
        }
		return i;
	}
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }
        
        doIt(_input);
        
    }
}

