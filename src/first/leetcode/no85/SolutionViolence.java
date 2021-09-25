package first.leetcode.no85;

/**
 * 85. 最大矩形
 * link: https://leetcode-cn.com/problems/maximal-rectangle/
 * 题解：https://leetcode-cn.com/problems/maximal-rectangle/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-1-8/
 *
 * @author JellyfishMIX
 * @date 2021/9/25 12:04
 */
public class SolutionViolence {
    public int maximalRectangle(char[][] matrix) {
        // 特殊判断
        if (matrix.length == 0) {
            return 0;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        // 存储以 [row][column] 为结尾的连续 1 的个数（即宽度）
        int[][] width = new int[rowLength][columnLength];
        int maxArea = 0;

        // 遍历每一行每一列
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (matrix[row][column] == '1') {
                    if (column == 0) {
                        width[row][column] = 1;
                    } else {
                        width[row][column] = width[row][column - 1] + 1;
                    }
                }

                // 用于存储接下来 for 循环中的最小宽度
                int minWidth = width[row][column];
                int height = 1;
                // 开始向上遍历行
                for (int upRow = row; upRow >= 0 && width[upRow][column] != 0; upRow--) {
                    height = row - upRow + 1;
                    minWidth = Math.min(minWidth, width[upRow][column]);
                    maxArea = Math.max(maxArea, minWidth * height);
                }
            }
        }

        return maxArea;
    }
}
