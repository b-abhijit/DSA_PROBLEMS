// Check if a pair with the given sum exists in an array

package Array;

import java.util.HashSet;

public class TwoSumArray {
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 18;

        System.out.println("Pair exists: " + findTargetSum(nums, target));
    }

    static boolean findTargetSum(int[] nums, int target) {
        HashSet<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            if (numSet.contains(target - num))
                return true;
            else
                numSet.add(num);
        }

        return false;
    }
}
