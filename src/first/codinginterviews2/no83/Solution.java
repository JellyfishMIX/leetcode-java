package first.codinginterviews2.no83;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 083. 没有重复元素集合的全排列
 * link: https://leetcode-cn.com/problems/VvJkup/
 *
 * @author JellyfishMIX
 * @date 2021/9/16 18:07
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            combination.add(num);
        }
        backtrack(0);
        return result;
    }

    private void backtrack(int begin) {
        // base case
        if (begin == combination.size()) {
            result.add(new ArrayList<>(combination));
            return;
        }

        for (int i = begin; i < combination.size(); i++) {
            // 做选择
            Collections.swap(combination, begin, i);
            // 回溯
            backtrack(begin + 1);
            // 撤销选择
            Collections.swap(combination, i, begin);
        }
    }
}
