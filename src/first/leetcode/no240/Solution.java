package first.leetcode.no240;

/**
 * 240. 搜索二维矩阵 II
 * link: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 * 题解：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/sou-suo-er-wei-ju-zhen-ii-cong-you-shang-e0vj/
 *
 * @author JellyfishMIX
 * @date 2021/9/11 08:24
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从矩阵右上角开始，向下走 (row 增大) 值增大，向右走 (column 减小) 值减小
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            } else if (target < matrix[row][column]) {
                column--;
            } else if (target > matrix[row][column]) {
                row++;
            }
        }
        return false;
    }
}
