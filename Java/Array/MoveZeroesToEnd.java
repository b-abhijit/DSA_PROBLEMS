// Given an array of integers, move all '0' s towards the end of the array while maintaining relative order of the non-zero elements

package Array;

import java.util.Arrays;

public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12, 0, 8, 7, 9, 0};

        moveZeroes(nums);

        System.out.println("New array: " + Arrays.toString(nums));
    }

    static void moveZeroes(int[] nums) {
        int i = 0, j = -1;

        while (i < nums.length) {
            if (nums[i] != 0) {
                j += 1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i += 1;
        }
    }
}
