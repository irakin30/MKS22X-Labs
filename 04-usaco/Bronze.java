import java.io.*;
import java.util.*;

public class Bronze {
    private static int[][] map, instructions;
    private int E;

    private static void readFile(String fileName) {
      map = new int[R][C];
      instructions = new int[N][3];
    }

    public static long solve(String fileName) {
      readFile(fileName);
      for(int[] a : instructions) {
        stomp(a[0]. a[1], a[2]);
      }

      long sum = 0;
      for(int[] row : map) {
        for(int i = 0; i < row.length; i++) {
          row[i] = E - row[i];
          if (row[i] < 0) row[i] = 0;
          sum += row[i]
        }
      return sum * 72 * 72;
    }

    private static void stomp(R_s. C_s. D_s) {
      int max = 0;
      for(int row = R_s; row < R_s + 2; row++) {
        for(int col = C_s; col < C_s + 2; col++) {
            if(map[row][col] > max) max = map[row][col];
        }
      }

      int min = max - D_s;
      for(int row = R_s; row < R_s + 2; row++) {
        for(int col = C_s; col < C_s + 2; col++) {
            if(map[row][col] > min) map[row][col] = min;
        }
      }
    }

}
