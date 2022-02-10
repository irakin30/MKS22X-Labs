public class RecursionCW {
    public static boolean groupSum(int[] nums, int target) {
        return groupSum(0, nums, target);
    }

    public static boolean groupSum(int start, int[] nums, int target) {
        if (target == 0) return true;
        if (start < nums.length && target > 0) {
            return groupSum(start + 1, nums, target - nums[start]) ||
                   groupSum(start + 1, nums, target);
        }
        return false;
    }

    public static boolean splitArray(int[] nums) {
        return splitArray(nums, 0, 0, 0);
    }

    public static boolean splitArray(int[] nums, int start, int sumA, int sumB) {
        if (start == nums.length) return sumA == sumB;
        return splitArray(nums, start + 1, sumA + nums[start], sumB ) ||
               splitArray(nums, start + 1, sumA , sumB + nums[start]);
    }

    public static boolean split53(int[] nums) {
      return split53(nums, 0, 0, 0);
    }

    public static boolean split53(int[] nums, int start, int sumA, int sumB) {
        if (start == nums.length) return sumA == sumB;
        if (nums[start] % 5 == 0) return split53(nums, start + 1, sumA + nums[start], sumB);
        if (nums[start] % 3 == 0) return split53(nums, start + 1, sumA , sumB + nums[start]);
        return split53(nums, start + 1, sumA + nums[start], sumB ) || split53(nums, start + 1, sumA , sumB + nums[start]);
    }

    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        if (nums[start] == 6) return groupSum6(start + 1, nums, target - nums[start]);
        return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
    }

    public static boolean splitOdd10(int[] nums) {

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
}
