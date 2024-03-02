package second.leetcode.no1254;

/**
 * @author shijie.qian
 * @date 2024/3/2 02:20
 * @deprecated 解法 no pass
 */
@Deprecated
public class Solution {
    private boolean[][] visited;

    public int closedIsland(int[][] grid) {
        // 不考虑 null 入参
        int totalSize = 0;
        this.visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (backtrack(grid, i, j)) {
                    totalSize++;
                }
            }
        }
        return totalSize;
    }

    private boolean backtrack(int[][] grid, int row, int column) {
        // base case
        if (areBoundary(grid, row, column)) {
            return false;
        }
        if (grid[row][column] == 1) {
            return false;
        }
        if (visited[row][column]) {
            return false;
        }

        visited[row][column] = true;
        // 向上
        if (areBoundary(grid, row - 1, column)) {
            return false;
        } else {
            backtrack(grid, row - 1, column);
        }

        // 向右
        if (areBoundary(grid, row, column + 1)) {
            return false;
        } else {
            backtrack(grid, row, column + 1);
        }

        // 向下
        if (areBoundary(grid, row + 1, column)) {
            return false;
        } else {
            backtrack(grid, row + 1, column);
        }

        // 向左
        if (areBoundary(grid, row, column - 1)) {
            return false;
        } else {
            backtrack(grid, row, column - 1);
        }
        return true;
    }

    private boolean areBoundary(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }
}
