public class RecursionCW {
    public static boolean groupSum(int[] nums, int target) {
        return groupSum(0, nums, target);
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if (target == 0) return true;
        if (start < nums.length && target > 0) {
            return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
        }
        return false;
    }

    public static boolean splitArray(int[] nums) {
        return splitArray(nums, 0, 0, 0);
    }

    public static boolean splitArray(int[] nums, int start, int sumA, int sumB) {
        if (start == nums.length) return sumA == sumB;
        return splitArray(nums, start + 1, sumA + nums[start], sumB ) || splitArray(nums, start + 1, sumA , sumB + nums[start]);
    }

    public static void main(String[] args) {
        System.out.println("\ngroupSum Testing");
        int[] testA = {2,4,8};
        System.out.println(groupSum(testA, 10)); //true
        System.out.println(groupSum(testA, 14)); //true
        System.out.println(groupSum(testA, 9)); //false
        int[] testB = {2,3,7,10};
        System.out.println(groupSum(testB, 9)); //true

        System.out.println("\nSplitArray Testing");
        System.out.println(splitArray(new int[] {2, 2})); //true
        System.out.println(splitArray(new int[] {2, 3})); //false
        System.out.println(splitArray(new int[] {5, 2, 3})); //true
        System.out.println(splitArray(new int[] {10, 2, 3, 1})); //false
    }

    //groupSum6(0, [5, 2, 4, 6], 9) → false
    //fails groupSum6(0, [1, 6, 2, 6, 4], 9) → false
    //fails groupSum6(0, [3, 2, 4, 6], 3) → false

    public static boolean groupSum6(int start, int[] nums, int target) {
        if (target == 0) return true;
        if (start < nums.length && target > 0) {
            //6 must be chosen, therefore the if statement
            if (nums[start] == 6) return groupSum6(start + 1, nums, target - nums[start]) ;
            return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
        }
        return false;
    }
}
