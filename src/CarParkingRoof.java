
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

public class CarParkingRoof {
	public static void main(String[] args) {
    	ArrayList<Long> cars = new ArrayList<Long>();
    	cars.add(6L);
    	cars.add(12L);
    	cars.add(2L);
    	cars.add(7L);
    	System.out.println(carParkingRoof(cars, 3));
	}
	
	public static long carParkingRoof(List<Long> cars, int k) {
		Collections.sort(cars);
		long minLength = -1L;
		int offSet = 0;
		int end = offSet + k - 1;
		while(end < cars.size()) {
			long newLength = (cars.get(end) - cars.get(offSet) + 1);
			if(newLength < minLength || minLength == -1L) {
				minLength = newLength;
			}
			offSet++;
			end++;
		}
		
		return minLength;
	}
	
	public static long carParkingRoofBadSolution(List<Long> cars, int k) {
        Collections.sort(cars);
        
        ArrayList<Long> lengths = new ArrayList<Long>();
        for(int j = 0; j<cars.size(); j++) {
        	
        	ArrayList<Long> sample = new ArrayList<Long>();
    		int i = j;
    		boolean shouldBreak = false;
    		while(i<j+k) {
    			if(i >= cars.size()) {
    				shouldBreak = true;
    				break;
    			}
    			sample.add(cars.get(i));
    			i++;
    		}
    		if(shouldBreak) {
    			break;
    		}
	        
	        getLengthForSample(lengths, sample);
        }
        
        return Collections.min(lengths);
    }
    
    private static void getLengthForSample(ArrayList<Long> lengths, ArrayList<Long> sample) {
		lengths.add(sample.get(sample.size()-1) - sample.get(0) + 1);
	}
}
