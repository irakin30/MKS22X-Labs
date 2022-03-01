package Classwork;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList; 

public class ReadMaze {
  public static char[][] toArray(String fileName) throws FileNotFoundException {
    char[][] result = new char[0][]; 
    try {
      File file = new File(fileName); 
      Scanner input = new Scanner(file);
      ArrayList<char[]> array= new ArrayList<char[]>(); 
      while(input.hasNextLine()) {
        array.add((input.nextLine()).toCharArray()); 
      }
      result = array.toArray(result); 
      input.close(); 
    }
    catch (FileNotFoundException e) {
      throw new FileNotFoundException("File Not Found"); 
    }
    return result; 
  }
}
