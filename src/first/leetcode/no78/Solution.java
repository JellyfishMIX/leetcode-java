package first.leetcode.no78;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * link: https://leetcode-cn.com/problems/subsets/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 11:42
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backTrack(0);
        return result;
    }

    private void backTrack(int begin) {
        result.add(new ArrayList<>(combination));
        for (int i = begin; i < nums.length; i++) {
            // 本次递归使用的组合元素
            combination.add(nums[i]);
            // 递归调用
            backTrack(i + 1);
            // 撤销操作
            combination.remove(combination.size() - 1);
        }
    }
}
