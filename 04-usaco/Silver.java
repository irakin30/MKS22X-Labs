import java.io.*;
import java.util.*;

public class Silver {
    private static int[][] current; 
    private static final int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; 
    private static int N, M, T; 
    private static int R1, C1, R2, C2; 
    

    private static void readFile(String fileName) throws FileNotFoundException{
        Scanner input = new Scanner(new File(fileName)); 
        
        //reads first line
        int[] temp = toArray(input.nextLine()); 
        N = temp[0]; 
        M = temp[1]; 
        T = temp[2]; 

        //creates the array and converts it into something usable
        current = new int[N][M]; 
        for(int i = 0; i < N; i++) {
            current[i] = toArray(input.nextLine()); 
        }

        //reads the last line
        temp = toArray(input.nextLine()); 
        R1 = temp[0] - 1;
        C1 = temp[1] - 1;
        R2 = temp[2] - 1;
        C2 = temp[3] - 1; 
        input.close(); 
    }

    private static int[] toArray(String line) {
        if(line.contains(".")) {
            char[] temp = line.toCharArray(); 
            int[] result = new int[temp.length]; 
            for(int i = 0; i < result.length; i++) {
                result[i] = (temp[i] == '.')? 0 : -1; 
            }
            return result; 
        } 
        else {
            String[] temp = line.split(" ");
            int[] result = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                result[i] = Integer.parseInt(temp[i]);
            }
            return result;
        }
    }

    public static long solve(String fileName) {
        try {
          readFile(fileName);
          current[R1][C1] = 1; 
          for (int i = 1; i <= T; i++) {
              iterate(); 
          }
          return current[R2][C2]; 
        }
        catch (FileNotFoundException e) {
            return -1; 
        }
      
    }

    private static void iterate() {
        ArrayList<int[]> alive = new ArrayList<int[]>(); 
        for(int row = 0; row < current.length; row++) {
            for(int col = 0; col < current[row].length; col++) {
                if (current[row][col] > 0) {
                    alive.add(new int[] {row, col}); 
                }
            }
        }
        for(int[] coords : alive) {
            for(int[] dir : directions) {
                int newRow = coords[0] + dir[0]; 
                int newCol = coords[1] + dir[1]; 
                if (isOnBoard(newRow, newCol) && current[newRow][newCol] != -1) {
                    current[newRow][newCol] += current[coords[0]][coords[1]]; 
                }
            }
            current[coords[0]][coords[1]] = 0; 
        }
    }

    /**
     * @param r - row
     * @param c - column
     * @return a boolean on whether or not it is on the board
     */
    private static boolean isOnBoard(int r, int c) {
        return (r >= 0 && r < N) && (c >= 0 && c < M); 
    }

    public static void main(String[] args) {
        System.out.println(solve(args[0]));
        for(int[] row : current) {
            for(int col : row) {
                System.out.print(col + " "); 
            }
            System.out.print("\n"); 
        }
    }
}
