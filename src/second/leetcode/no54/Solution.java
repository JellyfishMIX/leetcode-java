package second.leetcode.no54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/3/30 12:29
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        // 不考虑空入参
        if (matrix.length == 0) {
            return new ArrayList<>();
        }

        int upRow = 0;
        int rightColumn = matrix[0].length - 1;
        int downRow = matrix.length - 1;
        int leftColumn = 0;
        while (true) {
            // left -> right
            for (int i = leftColumn; i <= rightColumn; i++) {
                resultList.add(matrix[upRow][i]);
            }
            if (++upRow > downRow) {
                break;
            }

            // up -> down
            for (int i = upRow; i <= downRow; i++) {
                resultList.add(matrix[i][rightColumn]);
            }
            if (--rightColumn < leftColumn) {
                break;
            }

            // right -> left
            for (int i = rightColumn; i >= leftColumn; i--) {
                resultList.add(matrix[downRow][i]);
            }
            if (--downRow < upRow) {
                break;
            }

            // down -> up
            for (int i = downRow; i >= upRow; i--) {
                resultList.add(matrix[i][leftColumn]);
            }
            if (++leftColumn > rightColumn) {
                break;
            }
        }
        return resultList;
    }
}
