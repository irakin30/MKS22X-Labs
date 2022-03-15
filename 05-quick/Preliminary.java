public class Preliminary{
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

    private static void swap(int[] data, int indexA, int indexB) {
        int temp = data[indexA]; 
        data[indexA] = data[indexB] ;
        data[indexB] = temp; 
    }

    private static void printArray(int[] data) {
        System.out.print("[ "); 
        for(int e : data) {
            System.out.print(e + " "); 
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        for(int[] data : new int[][] { {1, 2, 3, 4, 5}, {213, 23, 3, 112, 3, 5}, {5, 4, 3, 2, 1}, {33, 123, 421, -12, -1234, -2, 234} }) {
            System.out.println(partition(data, 0, data.length - 1)); 
            printArray(data);
        }
    }
}
