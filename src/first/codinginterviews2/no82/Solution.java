package first.codinginterviews2.no82;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer II 082. 含有重复元素集合的组合
 * link: https://leetcode-cn.com/problems/4sjJUc/
 * 回溯法
 *
 * @author JellyfishMIX
 * @date 2021/9/15 21:58
 */
public class Solution {
    private int[] candidates;
    private int target;
    private List<Integer> combination = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        // 排序，方便在回溯中去重
        Arrays.sort(candidates);
        backtrack(0, target);
        return result;
    }

    private void backtrack(int begin, int target) {
        // base case
        if (target == 0) {
            result.add(new ArrayList<>(combination));
        }

        for (int i = begin; i < candidates.length; i++) {
            // 去重
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 剪枝
            if (candidates[i] > target) {
                return;
            }
            // 做选择
            combination.add(candidates[i]);
            // 回溯
            backtrack(i + 1, target - candidates[i]);
            // 撤销选择
            combination.remove(combination.size() - 1);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> result = combinationSum2(new int[] {2,5,2,1,2}, 5);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
