import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/*
 * EL CODIGO DE ESTE .JAVA ES MAS EFICIENTE QUE EL PSEUDO CODIGO QUE SE DESCRIBE ABAJO. SE USA BFS TAMBIEN PERO SE ITERA DESDE EL COMIENZO Y DESDE EL
 * FINAL, PORQUE YA SE SABE LA COORDENADA FINAL... ENTONCES PODEMOS DARNOS CUENTA EFICIENTEMENTE SI EXISTE REALMENTE UN CAMINO O NO EN LA MITAD DEL
 * TIEMPO QUE USANDO EL PSEUDO CODIGO DE LA DESCRIPCION DE ACA ABAJO
 * 
 * LA DESCRIPCION DE ACA ABAJO ES PARA PONER EN CONTEXTO TODO EL PROBLEMA EN GENERAL
 * 
 * 
 * 
 * 
 * Problema muy famoso llamado "Dungeon Problem" Calabozo. Escapa del calabozo, hallando el camino mas corto a la salida.
 * Ejercicio que me tomaron en Andela. Te dan una lista de strings las cuales indican un mapa. Cada caracter es un "." o un "#". Arrancas arriba a la izq
 * y te aseguran que siempre vas a arrancar en un ".". Tenes que llegar abajo a la derecha de todo (si es que es posible) el cual también siempre va a 
 * ser un ".". el input es la lista de strings y un entero. el entero indica el tiempo limite para llegar del start al end. Si podes llegar en una menor
 * cantidad de pasos que el entero que te pasan devolver "yes" de lo contrario "no".
 * 
 * 
 * SPOILER / BOTTOM LINE FIRST: La solución para esto es: iterar todo el mapa, paso a paso, probando por cada celda TODAS las celdas vecinas, y todos
 * los caminos posibles hasta que UN camino llegue al final (o al elemento de búsqueda) o TODOS los caminos se hayan quedado sin recorrido.
 * Para resolver esto usamos un algoritmo muy famoso de teoría de grafos llamado Breadth First Search (BFS)
 * Es un algoritmo de búsqueda, es decir, dado un elemento e hallar el camino mas corto en un grafo para llegar a dicho elemento.
 * Para esto, comenzamos por un nodo del grafo (starting point). Esta sería nuestra primera capa de iteración. Luego visitamos todos los vecinos de 
 * este grafo (los vecinos serían la segunda capa de iteración). Luego por c/ vecino visitamos todos los vecinos, es decir, si el nodo "a" apunta a
 * los nodos "b", "c" y "d". "a" 1era capa de iteración. "b", "c" y "d" segunda capa de iteracion. Luego, todos los vecinos de "b" todos los de "c" y 
 * todos los de "d" serían la 3er capa de iteración. Esto evidentemente podría llegar a causar un overflow de memoria si la cantidad de vecinos por 
 * nodo es muy grande. Pero sin dudas es la mejor forma (que conozco) de hallar el camino mas corto. (update: no creo que cause un overflow / out of me
 * mory error)
 * 
 * Obviamente por cada capa de iteración (que consiste en iterar todos los nodos de la capa) preguntamos nodo por nodo si es igual al elemento "e".
 * En nuestro caso, de este problema en particular, es hallar el punto de salida: la celda (N,M).
 * 
 * Como no tenemos un grafo, sino que tenemos un mapa / una matriz, podemos SIMULAR que tenemos nodos de la siguiente forma:
 * hallando una matriz de adyacencia, o bien una fila de adyacencia. Cualquiera de las dos nos da la info que necesitamos: por cada celda, ¿cuáles son
 * sus celdas vecinas?.
 * Ejemplo:
 * para el mapa:
 * (1)(2)(3)
 * (4)(5)(6) La fila de adyacencia sería: 1 => [2,4]; 2 => [1,5,3]; 3 => [2,6]; etc. La matríz de adyacencia consiste en tener una matriz N x N en donde
 * N es el tamaño de la matriz (es decir la cantidad total de celdas en la misma). Y el titulo de cada columna y de cada fila será 1,2,3,4,5,6. Luego
 * por cada celda se la completa con un 1 o con un 0 si es vecino o no.
 * 
 * Podríamos hallar esta matriz de adyacencia e iterarla para saber las celdas vecinas de cada celda, o bien podríamos generar un algoritmo que nos
 * permita, en runtime, hallar las celdas vecinas, sin necesidad de leerlas en memoria (1aria o 2daria).
 * Este algoritmo consiste en, a cada celda (x,y), sumarle y restarle 1 unidad en x o y, dejando a la otra constante. Luego chequear que el resultado
 * de esta operación (que nos devuelve una potencial celda vecina) no sea una celda INVÁLIDA. Qué significa celda invalida? una celda que es un
 * obstáculo (en este mismisimo ejemplo un "#") o una celda que está fuera de los límites (< 0, ó > N | M) o una celda que ya fue visitada (porque
 * para qué mierda quiero seguir iterando por un camino que ya recorrí en otro camino).
 * 
 * La solución que encontré en internet explica todo esto de arriba y luego provee un pseudo código para iterar todos los caminos posibles e ir llevando
 * un contador por cada paso de cada camino, hasta encontrar el elemento / la salida. Encontrada? return contador, no? return impossible o lo que sea.
 * 
 * El pseudocódigo es:
 * Queue availableNeighbours;
 * availableNeighbours.add(startingPoint);
 * nextCells = 0;
 * currentCells = 1;
 * stepsCount = 0;
 * markCellAsVisited(startingPoint);
 * while(availableNeighbours.size() > 0){
 *   currentCell = availableNeighbours.pop();
 * 	 if(currentCell == exitPoint){ return stepsCount < maxStepsAllowed; }
 * 	 for(i = 0; i<4; i++){
 * 	   potentialNeighbor = currentCell + potentialNeighbors.get(i); // le sumamos 1 en x dejando constante y Ó viceversa.
 * 	   if(potentialNeighbor is not valid){ //blocked, out of bounds or already visited
 *       continue;
 * 	   }
 *     availableNeightbors.add(potentialNeighbor);
 *     markCellAsVisited(potentialNeighbor);
 *     nextCells++;
 *   }
 *   currentCells--;
 *   if(currentCells == 0){
 *     currentCells = nextCells;
 *     nextCells = 0;
 *     stepsCount++;
     }
 * }
 *
 * return "impossible";
 * 
 */
