// Given a sorted array, return the index of the target in the array
// If target is not found in the array, return the index where it can be inserted in the array

package BinarySearch;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        int target = 2;

        System.out.println(target + " is found/ to be inserted at index: " + getInsertPosition(nums, target));
    }

    static int getInsertPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;

        while (start < end) {
            mid = start + (end- start) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        if (nums[start] < target)
            mid = start + 1;
        else
            mid = start;

        return mid;
    }
}
