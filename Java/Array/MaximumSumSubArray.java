// In an array, find the contiguous sub array which has the largest sum

package Array;

public class MaximumSumSubArray {
    // Kadane's algorithm
    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};

        int curr_sum = 0, max_sum = Integer.MIN_VALUE, i = 0;

        while (i < nums.length) {
            if (curr_sum < 0)
                curr_sum = 0;

            curr_sum += nums[i];

            if (curr_sum > max_sum)
                max_sum = curr_sum;

            i++;
        }

        System.out.println(max_sum);
    }
}
