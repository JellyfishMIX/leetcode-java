package first.no48;

/**
 * 48. 旋转图像
 * link: https://leetcode-cn.com/problems/rotate-image/
 *
 * @author JellyfishMIX
 * @date 2021/8/25 20:10
 */
public class Solution {
    public void rotate(int[][] matrix) {
        // 矩阵边长
        int sideLength = matrix.length;
        // 先根据水平中轴翻转
        for (int i = 0; i < sideLength / 2; i++) {
            for (int j = 0; j < sideLength; j++) {
                swap(matrix, i, j, sideLength - i - 1, j);
            }
        }
        // 根据主对角线翻转
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    /**
     * 把 matrix[a][b] 和 matrix[m][n] 的值交换
     *
     * @param matrix
     * @param a
     * @param b
     * @param m
     * @param n
     */
    private void swap(int[][] matrix, int a, int b, int m, int n) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
