// Rotate a given array towards right by 'k' steps


package Array;

import java.util.Arrays;

public class RotateArrayTowardsRight {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateArray(nums, k);
        System.out.println("Array after rotation: " + Arrays.toString(nums));
    }

    static void rotateArray(int[] nums, int k) {
        int i = 0, j = nums.length - 1, temp = 0;

        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }

        i = 0; j = k % nums.length - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }

        i = k % nums.length; j = nums.length - 1;
        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 1;
            j -= 1;
        }
    }
}
