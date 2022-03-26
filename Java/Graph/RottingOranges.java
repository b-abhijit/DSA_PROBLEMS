/* In a grid of oranges, each cell represents 3 values => 0 - an empty cell, 1 - a fresh orange, 2 - a rotten orange
* Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
* Print the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, print -1 instead.
* */

package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1, 0, 0},
            {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1},
            {0, 1, 1, 2, 0}
        };

        int numberOfOnes = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 2)
                    queue.offer(new Pair(i, j));
                if (grid[i][j] == 1)
                    numberOfOnes += 1;
            }
        }

        int numberOfMinutes = calculateTime(grid, queue, numberOfOnes);

        System.out.println(numberOfMinutes);
    }

    static int calculateTime(int[][] grid, Queue<Pair> queue, int numberOfOnes) {
        int numberOfMinutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                Pair pair = queue.poll();
                int row = pair.row;
                int col = pair.col;

                if (-1 < row + 1 && -1 < col && row + 1 < grid.length && col < grid[0].length && grid[row + 1][col] == 1) {
                    queue.offer(new Pair(row + 1, col));
                    numberOfOnes -= 1;
                    grid[row + 1][col] = 2;
                }
                if (-1 < row - 1 && -1 < col && row - 1 < grid.length && col < grid[0].length && grid[row - 1][col] == 1) {
                    queue.offer(new Pair(row - 1, col));
                    numberOfOnes -= 1;
                    grid[row - 1][col] = 2;
                }
                if (-1 < row && -1 < col + 1 && row < grid.length && col + 1 < grid[0].length && grid[row][col + 1] == 1) {
                    queue.offer(new Pair(row, col + 1));
                    numberOfOnes -= 1;
                    grid[row][col + 1] = 2;
                }
                if (-1 < row && -1 < col - 1 && row < grid.length && col - 1 < grid[0].length && grid[row][col - 1] == 1) {
                    queue.offer(new Pair(row, col - 1));
                    numberOfOnes -= 1;
                    grid[row][col - 1] = 2;
                }
            }

            if (!queue.isEmpty()) numberOfMinutes += 1;
        }

        if (numberOfOnes != 0)
            return -1;

        return numberOfMinutes;
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
