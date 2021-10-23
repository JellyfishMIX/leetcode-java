package first.leetcode.no51;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * link: https://leetcode-cn.com/problems/n-queens/
 * 题解：https://mp.weixin.qq.com/s/nMUHqvwzG2LmWA9jMIHwQQ
 *
 * @author JellyfishMIX
 * @date 2021/8/31 08:42
 */
public class Solution {
    private int n;
    private List<List<String>> result;
    private char[][] combination;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.result = new ArrayList<>(n);
        this.combination = new char[n][n];
        initCombination();
        backtrack(0);
        return result;
    }

    private void backtrack(int rowIndex) {
        // 触发结束条件
        if (rowIndex == n) {
            result.add(combinationToEachResult());
            return;
        }

        // 循环列
        for (int j = 0; j < n; j++) {
            // 判断此位置放置 Q 是否有效
            if (!isValid(rowIndex, j)) {
                continue;
            }
            // select
            combination[rowIndex][j] = 'Q';
            backtrack(rowIndex + 1);
            // remove select
            combination[rowIndex][j] = '.';
        }
    }

    private boolean isValid(int rowIndex, int columnIndex) {
        // 查找同一列是否有 Q
        for (int i = rowIndex - 1; i >= 0; i--) {
            if (combination[i][columnIndex] == 'Q') {
                return false;
            }
        }

        // 查找左上角对角线是否有 Q
        for (int i = rowIndex - 1, j = columnIndex - 1; i >= 0 && j >= 0; i--, j--) {
            if (combination[i][j] == 'Q') {
                return false;
            }
        }

        // 查找右上角对角线是否有 Q
        for (int i = rowIndex - 1, j = columnIndex + 1; i >= 0 && j < n; i--, j++) {
            if (combination[i][j] == 'Q') {
                return false;
            }
        }

        // 有效
        return true;
    }

    private void initCombination() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                combination[i][j] = '.';
            }
        }
    }

    private List<String> combinationToEachResult() {
        List<String> eachResult = new ArrayList<>();
        for (char[] chars : combination) {
            eachResult.add(new String(chars));
        }
        return eachResult;
    }

    @Test
    public void test() {
        List<List<String>> result = solveNQueens(8);
        for (List<String> stringList : result) {
            System.out.println("=======================");
            for (String s : stringList) {
                System.out.println(s);
            }
            System.out.println("=======================");
        }
    }
}
