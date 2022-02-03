public class Recursion {
          /*Print all words that are made of the letters a-e inclusive.
          *@param length : the length of the words that are to be printed
          */
          public static void printAllWords(int length){
            printAllWords(length,"");
          }

          /*Print all words that are made of the letters a-e inclusive.
          *@param length : either how many more letters or the total length depending on implementation
          *@param word   : the partial word so far.
          */
          public static void printAllWords(int length,String word){
            //WRITE THIS METHOD
            if (length == 0) {
                System.out.println(word); 
            }
            else {
                for(char c = 'a'; c < 'z'; c++) {
                    printAllWords(length - 1, word + c); 
                }
            }
          }

          public static void main(String args[]) {
              printAllWords(3); 
          }
        
}