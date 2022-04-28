import java.util.ArrayList;
public class Fall5 {

    public int[] pythTriples(int n) {
        ArrayList<Integer> stuff = new ArrayList<Integer>(); 
        for(int i = 1; i < n; i += 2) {
            for(int j = 1; j < n; j++) {
                if (i * i + j * j == n * n) {
                    stuff.add(i); 
                    stuff.add(j); 
                }
            }
        }
        return (int[]) stuff.toArray();
    } 

    public int[] farming() {
        int[] result = new int[2]; 
        
        return result; 
    }


    
}