public class DungeonProblemFindTheShortestPath2 {
	
	public static void main(String[] args) {
		//String[] bidimensionalMap = {"..#","#.#","#.."}; // return should be 4
		//String[] bidimensionalMap = {".##",".##",".#."}; //return should be -1
		//String[] bidimensionalMap = {"...","#.#","..#", ".##", "..."}; //return should be 8
		String[] bidimensionalMap = {"........#....#..#..#....#...#..#.#.#.#.#.#..#.....",
				"..#..#..#.#....#..#.....#......#..##...........##.",
				".........#.###.##...#.....##......###............#",
				"....##........#..#.#.#......#...#.##.......##.....",
				".................###...#.#...#......#.#.#.#.#...#.",
				".........#.....#...........##....#.#.#.##.....##..",
				".....#.##............#....#......#..#..#...##.....",
				".#.......###....#.#..##.##.#...##...#........#...#",
				"..#.##..##..........#..........##.....##..........",
				"#.#..##......#.#.#..##.###...#.........###..#...#.",
				".#..#..............#...#........#..#...#....#..#..",
				"##..#..#........#....#........#...#.#......#.....#",
				"#.#.......#.#..#...###..#..#.##...#.##.......#...#",
				"#.#...#...#.....#....#......##.#.#.........#....#.",
				".#..........#......##..#....#....#.#.#..#..###....",
				"#.#............#.##..#.##.##......###......#..#..#",
				".#..#.##...#.#......................#........#....",
				".....#....#.#..........##.#.#................#....",
				"##............#.#......####...#.........#..##..#..",
				"....#..##..##...#.........##..##....#..#.##...#...",
				".#........#...#..#...........#.###.....##.....##..",
				".......#..#..##...#..###.....#..##.........#......",
				"...#......#..#...........###...............#......",
				"...##.###.#.#....#...#..#.#.#....#....#.##.#...#..",
				"..........#.......#..#..#...###....##.....#..#....",
				".............##.##.#.......#.#....#.......#..#..#.",
				".......#........#.....#....##...#...#.#...#.#.##..",
				".....#..#..#........#..#.....#...#.##.#....#...#..",
				"....................#.#...#....###...###...##...#.",
				"##.#.....##.....#..#.#.#...........#.#.##...#..#.#",
				"#...........#....#.##...#.#.....#...#.....#.#.....",
				"..#..##...#........#.##..#.....##.......#...#.#.#.",
				"......#....#...##...........#..#.......#.##.......",
				"......#..#..#.###..........#...#...........#..#...",
				"....#.#..#..#.#.#...#.......#...#.##......#.......",
				"....#.......#..#........#...#.#...#......#.......#",
				".#....##...#.#..#....#.#.##........#..#.#.........",
				"#....#.......#..##......##...............#..#.##..",
				"...#..##.......#.....#....#...#.#......#..##..###.",
				".....#...#...#...#...#...#..##...#..#.............",
				"....##......#...#..#...#...#.#....#.....#..#.##...",
				"...##.......#..##.....#........#.#....#...#.......",
				"..#...#....#...#.###......#................#......",
				"...#...###...#..##...###.....................#....",
				".....#....#....#...#.#.#.##....##......#....##....",
				"...#.###...##.........#..........#.##.#.....#.....",
				"##..#...#.........#.......#......##...........####",
				"...###.#..........#.....#####........#..#.#.#...#.",
				"...#..#.....#..##.##.#.....##...#...#.#.....#...##",
				".##.......#.##....#............#..................",
				"#.....#.........#.#.........#..###....##...##.....",
				"#....#.....#...#.....#.##...##...####........#....",
				"#...........#..#...#........#.##..##..#...#.#.....",
				"..#.#................#......###..##.#.#...##...#..",
				".#.#....#..#............#....#......#............#",
				"..#..#...#.#.#...#...........#.......##.#...#.#...",
				"#..........#.....#.....#......#.......#.#...##....",
				".......#...........#...........#....#............#",
				"...####.#.....#.##.....#.......##.#..#......#.....",
				".#..#.....#..#......#.............#.#.#..##...#...",
				"..#.#.#.........#...#..#.......#................##",
				".#..##.#.#...#.............#..#..........#..#...#.",
				"....#........#......#...###..#.#..................",
				"#..#..#.....#.#.#...##....##........#........#....",
				".....#.#.......##.......#.....#........#..##..#...",
				"#.#.##........#..##.#..#.#...#........#.#......#..",
				"....#.#.#.......#.##.##...##...#..#.###...#.#.#...",
				".....##.#....#........#....#.#........#.#.#.....#.",
				".....#..##..#.#....#.......#...#.#.###.........#.#",
				"#.....#.##..#.......###.........#..##..#......##.."};
		Stream.of(bidimensionalMap).forEach(System.out::println);
		System.out.println(solveDungeonProblem(bidimensionalMap));
	}

