// Find total number of ways to get target sum from a given collection of denominations

package DynamicProgramming;

import java.util.HashMap;

public class CoinTargetSum {
    public static void main(String[] args) {
        int coins[] = {1, 5, 10, 25};
        int target = 5;

//        System.out.println("Total number of ways: " + getCount(coins, 0, target));
//        System.out.println("Total number of ways: " + getCount(coins, 0, target, new HashMap<>()));
        System.out.println("Total number of ways: " + getCount(coins, target));
    }

    // Recursive Approach
    private static int getCount(int[] coins, int idx, int target) {
        if (idx == coins.length || target < 0)
            return 0;

        if (target == 0)
            return 1;

        int notPickCount = getCount(coins, idx + 1, target);
        int pickCount = 0;
        if (coins[idx] <= target)
            pickCount = getCount(coins, idx, target - coins[idx]);

        return notPickCount + pickCount;
    }

    // Memorization Approach
    private static int getCount(int[] coins, int idx, int target, HashMap<String, Integer> cache) {
        if (idx == coins.length || target < 0)
            return 0;

        if (target == 0)
            return 1;

        if(cache.containsKey(idx + "-" + target))
            return cache.get(idx + "-" + target);

        int notPickCount = getCount(coins, idx + 1, target, cache);
        int pickCount = 0;
        if (coins[idx] <= target)
            pickCount = getCount(coins, idx, target - coins[idx], cache);

        cache.put(idx + "-" + target, notPickCount + pickCount);

        return notPickCount + pickCount;
    }

    // Dynamic Programming Approach
    private static int getCount(int[] coins, int target) {
        int[][] grid = new int[coins.length + 1][target + 1];

        for (int i = 1; i <= target; ++i)
            grid[0][i] = 0;

        for (int i = 0; i <= coins.length; ++i) {
            grid[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; ++i) {
            for (int j = 0; j <= target; ++j) {
                if (coins[i - 1] > j)
                    grid[i][j] = grid[i - 1][j];
                else
                    grid[i][j] = grid[i - 1][j] + grid[i][j - coins[i - 1]];
            }
        }

        return grid[coins.length][target];
    }
}
