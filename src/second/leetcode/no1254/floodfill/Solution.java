package second.leetcode.no1254.floodfill;

/**
 * @author shijie.qian
 * @date 2024/3/2 11:21
 */
public class Solution {
    public int closedIsland(int[][] grid) {
        // 不考虑入参为 null
        int totalIsland = 0;
        // 固定行移动列，淹没上方和下方边缘的岛屿
        for (int j = 0; j < grid[0].length; j++) {
            backtrack(grid, 0, j);
            backtrack(grid, grid.length - 1, j);
        }
        // 固定列移动行，淹没左方和右方边缘的岛屿
        for (int i = 0; i < grid.length; i++) {
            backtrack(grid, i, 0);
            backtrack(grid, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    totalIsland++;
                    backtrack(grid, i, j);
                }
            }
        }
        return totalIsland;
    }

    private void backtrack(int[][] grid, int row, int column) {
        // base case
        if (areBoundary(grid, row, column)) {
            return;
        }
        if (grid[row][column] == 1) {
            return;
        }

        // flood fill
        grid[row][column] = 1;
        // 上
        backtrack(grid, row - 1, column);
        // 右
        backtrack(grid, row, column + 1);
        // 下
        backtrack(grid, row + 1, column);
        // 左
        backtrack(grid, row, column - 1);
    }

    private boolean areBoundary(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }
}
