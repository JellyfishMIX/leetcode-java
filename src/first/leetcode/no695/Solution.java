package first.leetcode.no695;

/**
 * 695. 岛屿的最大面积
 * link: https://leetcode-cn.com/problems/max-area-of-island/
 * 岛屿类问题通用解法
 * 题解：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 * @author JellyfishMIX
 * @date 2021/9/10 09:29
 */
public class Solution {
    private int[][] grid;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int i, int j) {
        // base case
        if (!inArea(i, j)) {
            return 0;
        }
        // 已经遍历过的陆地，面积计为 0
        if (grid[i][j] == 2) {
            return 0;
        }
        // 水，面积记为 0
        if (grid[i][j] == 0) {
            return 0;
        }
        // 标记已遍历的陆地，防止重复遍历
        grid[i][j] = 2;

        // 遍历陆地的上下左右
        return 1 + bfs(i - 1, j)
         + bfs(i + 1, j)
         + bfs(i, j - 1)
         + bfs(i, j + 1);
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
