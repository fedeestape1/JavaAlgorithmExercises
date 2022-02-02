/*
 * Solucion MUY eficiente
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

class RobotCircles2 {
    public boolean isRobotBounded(String instructions) {
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial position is in the center
        int x = 0, y = 0;
        // facing north
        int idx = 0;
        
        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];   
            }    
        }
        
        // after one cycle:
        // robot returns into initial position
        // or robot doesn't face north
        return (x == 0 && y == 0) || (idx != 0);
    }
}