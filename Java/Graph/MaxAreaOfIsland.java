// Given a m x n binary matrix, return the maximum area of an island in the grid.
// An island is a group of 1's connected horizontally and vertically and 0 denotes water

package Graph;

public class MaxAreaOfIsland {
    static int currentArea = 0;

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        int maxArea = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    scanGrid(grid, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                    currentArea = 0;
                }
            }
        }

        System.out.println("Maximum area of island: " + maxArea);
    }

    static void scanGrid(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] != 1)
            return;

        grid[row][col] = 2;
        currentArea += 1;

        scanGrid(grid, row + 1, col);
        scanGrid(grid, row - 1, col);
        scanGrid(grid, row, col + 1);
        scanGrid(grid, row, col - 1);
    }
}
