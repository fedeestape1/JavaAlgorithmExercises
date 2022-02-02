import java.util.Arrays;
import java.util.HashMap;

/*
 * Solucion mia, muy poco eficiente
 * 
 * Ejercicio de LeetCode llamado: 1041. Robot Bounded In Circle
 * Una funcion recibe un string que puede tener las siguientes letras: "G" se mueve una posición hacia adelante, "R" gira hacia la derecha, "L" gira
 * hacia la izquierda.
 * Comienza mirando al norte.
 * Escribir la funcion para que devuelva true solo si repitiendo los comandos del string se cumple un ciclo, sino devolver true.
 * 
 * Solucion: SIEMPRE devuelve true excepto cuando termina en una posicion distinta del 0,0 y mirando al norte. Para el resto de absolutamente TODOS
 * los casos devuelve true
 * 
 * La siguiente solucion tiene buen diseño pero no tiene buen performance...
 */

public class RobotCircles {
	
	public static void main(String[] args) {
		System.out.println(new RobotCircles().isRobotBounded("GGLLGG"));
	}
   
    enum Direction{
        N,E,S,W
    }
   
    private int[] position = new int[2];
    private Direction direction = Direction.N;
    private HashMap<Direction, Direction> right = new HashMap<Direction, Direction>();
    private HashMap<Direction, Direction> left = new HashMap<Direction, Direction>();
   
    public boolean isRobotBounded(String instructions) {
        HashMap<Direction, MoveCommand> move = new HashMap<Direction, MoveCommand>();
        move.put(Direction.N, position -> {position[1] += 1;});
        move.put(Direction.E, position -> {position[0] += 1;});
        move.put(Direction.S, position -> {position[1] -= 1;});
        move.put(Direction.W, position -> {position[0] -= 1;});
        
        right.put(Direction.N, Direction.E);
        right.put(Direction.E, Direction.S);
        right.put(Direction.S, Direction.W);
        right.put(Direction.W, Direction.N);
        
        left.put(Direction.N, Direction.W);
        left.put(Direction.E, Direction.N);
        left.put(Direction.S, Direction.E);
        left.put(Direction.W, Direction.S);
        
        for(Character c : instructions.toCharArray()){
            if(c.equals('R')){
                turnRight();
            } else if(c.equals('L')){
                turnLeft();
            } else{
               move.get(this.direction).move(this.position);
            }
            System.out.println("position after movement: " + Arrays.toString(this.position));
            System.out.println("direction after movement: " + this.direction);
        }
        
        if((this.position[0] != 0 || this.position[1] != 0) && this.direction.equals(Direction.N)){
            return false;
        }
        return true;
    }
    
    private void turnRight(){
        System.out.println("Turning right. New angle: "+ right.get(this.direction));
        this.direction = right.get(this.direction);
    }
    
    private void turnLeft(){
        System.out.println("Turning left. New angle: "+ left.get(this.direction));
        this.direction = left.get(this.direction);
    }
}

@FunctionalInterface
interface MoveCommand{
    void move(int[] position);
}