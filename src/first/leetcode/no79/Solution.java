package first.leetcode.no79;

/**
 * 79. 单词搜索
 * link: https://leetcode-cn.com/problems/word-search/
 * 题解：https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 *
 * @author JellyfishMIX
 * @date 2021/9/22 10:35
 */
public class Solution {
    private char[][] board;
    private int[][] ALL_AROUND = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private String targetWord;
    /**
     * 已访问标记
     */
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int rowLength = board.length;
        int columnLength = board[0].length;
        // 初始化
        this.board = board;
        this.targetWord = word;
        this.visited = new boolean[rowLength][columnLength];
        // 从 (0, 0) 开始 dfs 遍历
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                // 每次遍历 dfs 重置 visited
                this.visited = new boolean[rowLength][columnLength];
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        // dfs 遍历结束，未找到匹配的单词
        return false;
    }

    private boolean dfs(int row, int column, int begin) {
        if (!inArea(row, column)) {
            return false;
        }
        // 已经访问过，返回 false 即可
        if (visited[row][column]) {
            return false;
        }
        // 当前位置字符是否匹配
        if (board[row][column] != targetWord.charAt(begin)) {
            return false;
        }
        // 存储已访问状态
        visited[row][column] = true;
        // 达到 targetWord 匹配终点，全部匹配，返回 true
        if (begin == targetWord.length() - 1) {
            return true;
        }

        // 上下左右 dfs
        for (int[] direction : ALL_AROUND) {
            if (dfs(row + direction[0], column + direction[1], begin + 1)) {
                return true;
            }
        }
        // 撤销已访问状态
        visited[row][column] = false;
        // 上下左右 dfs 完毕，未找到匹配的字符，返回 false
        return false;
    }

    private boolean inArea(int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }
}
