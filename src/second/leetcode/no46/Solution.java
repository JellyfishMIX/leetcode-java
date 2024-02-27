package second.leetcode.no46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/2/27 20:26
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> candidates = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return result;
    }

    private void backtrack(int[] nums) {
        // base case
        if (candidates.size() == nums.length) {
            result.add(new ArrayList<>(candidates));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 选择
            candidates.add(nums[i]);
            used[i] = true;
            // 递归
            backtrack(nums);
            // 撤销选择
            candidates.removeLast();
            used[i] = false;
        }
    }
}
