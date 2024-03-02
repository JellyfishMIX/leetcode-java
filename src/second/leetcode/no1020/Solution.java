package second.leetcode.no1020;

/**
 * @author shijie.qian
 * @date 2024/3/2 13:21
 */
public class Solution {
    public int numEnclaves(int[][] grid) {
        // 不考虑 null 入参
        // 淹没上方和下方边缘陆地
        for (int j = 0; j < grid[0].length; j++) {
            backtrack(grid, 0, j);
            backtrack(grid, grid.length - 1, j);
        }
        // 淹没左侧和右侧边缘陆地
        for (int i = 0; i < grid.length; i++) {
            backtrack(grid, i, 0);
            backtrack(grid, i, grid[0].length - 1);
        }

        int totalSize = 0;
        // 数内部陆地数量
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalSize++;
                    // backtrack(grid, i, j);
                }
            }
        }
        return totalSize;
    }

    private void backtrack(int[][] grid, int row, int column) {
        // base case
        if (areBoundary(grid, row, column)) {
            return;
        }
        if (grid[row][column] == 0) {
            return;
        }

        // flood fill
        grid[row][column] = 0;
        // up
        backtrack(grid, row - 1, column);
        // right
        backtrack(grid, row, column + 1);
        // down
        backtrack(grid, row + 1, column);
        // left
        backtrack(grid, row, column - 1);
    }

    private boolean areBoundary(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }
}
