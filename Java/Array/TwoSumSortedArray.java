// Given a 1-indexed sorted array of numbers, the target is to find 2 numbers such that they sum up to a given target
// and return the indices of the 2 numbers such that 0 < index1 < index2 < nums.length

package Array;

import java.util.Arrays;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;

        int i = 0, j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target)
                break;

            if (nums[i] + nums[j] > target)
                j -= 1;
            else
                i += 1;
        }

        System.out.println(Arrays.toString(new int[] {i, j}));
    }
}
