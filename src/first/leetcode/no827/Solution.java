package first.leetcode.no827;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 827. 最大人工岛
 * link: https://leetcode-cn.com/problems/making-a-large-island/
 * 岛屿类问题通用解法
 * 题解：https://leetcode-cn.com/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/
 *
 * @author JellyfishMIX
 * @date 2021/9/10 09:48
 */
public class Solution {
    private int[][] grid;
    private List<Integer> islandAreaList = new ArrayList<>();
    /**
     * String coordinate, "i,j"
     * Integer islandIndex
     */
    private Map<String, Integer> coordinateMap = new HashMap<>();

    /**
     * 两次 bfs，第一次遍历陆地，计算出每个岛屿的面积。第二次遍历海洋，计算出填海造地后的最大面积。
     *
     * @param grid grid
     * @return 填海造地后的最大面积
     */
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        int islandIndex = 0;

        // 第一次遍历陆地，计算出每个岛屿的面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    islandAreaList.add(landBfs(i, j, islandIndex));
                    islandIndex++;
                }
            }
        }

        // 第二次遍历海洋，计算出填海造地后的最大面积
        int maxRemakeArea = 0;
        // 标记是否有海洋
        boolean oceanFlag = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    // 存在海洋
                    oceanFlag = true;
                    maxRemakeArea = Math.max(maxRemakeArea, oceanBfs(i, j));
                }
            }
        }
        // 海洋 bfs 结束，如果无海洋，则最大面积为现有岛屿的面积
        if (!oceanFlag) {
            maxRemakeArea = islandAreaList.get(0);
        }
        return maxRemakeArea;
    }

    /**
     * 遍历陆地
     *
     * @param i row
     * @param j column
     * @param islandIndex 岛屿索引
     * @return area
     */
    private int landBfs(int i, int j, int islandIndex) {
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

        // 记录 grid[i][j] 陆地所属岛屿索引
        coordinateMap.put(coordinateGenerate(i, j), islandIndex);
        // 标记已遍历的陆地，防止重复遍历
        grid[i][j] = 2;

        // 遍历陆地的上下左右
        return 1 + landBfs(i - 1, j, islandIndex)
                + landBfs(i + 1, j, islandIndex)
                + landBfs(i, j - 1, islandIndex)
                + landBfs(i, j + 1, islandIndex);
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }

    private int oceanBfs(int i, int j) {
        // 一块海洋上下左右的 islandIndex
        int[] oceanAround = {-1, -1, -1, -1};
        int oceanAroundIndex = 0;
        int remakeArea = 1;
        int row = 0, column = 0;

        // 检查上边
        row = i - 1;
        column = j;
        if (i > 0 && grid[row][column] != 0 && !isDuplicateIsland(row, column, oceanAround, oceanAroundIndex++)) {
            remakeArea += getIslandArea(row, column);
        }
        // 检查下边
        row = i + 1;
        column = j;
        if (i < grid.length - 1 && grid[row][column] != 0  && !isDuplicateIsland(row, column, oceanAround, oceanAroundIndex++)) {
            remakeArea += getIslandArea(row, column);
        }
        // 检查左边
        row = i;
        column = j - 1;
        if (j > 0 && grid[row][column] != 0  && !isDuplicateIsland(row, column, oceanAround, oceanAroundIndex++)) {
            remakeArea += getIslandArea(row, column);
        }
        // 检查右边
        row = i;
        column = j + 1;
        if (j < grid[0].length - 1 && grid[row][column] != 0  && !isDuplicateIsland(row, column, oceanAround, oceanAroundIndex)) {
            remakeArea += getIslandArea(row, column);
        }

        return remakeArea;
    }

    /**
     * 指定的坐标陆地所属岛屿是否已经遍历过
     *
     * @param i
     * @param j
     * @param oceanAround
     * @param oceanAroundIndex 0 上边，1 下边，2 左边，3 右边
     * @return
     */
    private boolean isDuplicateIsland(int i, int j, int[] oceanAround, int oceanAroundIndex) {
        int islandIndex = coordinateMap.get(coordinateGenerate(i, j));
        for (int traversedIndex : oceanAround) {
            if (traversedIndex == islandIndex) {
                return true;
            }
        }
        oceanAround[oceanAroundIndex] = islandIndex;
        return false;
    }

    private String coordinateGenerate(int i, int j) {
        return String.format("%d,%d", i, j);
    }

    private int getIslandArea(int i, int j) {
        return islandAreaList.get(coordinateMap.get(coordinateGenerate(i, j)));
    }
}
