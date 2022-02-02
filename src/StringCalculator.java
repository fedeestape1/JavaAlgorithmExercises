import java.util.*; 
import java.io.*;

class StringCalculator {
	
	public static void main(String[] args) {
		System.out.println(Calculator("2+(3-1)*3"));
	}

  public static String Calculator(String str) {

    List<String> terms = SeparateTerms(str, "+-");
    ResolveSumSub(terms);
    return terms.get(0);
  }

  public static void ResolveSumSub(List<String> terms){
    if(terms.size() > 1){
      while(terms.size() > 1){
        String firstTerm = terms.remove(0);
        String firstNumString = "";
        if("(".equals(""+firstTerm.charAt(0))){
        	if(")".equals(""+firstTerm.charAt(firstTerm.length()-1))) {
        		firstNumString = Calculator(firstTerm.substring(1,firstTerm.length()-1));
        	} else {
        		firstNumString = firstTerm;
        	}
        } else{
          firstNumString = firstTerm;
        }
        Integer firstNum = Integer.parseInt(ResolveMultDiv(firstNumString));

        String operator = terms.remove(0);

        String secondTerm = terms.remove(0);
        String secondNumString = "";
        if("(".equals(""+secondTerm.charAt(0))){
        	if(")".equals(""+secondTerm.charAt(secondTerm.length()-1))) {
        		secondNumString = Calculator(secondTerm.substring(1,secondTerm.length()-1));
        	} else {
        		secondNumString = secondTerm;
        	}
        } else{
          secondNumString = secondTerm;
        }
        Integer secondNum = Integer.parseInt(ResolveMultDiv(secondNumString));

        if("+".equals(operator)){
          terms.add(0, ""+(firstNum + secondNum));
        } else{
          terms.add(0, ""+(firstNum - secondNum));
        }
      }
    } else{
      String term = terms.remove(0);
      String numString = "";
      if("(".equals(""+term.charAt(0))){
	    if(")".equals(""+term.charAt(term.length()-1))) {
    		  numString = Calculator(term.substring(1,term.length()-1));
      	} else {
      		numString = term;
      	}
      } else{
        numString = term;
      }
      terms.add(ResolveMultDiv(numString));
    }
  }

  public static String ResolveMultDiv(String expr){
    List<String> terms = SeparateTerms(expr, "*/");
    ResolveMultDivOperations(terms);
    return terms.get(0);
  }

  public static void ResolveMultDivOperations(List<String> terms){
    while(terms.size() > 1){
      String firstTerm = terms.remove(0);
      String firstNumString = "";
      if("(".equals(""+firstTerm.charAt(0))){
        firstNumString = Calculator(firstTerm);
      } else{
        firstNumString = firstTerm;
      }
      Integer firstNum = Integer.parseInt(firstNumString);
      String operator = terms.remove(0);

      String secondTerm = terms.remove(0);
      String secondNumString = "";
      if("(".equals(""+secondTerm.charAt(0))){
        secondNumString = Calculator(secondTerm.substring(1,secondTerm.length()-1));
      } else{
        secondNumString = secondTerm;
      }
      Integer secondNum = Integer.parseInt(secondNumString);

      if("*".equals(operator)){
        terms.add(0, ""+(firstNum * secondNum));
      } else{
        terms.add(0, ""+(firstNum / secondNum));
      }
    }
  }

  public static List<String> SeparateTerms(String str, String operators){
    int lastFirstIndex = 0;
    List<String> terms = new LinkedList<String>();
    int parenthesisCount = 0;
    for(int i = 0; i<str.length(); i++){
      if("(".equals(""+str.charAt(i))){
        parenthesisCount++;
      } else if(")".equals(""+str.charAt(i))){
        parenthesisCount--;
      }
      if(operators.contains(Character.toString(str.charAt(i))) && parenthesisCount == 0){
        terms.add(str.substring(lastFirstIndex, i));
        terms.add("" + str.charAt(i));
        lastFirstIndex = i+1;
      }
    }

    terms.add(str.substring(lastFirstIndex, str.length()));
    return terms;
  }


}