package second.leetcode.no118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/21 23:11
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] params = new int[numRows][numRows];
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    params[i][j] = 1;
                } else {
                    params[i][j] = params[i - 1][j - 1] + params[i - 1][j];
                }
                rowList.add(params[i][j]);
            }
            results.add(rowList);
        }
        return results;
    }
}
