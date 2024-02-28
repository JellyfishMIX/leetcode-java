package second.leetcode.no39;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/2/28 17:04
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> tracks = new LinkedList<>();
    private int sumValue = 0;
    private int target = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.target = target;
        backtrack(candidates, 0);
        return result;
    }

    private void backtrack(int[] candidates, int start) {
        // base case
        if (sumValue == target) {
            result.add(new ArrayList<>(tracks));
            return;
        }
        if (sumValue > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int currentValue = candidates[i];
            // 选择
            tracks.add(currentValue);
            sumValue += currentValue;
            // 递归
            backtrack(candidates, i);
            // 撤销选择
            tracks.removeLast();
            sumValue -= currentValue;
        }
    }
}
