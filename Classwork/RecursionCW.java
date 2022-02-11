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
        return splitOdd10(nums, 0, 0, 0); 
    }
     
    public static boolean splitOdd10(int[] nums, int start, int sumA, int sumB) {
        if (start >= nums.length) return (sumA  % 10 == 0) && (sumB % 2 == 1); 
        return splitOdd10(nums, start + 1, sumA + nums[start], sumB) || splitOdd10(nums, start + 1, sumA, sumB + nums[start]);
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        //base case
		if (start >= nums.length) return target == 0;

		if (nums[start] % 5 == 0) {
            //if it's followed by one, check this.
			if (start < nums.length - 1 && nums[start + 1] == 1) {
                return groupSum5(start + 2, nums, target - nums[start]);
            }
            //standard recursive case otherwise
            else {
                return groupSum5(start + 1, nums, target - nums[start]);
            }
		}

        //standard recursive case
		return groupSum5(start + 1, nums, target - nums[start]) || 
               groupSum5(start + 1, nums, target);
    }  

    public static boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
        return groupNoAdj(start + 2, nums, target - nums[start]) ||
               groupNoAdj(start + 1, nums, target);
    } 

    public static boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0; 
        int sum = nums[start]; 
        int newIndex = start + 1; 
        while (newIndex < nums.length && nums[newIndex] == nums[start]) {
            sum += nums[newIndex++];
        }
        return groupSumClump(newIndex, nums, target - sum) || groupSumClump(newIndex, nums, target);
    }

}
