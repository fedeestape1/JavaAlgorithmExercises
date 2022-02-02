/* 
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 */

class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        int rest = 0;
        while(i1 >= 0 || i2 >= 0){
            int num1Unit = i1 >= 0 ? Character.getNumericValue(num1.charAt(i1)) : 0;
            int num2Unit = i2 >= 0 ? Character.getNumericValue(num2.charAt(i2)) : 0;
            int sum = (num1Unit + num2Unit + rest) % 10;
            rest = (num1Unit + num2Unit + rest) / 10;
            sb.append(sum);
            i1--;
            i2--;
        }
        if(rest > 0){
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}