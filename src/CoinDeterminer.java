import java.util.Arrays;

/*
 * Este ejercicio consiste en escribir una funcion que recibe un int y devuelve otro int que indica la cantidad MINIMA de monedas que se necesitan para
 * llegar al int recibido. Las monedas son 1,5,7,9 y 11
 * 
 * El siguiente algoritmo funciona para CUALQUIER input y para CUALQUIER conjunto de monedas.
 * PERO las inicializa en num+1, o sea que si es imposible hallar el numero minimo, te devuelve num+1... para corregir esto basta con validarlo en la 
 * última linea de la funcion y listo (return leastCoinNum[num] > num ? -1 : leastCoinNum[num];
 * Sólo sería imposible si los coins no contienen el 1
 */

public class CoinDeterminer {
	
	public static void main(String[] args) {
		System.out.println(CoinDeterminer(15));
	}
	
	public static int CoinDeterminer(int num) {
		int[] coins = { 1, 5, 7, 9, 11 };
		int[] leastCoinNum = new int[num + 1];
		Arrays.fill(leastCoinNum, num + 1);
		leastCoinNum[0] = 0;
		for (int i = 1; i <= num; i++) {
			for (int coin : coins) {
				if(coin <= i) {
					leastCoinNum[i] = Math.min(leastCoinNum[i], 1 + leastCoinNum[i - coin]);
				}
			}
		}
		System.out.println(Arrays.toString(leastCoinNum));
		return leastCoinNum[num];
	}

}
