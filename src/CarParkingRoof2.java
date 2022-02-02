
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * programar una funcion que tomaba una lista de enteros (cuyo valor de entero indica la posición
 * en un parking lot de un auto) y un entero k que representa la cantidad de autos que quiero 
 * tapar con una lona. La funcion tiene que medir la distancia MINIMA que existe entre k autos y 
 * devolver esa distancia (que vendría a representar la longitud de la lona). Pero la distancia no 
 * era simplemente hacer long mayor - long menor... la distancia era = long mayor - long menor + 1 
 * porque se toma desde el comienzo del metro de la posicion menor hasta el final del metro de la 
 * longitud mayor
 */

public class CarParkingRoof2 {
	public static void main(String[] args) {
    	ArrayList<Long> cars = new ArrayList<Long>();
    	cars.add(34L);
    	cars.add(19L);
    	cars.add(20L);
    	cars.add(25L);
    	cars.add(100L);
    	cars.add(4L);
    	cars.add(1L);
    	System.out.println(carParkingRoof(cars, 3));
	}
	
	public static long carParkingRoof(List<Long> cars, int k) {
		Collections.sort(cars);
		System.out.println(cars);
		int index = 0;
		int endIndex = k-1;
		Long minimumSize = Long.MAX_VALUE;
		while(endIndex < cars.size()) {
			Long currentSize = cars.get(endIndex) - cars.get(index) + 1;
			System.out.println("currentSize: "+currentSize);
			if(currentSize < minimumSize) {
				minimumSize = currentSize;
			}
			System.out.println("minimum size: "+minimumSize);
			index++;
			endIndex++;
		}
		return minimumSize;
	}
}
