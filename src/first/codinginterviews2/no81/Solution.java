package first.codinginterviews2.no81;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 081. 允许重复选择元素的组合
 * link: https://leetcode-cn.com/problems/Ygoe9J/
 *
 * @author JellyfishMIX
 * @date 2021/9/16 13:51
 */
public class Solution {
    private List<Integer> combination = new ArrayList<>();
    private int[] candidates;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        backtrack(0, target);
        return result;
    }

    private void backtrack(int begin, int target) {
        // base case
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            // 做选择
            combination.add(candidates[i]);
            // 回溯
            backtrack(i, target - candidates[i]);
            // 撤销选择
            combination.remove(combination.size() - 1);
        }
    }
}
