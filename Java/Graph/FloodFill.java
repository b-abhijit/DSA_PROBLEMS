// Given a m x n integer grid, starting point in the grid (row index, column index) and a new color
// Fill the gird with new color starting from the given starting point and moving in all 4 directions (up, down, left, right)
// and any other cell matching the color of the starting cell

package Graph;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        setNewColor(image, sr, sc, newColor, image[sr][sc]);

        System.out.println(Arrays.deepToString(image));

    }

    static void setNewColor(int[][] image, int sr, int sc, int newColor, int startColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != startColor)
            return;

        image[sr][sc] = newColor;

        setNewColor(image, sr + 1, sc, newColor, startColor);
        setNewColor(image, sr - 1, sc, newColor, startColor);
        setNewColor(image, sr, sc + 1, newColor, startColor);
        setNewColor(image, sr, sc - 1, newColor, startColor);
    }
}
