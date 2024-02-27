package second.leetcode.no90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/2/27 20:48
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> candidates = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序让相同元素挨在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return result;
    }

    private void backtrack(int[] nums, int start) {
        // base case
        result.add(new ArrayList<>(candidates));

        for (int i = start; i < nums.length; i++) {
            int currentNum = nums[i];
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 选择
            candidates.add(currentNum);
            // 递归
            backtrack(nums, i + 1);
            // 撤销选择
            candidates.removeLast();
        }
    }
}
