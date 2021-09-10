package first.leetcode.no200;

/**
 * 200. 岛屿数量
 * link: https://leetcode-cn.com/problems/number-of-islands/
 * 岛屿类问题通用解法
 * 题解：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 * @author JellyfishMIX
 * @date 2021/9/9 23:36
 */
public class Solution {
    private char[][] grid;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void bfs(int i, int j) {
        // base case
        if (!inArea(i, j)) {
            return;
        }
        // 0 水，1 陆地，2 已遍历陆地
        if (grid[i][j] != '1') {
            return;
        }
        // 标记为 2 已遍历陆地，防止重复遍历
        grid[i][j] = '2';

        // 上下左右四个方向查找
        bfs(i - 1, j);
        bfs(i + 1, j);
        bfs(i, j - 1);
        bfs(i, j + 1);
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
