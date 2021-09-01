package first.leetcode.no22;

import java.util.LinkedList;
import java.util.List;

/**
 * 22. 括号生成
 * linK: https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author JellyfishMIX
 * @date 2021/8/23 02:00
 */
public class Solution {
    private List<String> result = new LinkedList<>();
    private StringBuilder combination = new StringBuilder();
    /**
     * 问题括号对数
     */
    private int pairNum;
    /**
     * 括号最大个数
     */
    private int bracketMaxNum;

    public List<String> generateParenthesis(int n) {
        this.pairNum = n;
        this.bracketMaxNum = 2 * n;
        backTrack(0, 0);
        return result;
    }

    /**
     * 回溯
     *
     * @param open 当前有几个左括号
     * @param close 当前有几个右括号
     */
    private void backTrack(int open, int close) {
        if (combination.length() == bracketMaxNum) {
            result.add(combination.toString());
            return;
        }
        if (open < pairNum) {
            combination.append("(");
            backTrack(open + 1, close);
            combination.deleteCharAt(combination.length() - 1);
        }
        if (close < open) {
            combination.append(")");
            backTrack(open, close + 1);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
