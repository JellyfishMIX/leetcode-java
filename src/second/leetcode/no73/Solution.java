package second.leetcode.no73;

import java.util.Arrays;

/**
 * @author shijie.qian
 * @date 2024/3/30 12:12
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        // 不考虑空入参
        int[][] copyMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                copyMatrix[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < copyMatrix.length; i++) {
            for (int j = 0; j < copyMatrix[i].length; j++) {
                if (copyMatrix[i][j] == 0) {
                    fillZero(matrix, i, j);
                }
            }
        }
    }

    private void fillZero(int[][] matrix, int row, int column) {
        // 遍历 row 填充 0
        Arrays.fill(matrix[row], 0);
        // 遍历 column 填充 0
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}
