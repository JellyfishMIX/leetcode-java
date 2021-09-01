package first.leetcode.no46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * link: https://leetcode-cn.com/problems/permutations/
 *
 * @author JellyfishMIX
 * @date 2021/8/19 13:10
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for (int num : nums) {
            output.add(num);
        }

        int length = nums.length;
        backtrack(res, output, 0, length);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> output, int first, int length) {
        if (first == length) {
            res.add(new ArrayList<>(output));
        }
        for (int i = first; i < length; i++) {
            // first 位切换数字
            Collections.swap(output, first, i);
            // 递归地填下一个数
            backtrack(res, output, first + 1, length);
            // 撤销操作
            Collections.swap(output, i, first);
        }
    }
}
