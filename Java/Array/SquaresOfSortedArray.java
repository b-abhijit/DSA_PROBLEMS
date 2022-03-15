// Given a sorted array of integers, return a sorted array of square of each number in the original array

package Array;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int nums[] = {-5, -4, -1, 0, 3, 7, 10};
        int result[] = new int[nums.length];

        squareSortedArray(nums, result);
        System.out.println("Sorted array: " + Arrays.toString(result));
    }

    static void squareSortedArray(int[] nums, int[] result) {
        int i = 0;

        while (i < nums.length && nums[i] < 0)
            i += 1;

        int j = i - 1, k = 0;

        while (j >= 0 && i < nums.length) {
            if (Math.abs(nums[j]) < nums[i]) {
                result[k++] = nums[j] * nums[j];
                j -= 1;
            } else {
                result[k++] = nums[i] * nums[i];
                i += 1;
            }
        }

        while (j >= 0) {
            result[k++] = nums[j] * nums[j];
            j -= 1;
        }

        while (i < nums.length) {
            result[k++] = nums[i] * nums[i];
            i += 1;
        }
    }
}
