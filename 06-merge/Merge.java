import java.util.Arrays;
import java.util.Random;
public class Merge{
        /** merge takes two sorted arrays and returns a new array that combines all
        *elements of both arrays in asorted order.
        *@left a sorted array (this is a precondition)
        *@right a sorted array (this is a precondition)
        *@return a sorted array that contains all elements of left and right
        */
    public static int[] merge(int[] left, int[] right) {
        // return a new array that is the merged version of left and right
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, i = 0;

        // merging process
        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[i++] = left[l++];
            } 
            else {
                merged[i++] = right[r++];
            }
        }
        // copy the remaining elements
        while (l < left.length) {
            merged[i++] = left[l++];
        }
        while (r < right.length) {
            merged[i++] = right[r++];
        }
        return merged;
    }


    /** mergesortH is the actual mergesort method.
    *@data the array to be sorted
    *@return a new array that is the sorted version of data.
    */

    public static int[] mergesortH(int [] data){
        //********************
        //COMPLETE THIS METHOD
        //********************
        //if more than 1 element{
        //left = copy half of data
        //right = copy other half of data
        //sort each half and merge them together
        //}

        if (data.length > 1) {
            int[] left = Arrays.copyOfRange(data, 0, data.length / 2); // copy half of data
            int[] right = Arrays.copyOfRange(data, left.length, data.length); // copy other half of data
            return merge(mergesortH(left), mergesortH(right));
        }
        return data;
    }

    /**mergesort uses the recursive mergesortH method to create a sorted
    *version of the array. It then copies the data back into the original
    *array. (This is for compatibility with prior sort testers)
    *@param data the array to be sorted, this will be modified by the method
    */
    public static void mergesort(int [] data){
        int [] temp  =  mergesortH(data);
        for(int i = 0; i < data.length; i++){
            data[i] = temp[i];
        }
    }

    // testing purposes
    private static int[] randArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] sortA = randArray(10);
            int[] sortB = sortA.clone();
            Arrays.sort(sortA);
            mergesort(sortB);
            if (!Arrays.equals(sortA, sortB)) {
                System.out.println("Test Case Failed");
            }
        }

    }

}