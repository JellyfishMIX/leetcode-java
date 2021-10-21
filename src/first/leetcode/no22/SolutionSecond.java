package first.leetcode.no22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成，二刷
 * linK: https://leetcode-cn.com/problems/generate-parentheses/
 * 题解：https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author JellyfishMIX
 * @date 2021/8/23 02:00
 */
public class SolutionSecond {
    private int pairNum;
    private StringBuilder combination = new StringBuilder();
    private int bracketsNum;
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        this.pairNum = n;
        this.bracketsNum = 2 * n;
        backtrack(0, 0);
        return result;
    }

    private void backtrack(int openNum, int closeNum) {
        // base case
        if (combination.length() == bracketsNum) {
            result.add(new String(combination));
        }

        if (openNum < pairNum) {
            // 选择
            combination.append("(");
            // 回溯
            backtrack(openNum + 1, closeNum);
            // 撤销
            combination.deleteCharAt(combination.length() - 1);
        }
        if (closeNum < openNum) {
            // 选择
            combination.append(")");
            // 回溯
            backtrack(openNum, closeNum + 1);
            // 撤销
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
