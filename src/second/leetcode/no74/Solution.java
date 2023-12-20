package second.leetcode.no74;

/**
 * 题解 https://leetcode.cn/problems/search-a-2d-matrix/solutions/688117/sou-suo-er-wei-ju-zhen-by-leetcode-solut-vxui/
 *
 * @author shijie.qian
 * @date 2023/12/21 01:29
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = new int[][] {{1, 3}};
        int target = 3;
        boolean flag = solution.searchMatrix(matrix, target);
        System.out.println(flag);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchFirstColumn(matrix, target);
        if (row < 0) {
            return false;
        }
        int column = binarySearchRow(matrix, row, target);
        if (column < 0) {
            return false;
        }
        return true;
    }

    /**
     * 搜索第一列，找到第一个 <= target 的元素所在 row
     * @return 第一个 <= target 的元素所在 row
     */
    private int binarySearchFirstColumn(int[][] matrix, int target) {
        // 不考虑空
        int low = 0;
        int height = matrix.length;
        // 找最 height 值
        while (low < height) {
            int middle = low + (height - low) / 2;
            int middleValue = matrix[middle][0];
            if (middleValue <= target) {
                // 缩小 low 边界
                low = middle + 1;
            } else if (middleValue > target) {
                // 缩小 height 边界
                height = middle;
            }
        }
        return low - 1;
    }

    /**
     * 搜索下标为 row 的行，找到 target 所在 column offset
     * @param row row >= 0 && row < matrix.length
     * @return
     */
    private int binarySearchRow(int[][] matrix, int row, int target) {
        // 不考虑空
        int left = 0;
        int right = matrix[row].length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            int middleValue = matrix[row][middle];
            if (middleValue == target) {
                return middle;
            } else if (middleValue < target) {
                // 收缩 left 边界
                left = middle + 1;
            } else if (middleValue > target) {
                // 收缩 right 边界
                right = middle;
            }
        }
        return -1;
    }
}
