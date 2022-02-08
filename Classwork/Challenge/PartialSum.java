public class PartialSum {
    public static boolean partialSum(int[] arr, int targetValue) {
        return partialSum(0, arr, targetValue); 
    }

    public static boolean partialSum(int start, int[] arr, int targetValue) {
        if (targetValue == 0) return true; 
        if (start < arr.length && targetValue > 0) {
            return partialSum(start + 1, arr, targetValue - arr[start]) || partialSum(start + 1, arr, targetValue);
        }
        return false; 
    }

    // public static boolean splitArray(int[] arr) {
    //     return splitArray(arr, ); 
    // }

    // public static boolean splitArray(int[] arr, ) {
        
    // }

    public static void main(String[] args) {
        int[] testA = {2,4,8}; 
        System.out.println(partialSum(testA, 10)); 
        System.out.println(partialSum(testA, 14));
        System.out.println(partialSum(testA, 9));
        int[] testB = {2,3,7,10}; 
        System.out.println(partialSum(testB, 9));
    }
}