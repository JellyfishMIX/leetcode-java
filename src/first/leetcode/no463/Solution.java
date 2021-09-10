package first.leetcode.no463;

/**
 * 463. 岛屿的周长
 * link: https://leetcode-cn.com/problems/island-perimeter/
 * 岛屿类问题通用解法
 * 题解：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 * @author JellyfishMIX
 * @date 2021/9/10 09:18
 */
public class Solution {
    private int[][] grid;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 题目保证只有一个岛屿，因此直接返回此岛屿的周长即可
                    return bfs(i, j);
                }
            }
        }
        return 0;
    }

    /**
     * bfs 遍历陆地
     *
     * @param i row
     * @param j column
     * @return perimeter
     */
    private int bfs (int i, int j) {
        // base case
        // 边界对应一条边
        if (!inArea(i, j)) {
            return 1;
        }
        // 海洋对应一条边
        if (grid[i][j] == 0) {
            return 1;
        }
        // 已经遍历过的陆地，和周长无关，返回 0
        if (grid[i][j] == 2) {
            return 0;
        }
        // 标记为已遍历过的陆地
        grid[i][j] = 2;

        // 遍历陆地的上下左右
        return bfs(i - 1, j)
         + bfs(i + 1, j)
         + bfs(i, j - 1)
         + bfs(i, j + 1);
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
