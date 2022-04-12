import java.util.*;
public class Quick{
    /**
     * * Modify the dataay such that:
     * 1. A random index from start to end inclusive is chosen, the
     * corresponding element is designated the pivot element.
     * 2. all elements in range that are smaller than the pivot element
     * are placed before the pivot element.
     * 3. all elements in range that are larger than the pivot element are
     * placed after the pivot element.
     * 4. Only the indices from start to end inclusive are considered in range
     * @param data
     * @param start
     * @param end
     * @return the index of the final position of the pivot element.
     */

    public static int partition(int data[], int start, int end) {
        int pivot = ((int) (Math.random() * (end - start))) + start;
        swap(data, pivot, end);
        pivot = data[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (data[j] < pivot) {
                i++;
                swap(data, i, j);
            }
        }
        swap(data, i + 1, end);
        return i + 1;
    }

    public static int partition_c(int[] data, int start, int end) {
        int pivot = ((int) (Math.random() * (end - start))) + start;
        swap(data, pivot, start);
        pivot = data[pivot]; 
        return -1;
    }

    private static void swap(int[] data, int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB] ;
        data[indexB] = temp;
    }

    private static void test(int[] data, int start, int end) {
      System.out.println("Original: "+ Arrays.toString(data));
      int pivot = partition(data, 0, 4);
      System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
      System.out.println("Modified: "+ Arrays.toString(data));
      System.out.println();
    }

   /**
    *return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array may be modified.
    */

    //Wrapper Method
   public static int quickselect(int []data, int k){
        return quickselect(data, 0, data.length - 1, k); 
   }

   //Actual Method - recursively; 
   private static int quickselect(int[] data, int start, int end, int k) {
        int partition = partition(data, start, end); 
        if (partition == k) return partition; 
        if (partition < k) {
            return quickselect(data, start, partition - 1, k); 
        }
        else {
            return quickselect(data, partition + 1, end, k);
        }
   }

   //Wrapper method; 
   public static void quicksort(int[] data) {
       quicksort(data, 0, data.length - 1);
   }

   public static void quicksort(int[] data, int lo, int hi) {
       //Valid indexes and not equal so arrays of length 0 don't get made over and over
       if (lo < hi) {
            int partition = partition(data, lo, hi); 
            //left side of the array
            quicksort(data, lo, partition - 1);
            //ignore the middle hence -1, since it is in the coorect spot
            //right side
            quicksort(data, partition + 1, hi);
       }
   }

   public static int[] partitionDutch(int[] arr, int low, int high) {
       return new int[0]; 
   }

   private static int[] randArray(int size) {
        int[] arr = new int[size]; 
        Random rand = new Random(); 
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt();
        }
        return arr; 
   }

   public static void main(String[] args) {
      for(int i = 0; i < 100; i++) {
          int[] sortA = randArray(10); 
          int[] sortB = sortA.clone();
          Arrays.sort(sortA);
          quicksort(sortB);
          System.out.println(Arrays.equals(sortA, sortB));
      }
   }

}
