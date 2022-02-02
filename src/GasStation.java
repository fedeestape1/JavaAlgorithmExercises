
/*
 * Dado un array de strings, la 1er posicion indica la cantidad de nodos, y los siguientes representan los nodos. c/nodo te da el string "a:b". a y b 
 * son enteros. a = cantidad de nafta que te ADICIONAN en la i-ésima estacion. b = cantidad de nafta que te consume ir a la siguiente estación.
 * Escribir una funcion que reciba este array de strings y devuelva el INDEX (un numero entre 1 - N) el cual representa el punto de comienzo del reco-
 * rrido. El recorrido siempre es circular. o sea que si arranco en i = 3 y los nodos son 4, comienzo en 3, sigo en 4 luego en 1 luego en 2 y luego 
 * termino en 3. Pude llegar en funcion de la nafta que iba cargando e iba gastando? si? devolve el index. no? proba con el resto
 * si es imposible, devolver el string "impossible".
 * 
 * El siguiente algoritmo lo resuelve joya para todos los casos, pero me parece que no es tan eficiente... ni idea, o sea no me dejaron ver los tests
 * asique no lo se realmente... solo se que para los tests triviales sí anda.
 */

public class GasStation {

	public static void main(String[] args) {
		String[] wopa = {"4","0:1","2:2","1:2","3:1"};
		System.out.println(GasStation(wopa));
	}
	
	public static String GasStation(String[] strArr) {
		int length = Integer.parseInt(strArr[0]);
		String response = "impossible";
		for (int i = 0; i < length; i++) {
			int currentGas = 0;
			int initialIndex = i + 1;
			for (int j = 0; j < length; j++) {
				int index = (j + i) % length + 1;
				String currentInfo = strArr[index];
				int positiveGas = Integer.parseInt(currentInfo.split(":")[0]);
				int negativeGas = Integer.parseInt(currentInfo.split(":")[1]);
				currentGas = currentGas + (positiveGas - negativeGas);
				System.out.println("currentGas: " + currentGas);
				if (currentGas < 0) {
					break;
				}
			}
			if (currentGas >= 0) {
				response = "" + initialIndex;
				break;
			}
		}
		return response;
	}
}
