
import java.util.ArrayList;
import java.util.List;

/*
 * Me puedo mover entre caracteres: "." (los "#" son como paredes) y puedo moverme para la derecha,
 * para la izquierda, para arriba y para abajo. Tengo que escribir una funcion que dado un array de 
 * strings (el mapa x el que me tengo que mover) pueda llegar abajo de todo a la derecha en menos
 * pasos que el int que recibo como parametro y devolver "yes" si lo hice antes del int, y "no" si es
 * imposible.
 */

public class HashTagAndDots {
	public static void main(String[] args) {
    	ArrayList<String> grid = new ArrayList<String>();
    	grid.add("...#");
    	grid.add("#..#");
    	grid.add("##..");
    	
    	System.out.println(reachTheEnd(grid, 5));
	}
	
	public static String reachTheEnd(List<String> grid, int maxTime) {
        boolean finished = false;
        int secondsCont = 0;
        String currentGrid = grid.get(0);
        int gridIndex = 0; 
        for(int i = 0; i < currentGrid.length(); i++){
        	if(currentGrid.charAt(i) == '.'){
                secondsCont++;
            } else{
            	gridIndex++;
                currentGrid = grid.get(gridIndex);
            }
        }
        
        if(secondsCont <= maxTime) {
        	return "Yes";
        } else {
        	return "No";
        }
    }
}
