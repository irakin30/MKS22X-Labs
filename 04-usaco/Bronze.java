import java.io.*;
import java.util.*;

public class Bronze {
    private static int[][] map, instructions;
    private static int E; 

    private static void readFile(String fileName) throws FileNotFoundException{
      try {
        Scanner input = new Scanner(new File(fileName)); 
        int[] temp = toArray(input.nextLine()); 
        map = new int[temp[0]][temp[1]];
        for(int i = 0; i < map.length; i++) {
          map[i] = toArray(input.nextLine()); 
        }
        E = temp[2];
        instructions = new int[temp[3]][3];
        for(int i = 0; i < instructions.length; i++) {
          instructions[i] = toArray(input.nextLine()); 
        }
        input.close(); 
      }
      catch(FileNotFoundException e) {
        throw e; 
      }
    }

    private static int[] toArray(String line) {
      String[] temp = line.split(" "); 
      int[] result = new int[temp.length];
      for(int i = 0; i < temp.length; i++) {
        result[i] = Integer.parseInt(temp[i]); 
      }
      return result; 
    }

    public static long solve(String fileName) {
      try {
        readFile(fileName);
        for(int[] a : instructions) {
          stomp(a[0], a[1], a[2]);
        }
        long sum = 0;
        for(int[] row : map) {
          for(int i = 0; i < row.length; i++) {
            row[i] = E - row[i];
            if (row[i] < 0) row[i] = 0;
            sum += row[i];
          }
        }
        return sum * 72 * 72;
      }
      catch(FileNotFoundException e) {
        return -1; 
      }
    }

    private static void stomp(int R_s, int C_s, int D_s) {
      int max = 0;
      for(int row = R_s - 1; row < R_s + 2; row++) {
        for(int col = C_s - 1; col < C_s + 2; col++) {
            if(map[row][col] > max) max = map[row][col];
        }
      }

      int min = max - D_s;
      for(int row = R_s - 1; row < R_s + 2; row++) {
        for(int col = C_s - 1; col < C_s + 2; col++) {
            if(map[row][col] > min) map[row][col] = min;
        }
      }
    }

    public static void main(String[] args) {
      System.out.println(solve(args[0])); 
    }

}
