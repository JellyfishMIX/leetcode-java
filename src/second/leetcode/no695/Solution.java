package second.leetcode.no695;

/**
 * @author shijie.qian
 * @date 2024/3/7 20:11
 */
public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int currentArea = dfs(grid, i, j);
                    maxArea = Math.max(currentArea, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int column) {
        // base case
        if (areBoundary(grid, row, column)) {
            return 0;
        }
        if (areWater(grid, row, column)) {
            return 0;
        }
        grid[row][column] = 0;
        int currentArea = 1;

        // up
        currentArea += dfs(grid, row - 1, column);
        // right
        currentArea += dfs(grid, row, column + 1);
        // down
        currentArea += dfs(grid, row + 1, column);
        // left
        currentArea += dfs(grid, row, column - 1);
        return currentArea;
    }

    private boolean areBoundary(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }

    private boolean areWater(int[][] grid, int row, int column) {
        return grid[row][column] == 0;
    }
}
