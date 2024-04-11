package second.leetcode.no1254.second;

/**
 * @author shijie.qian
 * @date 2024/4/12 02:53
 */
public class Solution {
    public int closedIsland(int[][] grid) {
        // 淹没上方和下方单元格
        for (int i = 0; i < grid[0].length; i++) {
            floodfill(grid, 0, i);
            floodfill(grid, grid.length - 1, i);
        }
        // 淹没右侧和左侧单元格
        for (int i = 0; i < grid[0].length; i++) {
            floodfill(grid, i, grid[0].length - 1);
            floodfill(grid, i, 0);
        }

        int validIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    validIsland++;
                    floodfill(grid, i, j);
                }
            }
        }
        return validIsland;
    }

    private void floodfill(int[][] grid, int row, int column) {
        if (areBoundary(grid, row, column)) {
            return;
        }
        if (grid[row][column] == 1) {
            return;
        }

        // 淹没当前单元格
        grid[row][column] = 1;
        // 向上
        floodfill(grid, row - 1, column);
        // 向右
        floodfill(grid, row, column + 1);
        // 向下
        floodfill(grid, row + 1, column);
        // 向左
        floodfill(grid, row, column - 1);
    }

    private boolean areBoundary(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return true;
        }
        return false;
    }
}
