package second.leetcode.no240;

/**
 * @author shijie.qian
 * @date 2024/3/30 11:59
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角开始，往下走值变大，往左走值变小
        boolean containsTarget = false;
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (target == matrix[row][column]) {
                containsTarget = true;
                break;
            } else if (target < matrix[row][column]) {
                column -= 1;
            } else if (target > matrix[row][column]) {
                row += 1;
            }
        }
        return containsTarget;
    }
}
