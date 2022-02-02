/*
Alice has a binary string. She thinks a binary string is beautiful if and only if it doesn't contain the substring "010".
In one step, Alice can change a 0 to a 1 or vice versa. Count and print the minimum number of steps needed to make Alice see the string as beautiful.

Sample Input 0

STDIN       Function
-----       --------
7           length of string n = 7
0101010     b = '0101010'
Sample Output 0

2  


0101010 => 1101110 //cambiamos solo dos caracteres y el patrón 010 no aparecio mas, en el ejemplo de la pagina cambian otros caracteres:
0101010 => 0111000 //lo cual tambien devuelve 2... vos hacelo como te pinte fedoco... lo importante es que el resultado sea correcto PARA TODOS los casos de prueba

ESTA SOLUCION RESOLVIO EL 100% DE LOS CASOS DE PRUEBA, ASIQUE DE TOQUE, Y LA SACAMOS BASTANTE RAPIDO, LA SUBIO POR MIL... :) HAPPY HAPPY HAPPY

 */
public class BeautifulBinaryString {

    public static int beautifulBinaryString(String b) {
    	int minimum = 0;
    	int i = 0;
    	while(i < b.length()-2) {
    		if(b.substring(i, i+3).equals("010")) {
    			if(i < b.length()-4 && b.substring(i+2, i+5).equals("010")) {
    				minimum++;
    				i = i + 4;
    			} else {
    				minimum++;
    				i = i + 2;
    			}
    		} else {
				i++;
			}
    	}
    	return minimum;
    }
}
