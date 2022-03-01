package Classwork; 
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

    public static boolean splitArray(int[] arr) {
        return splitArray(arr, 0, 0, 0); 
    }

    public static boolean splitArray(int[] arr, int start, int sumA, int sumB) {
        if (start == arr.length) return sumA == sumB; 
        return splitArray(arr, start + 1, sumA + arr[start], sumB ) || splitArray(arr, start + 1, sumA , sumB + arr[start]); 
    }

    public static void main(String[] args) {
        System.out.println("\nPartialSum Testing"); 
        int[] testA = {2,4,8}; 
        System.out.println(partialSum(testA, 10)); //true
        System.out.println(partialSum(testA, 14)); //true
        System.out.println(partialSum(testA, 9)); //false
        int[] testB = {2,3,7,10}; 
        System.out.println(partialSum(testB, 9)); //true

        System.out.println("\nSplitArray Testing");
        System.out.println(splitArray(new int[] {2, 2})); //true
        System.out.println(splitArray(new int[] {2, 3})); //false
        System.out.println(splitArray(new int[] {5, 2, 3})); //true
        System.out.println(splitArray(new int[] {10, 2, 3, 1})); //false
    }
}