	private static int solveDungeonProblem(String[] bidimensionalMap) {
		LinkedList<Integer[]> startQueue = new LinkedList<Integer[]>();
		LinkedList<Integer[]> endQueue = new LinkedList<Integer[]>();
		HashSet<List<Integer>> startVisited = new HashSet<List<Integer>>();
		HashSet<List<Integer>> endVisited = new HashSet<List<Integer>>();
		
		int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
		
		Integer[] start = {0,0};
		startQueue.add(start);
		Integer[] end = {bidimensionalMap.length-1, bidimensionalMap[0].length()-1};
		endQueue.add(end);
		
		startVisited.add(Arrays.asList(start));
		endVisited.add(Arrays.asList(end));
		
		int stepCount = 0;
		
		int startCurrentLayer = 1;
		int startNeighbours = 0;
		int endCurrentLayer = 1;
		int endNeighbours = 0;
		
		
		while(!startQueue.isEmpty() && !endQueue.isEmpty()) {
			//start trail
			while(true) {
				//System.out.println("start queue: " + startQueue);
				Integer[] current = startQueue.removeFirst();
				if(endVisited.contains(Arrays.asList(current))) {
					return (stepCount * 2) - 1;
				}
				for(int[] direction : directions) {
					int nr = current[0] + direction[0];
					int nc = current[1] + direction[1];
					Integer[] neighbour = {nr, nc};
					if(0 <= nr && nr < bidimensionalMap.length && 0 <= nc && nc < bidimensionalMap[0].length() && !startVisited.contains(Arrays.asList(neighbour)) && bidimensionalMap[nr].charAt(nc) != '#') {
						startVisited.add(Arrays.asList(neighbour));
						startQueue.add(neighbour);
						startNeighbours++;
					}
				}
				startCurrentLayer--;
				if(startCurrentLayer == 0) {
					stepCount++;
					startCurrentLayer = startNeighbours;
					startNeighbours = 0;
					break;
				}
			}
			
			//end trail
			while(true) {
				//System.out.println("end queue: " + endQueue);
				Integer[] current = endQueue.removeFirst();
				if(startVisited.contains(Arrays.asList(current))) {
					return (stepCount * 2);
				}
				for(int[] direction : directions) {
					int nr = current[0] + direction[0];
					int nc = current[1] + direction[1];
					Integer[] neighbour = {nr, nc};
					if(0 <= nr && nr < bidimensionalMap.length && 0 <= nc && nc < bidimensionalMap[0].length() && !endVisited.contains(Arrays.asList(neighbour)) && bidimensionalMap[nr].charAt(nc) != '#') {
						endVisited.add(Arrays.asList(neighbour));
						endQueue.add(neighbour);
						endNeighbours++;
					}
				}
				endCurrentLayer--;
				if(endCurrentLayer == 0) {
					endCurrentLayer = endNeighbours;
					endNeighbours = 0;
					break;
				}
			}
		}
		
		return -1;
	}
}
