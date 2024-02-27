package second.leetcode.no78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/2/26 21:55
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> candidates = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 不考虑空
        backtrack(nums, 0);
        return result;
    }

    /**
     * 无重元素不可复选
     */
    private void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(candidates));
        for (int i = start; i < nums.length; i++) {
            // 选择
            candidates.add(nums[i]);
            // 递归
            backtrack(nums, i + 1);
            // 撤销选择
            candidates.removeLast();
        }
    }
}
