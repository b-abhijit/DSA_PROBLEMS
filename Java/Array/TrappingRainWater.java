// Given an array of 'n' non-negative integers representing heights of adjacent buildings with width of each building as 1 unit.
// Calculate the total amount of water that would be trapped among the buildings after raining.


package Array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = {4,2,0,3,2,5};
        int[] maxLeft = new int[height.length], maxRight = new int[height.length];

        preProcessing(height, maxLeft, maxRight);

        System.out.println("Total amount of water trapped: " + getTotalAmountOfWater(height, maxLeft, maxRight) + " units");
    }


    static void preProcessing(int[] height, int[] maxLeft, int[] maxRight) {
        int maxNum = 0;

        // Calculate the max number for each index from left side of the given array
        for(int i = 0; i < maxLeft.length; ++i) {
            maxLeft[i] = maxNum;
            if (height[i] > maxNum)
                maxNum = height[i];
        }

        maxNum = 0;
        // Calculate the max number for each index from right side of the given array
        for(int i = maxRight.length - 1; i >= 0; --i) {
            maxRight[i] = maxNum;
            if (height[i] > maxNum)
                maxNum = height[i];
        }
    }

    static int getTotalAmountOfWater(int[] height, int[] maxLeft, int[] maxRight) {
        int totalAmount = 0, width = 1;
        for (int i = 1; i < height.length - 1; ++i) {
            int k = Math.min(maxLeft[i], maxRight[i]);
            if (k > height[i]) {
                totalAmount += (k - height[i]) * width;
            }
        }

        return totalAmount;
    }
}
