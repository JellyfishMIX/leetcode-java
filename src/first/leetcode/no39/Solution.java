package first.leetcode.no39;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * link: https://leetcode-cn.com/problems/combination-sum/
 * 回溯算法
 * 题解：https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
 *
 * @author JellyfishMIX
 * @date 2021/9/9 23:03
 */
public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    int target;
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backTrack(0, target);
        return result;
    }

    private void backTrack(int begin, int target) {
        // base case
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        // 从 begin 开始遍历 candidates
        for (int i = begin; i < candidates.length; i++) {
            // 选择
            combination.add(candidates[i]);
            // 回溯
            backTrack(i, target - candidates[i]);
            // 撤销选择
            combination.remove(combination.size() - 1);
        }
    }
}
