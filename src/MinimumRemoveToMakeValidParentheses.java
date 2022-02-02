import java.util.Collections;
import java.util.LinkedList;

/*
 * LA SIGUIENTE SOLUCION TIENE MEJOR EFICIENCIA TEMPORAL QUE EL 90% DE LOS DEMAS DESARROLLADORES QUE LO INTENTARON... 
 * Y MAYOR EFICIENCIA ESPACIAL QUE EL 56% DE LOS DEMAS DESARROLLADORES...
 * 
 * asique está MUUUUY bien...
 * 
 * (La consigna está más abajo en inglés)
 * El algoritmo consiste en contar un balance de parentesis abiertos y cerrados el cual se espera que siempre sea positivo o igual a 0
 * Si toca un ')' y el balance es == 0 entonces sumamos el indice del cerrado en una linked list (linked list porque son mas eficientes para agregar y
 * eliminar elementos, lo cual vamos a hacer mucho en este algoritmo)
 * 
 * Por cada '(' que toca, agregamos su indice en OTRA linked list diferente y sumamos el balance +1
 * Por cada ')' que toca, restamos el balance -1 y ELIMINAMOS el último indice de los '(' 
 * 
 * Luego tomamos ambas linked list con indices, las mergeamos en 1, la ordenamos de manera ascendente y comenzamos desde el ultimo al primero
 * o el equivalente: ordenamos de manera descendiente y eliminamos del primer indice al ultimo.
 * 
 * Esto ultimo es SUPER NECESARIO para eliminar chars de un string porque si lo hicieras de manera ascendiente, los siguientes indices te quedarían
 * defasados y es una paja lidiar con ese problema horroroso...
 * Empezando de atras para adelante, eliminar los indices que tenes y te olvidas del defasaje
 * 
 * 
 * Consigna:
 * Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"
 

Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 */

class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int balance = 0;
        LinkedList<Integer> closeIndexes = new LinkedList<Integer>();
        LinkedList<Integer> openIndexes = new LinkedList<Integer>();
        for(int i = 0; i<s.length(); i++){
            char current = s.charAt(i);
            if('(' == current){
                balance++;
                openIndexes.add(i);
            } else if(')' == current){
                if(balance > 0){
                    balance--;
                    openIndexes.removeLast();
                } else{
                    closeIndexes.add(i);
                }
            }
        }
        
        System.out.println(closeIndexes);
        
        StringBuilder sb = new StringBuilder(s);
        if(closeIndexes.size() > 0){
            if(balance > 0){
                closeIndexes.addAll(openIndexes);
                Collections.sort(closeIndexes);
            }
            for(int i = closeIndexes.size()-1; i>=0; i--){
                sb.deleteCharAt(closeIndexes.get(i));
            }
        } else if(balance > 0){
            for(int i = openIndexes.size()-1; i>=0; i--){
                sb.deleteCharAt(openIndexes.get(i));
            }
        }
        
        return sb.toString();
    }
}