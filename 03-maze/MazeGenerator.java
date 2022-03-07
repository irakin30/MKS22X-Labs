import java.util.ArrayList;
public class MazeGenerator {
     private static int[][] directions = { new int[] { 1, 0 }, new int[] { -1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
     
     /**
      * This was implemented using a weird modified and genuinely worse version of Prim's algorithm.
      * Warning: this will overwrite your maze into a new one once you call generate!
      */

     public static void generate(char[][] maze, int startRow, int startCol) {
        fill(maze); 
        ArrayList<int[]> cells = new ArrayList<int[]>(); 
        cells.add(new int[]{startRow, startCol}); 
        generate(maze, startRow, startCol, cells);
        maze[startRow][startCol] = 'S';  
        placeEnd(maze); 
     }

     private static void generate(char[][] maze, int row, int col, ArrayList<int[]> cells) {
        if(cells.size() == 0) return; 
        cells.remove(cells.size() - 1); 
        if (onBorder(maze, row, col) || countNeighbors(maze, row, col) > 1) {
            if (cells.size() == 0) return; 
        }
        else {
            maze[row][col] = ' '; 
            for(int i = 0; i < 4; i++) {
                int[] dir = directions[i]; 
                if(maze[row  + dir[0]][col + dir[1]] == '#') {
                    cells.add((int)(Math.random() * (cells.size() + 1)), new int[] {row + dir[0], col + dir[1]});
                }
            }
        }
        generate(maze, cells.get(cells.size() - 1)[0], cells.get(cells.size() - 1)[1], cells);
     }

     private static boolean onBorder(char[][] maze, int row, int col) {
         return (row == 0 || col == 0 || row == maze.length - 1 || col == maze[0].length - 1); 
     }

     private static void fill(char[][] maze) {
         for (int row = 0; row < maze.length; row++) {
             for (int col = 0; col < maze[row].length; col++) {
                 maze[row][col] = '#';
             }
         }
     }

     
     private static int countNeighbors(char[][] maze, int row, int col) {
         int neighbors = 0;
         if (maze[row - 1][col] == ' ') {
             neighbors++;
             if (maze[row + 1][col - 1] == ' ') {
                 neighbors++;
             }
             if (maze[row + 1][col + 1] == ' ') {
                 neighbors++;
             }
         }
         if (maze[row][col - 1] == ' ') {
             neighbors++;
             if (maze[row + 1][col + 1] == ' ') {
                 neighbors++;
             }
             if (maze[row - 1][col + 1] == ' ') {
                 neighbors++;
             }
         }
         if (maze[row + 1][col] == ' ') {
             neighbors++;
             if (maze[row - 1][col - 1] == ' ') {
                 neighbors++;
             }
             if (maze[row - 1][col + 1] == ' ') {
                 neighbors++;
             }
         }
         if (maze[row][col + 1] == ' ') {
             neighbors++;
             if (maze[row - 1][col - 1] == ' ') {
                 neighbors++;
             }
             if (maze[row + 1][col - 1] == ' ') {
                 neighbors++;
             }
         }
         return neighbors;
     }
     
     
     private static void placeEnd(char[][] maze) {
         int row, col; 
         do {
            row = (int) (Math.random() *  maze.length);
            col = (int) (Math.random() *  maze[row].length); 
         }
         while (maze[row][col] != ' '); 
         maze[row][col] = 'E';
     }
}
