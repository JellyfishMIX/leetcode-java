package second.leetcode.no200;

/**
 * @author shijie.qian
 * @date 2024/3/1 01:43
 */
public class Solution {
    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        // 不考虑入参为 null
        int totalIsland = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (backtrack(grid, i, j)) {
                    totalIsland++;
                }
            }
        }
        return totalIsland;
    }

    private boolean backtrack(char[][] grid, int row, int column) {
        // base case
        if (areBoundary(grid, row, column)) {
            return false;
        }
        if (grid[row][column] == 0) {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }

        // 访问标记
        visited[row][column] = true;
        // 递归添加访问标记
        // 向上
        backtrack(grid, row - 1, column);
        // 向右
        backtrack(grid, row, column + 1);
        // 向下
        backtrack(grid, row + 1, column);
        // 向左
        backtrack(grid, row, column - 1);
        return true;
    }

    /**
     * 是否为边界
     * @return true 边界 false 非边界
     */
    private boolean areBoundary(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }
}
