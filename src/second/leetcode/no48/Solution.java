package second.leetcode.no48;

/**
 * @author shijie.qian
 * @date 2024/4/6 19:47
 */
public class Solution {
    public void rotate(int[][] matrix) {
        // 题干中矩阵是正方形，此为边长
        int sideLength = matrix.length;
        int halfSide = sideLength / 2;
        // 沿横向中轴翻转
        for (int i = 0; i < halfSide; i++) {
            for (int j = 0; j < sideLength; j++) {
                swap(matrix, i, j, sideLength - 1 - i, j);
            }
        }
        // 沿左上至右下对角线翻转
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private void swap(int[][] martrix, int a, int b, int m, int n) {
        int temp = martrix[a][b];
        martrix[a][b] = martrix[m][n];
        martrix[m][n] = temp;
    }
}
