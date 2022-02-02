/*
 * La siguiente solucion es ABSOLUTAMENTE eficiente... y HERMOSA...
 * 
 * (Ver consigna mas abajo)
 * 
 * Para resolverlo ES MUY TENTADOR buscar la solucion a la fuerza bruta: iterar comenzando en i = 0 y comparar con el resto de todos los indexes
 * si existe un palindrome. Y, spoiler alert: esta forma, incluso en SU MAXIMA EXPRESION DE EFICIENCIA es MUY INEFICIENTE (en comparación con la
 * que está escrita más abajo). (Y aclaro que a mí no se me ocurrió... tuve que googlearla... y no me arrepiento porque me abrió el cerebro)
 * 
 * Voy a proceder a explicar el algoritmo eficiente y dps voy a analizar ambas complejidades.
 * 
 * Algoritmo eficiente:
 * comenzar de i = 0 en adelante, pero considerar que i es LA MITAD del palíndromo / capicua... e iterar hacia afuera, es decir, hacia la derecha AL
 * MISMO TIEMPO que hacia la izquierda, y comparar ambos valores... si son iguales: es capicua... seguir iterando hasta que no sea más capicua.
 * 
 * Ahora bien... veamos la complejidad de ambas soluciones... comencemos por la MALA (la primera)
 * por cada index i voy a tener que iterar todos sus compañeros mayores a i + 1 (hasta acá: n * n) PEEEEEROOOOO... por cada substring que tomo de cada
 * indice compañero tengo que DARLO VUELTA y comparar si son iguales al substring original... Darlo vuelta toma tiempo n... o sea: O(n * n * n)... N AL
 * CUBO!!!!
 * 
 * La segunda solucion (la buena) consiste en iterar cada indice i, y por cada uno iterar por sus compañeros i (hasta acá: n * n)... y se acabó...
 * NO TENGO LA NECESIDAD DE DAR VUELTA EL SUBSTRING porque ya estoy comparando sus compañeros DIRECTAMENTE!!!!!! complejidad: O(n * n) N CUADRADO
 * ES HERMOOOOOOOOSOOOOOOOOOOOO BEBEEEEEEEEEEEEEEEEE
 * 
 * 
 * Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
 */

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longest = "";
        for(int i = 0; i<s.length(); i++){
            int r = i, l = i;
            //odd (palindrome (capicuas) impares)
            while(l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)){
                longest = (r-l+1) > longest.length() ? s.substring(l,r+1) : longest;
                l--;
                r++;
            }
            //even (capicuas (palindrome) pares)
            r = i+1;
            l = i;
            while(l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)){
                longest = (r-l+1) > longest.length() ? s.substring(l,r+1) : longest;
                l--;
                r++;
            }
        }
        
        return longest;
    }
}