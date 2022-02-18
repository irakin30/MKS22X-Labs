import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class ReadMaze {
  
  public static char[][] toArray(String fileName) {
    char[][] array = new char[fileLength(fileName)][]; 
    try {
      File file = new File(fileName); 
      Scanner input = new Scanner(file);
      for(int i = 0; i < array.length; i++) {
        array[i] = input.nextLine().toCharArray(); 
      }
      input.close(); 
    }
    catch (FileNotFoundException e) {
      throw new Exception("File Not Found"); 
    }
    return array;
  }

  public static int fileLength(String fileName) {
    int length = 0; 
    try {
      File file = new File(fileName); 
      Scanner input = new Scanner(file); 
      while(input.hasNextLine()) {
        length++; 
      }
      input.close(); 
    }
    catch (FileNotFoundException e) {
      throw new FileNotFoundException("File Not Found"); 
    }
    return length; 
  }

}
