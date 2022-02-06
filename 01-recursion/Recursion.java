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

          /*
           * Print all words that are made of the characters in the array of letters.
           * There may not be consecutive equal letters, so:
           * aax is not allowed, but axa is allowed.
           *
           * @param length : the length of the words that are to be printed
           *
           * @param letters: the letters you should be using,
           *
           * @precondition: letters contains at least 2 characters, and has no duplicates.
           */
          public static void printNoDoubleLetterWords(int length, char[] letters) {
              printNoDoubleLetterWords(length, "", letters);
          }

          /*
           * Print all words that are made of the characters in letters. There may not be
           * consecutive equal letters,
           * aax is not allowed, but axa is allowed.
           *
           * @param length : either how many more letters need to be
           *
           * @param word : the partial word so far.
           *
           * @param letters: the letters you should be using
           */
         
           public static void printNoDoubleLetterWords(int length, String word, char[] letters) {
              // WRITE THIS METHOD
              if (length == 0) {
                    System.out.println(word);
              }
              else {
                 for(char c : letters) {
                    if(word.length() == 0 || c != word.charAt(word.length() - 1)) {
                        printNoDoubleLetterWords(length - 1, word + c, letters);
                    }
                 }
              }
          }

         
          /*
          *@param s any string
          *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
          */
          public static String reverse(String s){
              if (s.length() <= 1) {
                return s;
              }
              else{
                return reverse(s.substring(1)) + s.substring(0,1);
              }
          }


          /*
          *@param n any non-negative value you want to take the sqrt of
          *@return the approximate sqrt of n within a tolerance of 0.001%
          */
          public static double sqrt(double n){
            //Hint: This is a wrapper method.
            return sqrt(n, 1);
          }

          public static double sqrt(double n, double guess) {
              if (percentDiff(guess * guess, n) <= 0.0001) {
                return guess; 
              }
              guess = ( n / guess + guess) / 2; 
              return sqrt(n, guess); 
              
          }

          public static double percentDiff(double a, double b) {
            return Math.abs((b - a) / a) * 100;
          }


          /*
          *@param length how long the words must be
          *param word the variable to store the partial solution (should start at "")
          *@return the number of words that have no adjacent matching letters using the letters a-z.
          *Repetition allowed except when letters are adjacent.
          */

          public static long countNoDoubleLetterWords(int length,String word){
            // Hint: not a wrapper method, but you must call it starting with "" as your word.
            // It's a lot easier with combinatorics.
            if (length == 0) return 0; 
            long count = 26; 
            for(int i = 0; i < length - 1; i++) {
              count *= 25; 
            }
            return count; 
          }


         /*
          *@param n any non-negative value
          *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
          */

          public static int fibIter(int n, int f1, int f2){
            // DO NOT call fibIter more than once
            if (n == 0) {
              return 0;
            }
            return f1 + fibIter(n - 1, f2, f1 + f2); 
          }


          //  Testing purposes only
          public static void main(String args[]) {
            /*
             * String[] b = {"abc", "123", "beep", "dog"};
             * for(String a: b) {
             * System.out.println(reverse(a));
             * }
             * // reverse Status: Working
             * 
             * printNoDoubleLetterWords(3, new char[]{'a','b','c'});
             * // printNoDoubleLetterWords()
             *
             * double[] b = {100.0, 81.0, 64.0, 49.0};
             * for (double a : b) {
             * System.out.println(sqrt(a));
             * }
             * // sqrt Status: Working
             * 
             * for(int i = 0; i < 10; i++) {
             * System.out.println(fibIter(i, 1, 0));
             * }
             * //fibIter Status: Working
             */
          }

}
