public class Permute {
    // current is the current index, which starts at 0 when you invoke the method in
    // your main
    // the sentence starts at "", the recursion concatenates the words
    // base case should print the sentence
    public static void permute(String[][] lists, String sentence, int current) {
        if (current >= lists.length) System.out.println(sentence + "."); 
        else {
            for (String thing : lists[current]) {
                permute(lists, sentence + " " + thing, current + 1);
            }
        }
    }

    public static void main(String[] args) {
        String[][] wordlists = {
                { "The dog", "The pro skater" },
                { "plays", "empathises with" },
                { "chess", "ball", "the voiceless masses" }
        };
        permute(wordlists, "", 0);
    }
}
