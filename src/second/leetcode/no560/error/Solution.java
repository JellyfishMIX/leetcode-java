package second.leetcode.no560.error;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 题解错误，子数组要求连续，中间不能断。目前的解法非连续而是组合，组合不是子数组。
 *
 * @author shijie.qian
 * @date 2024/3/25 23:53
 */
@Deprecated
public class Solution {
    private int k = 0;
    private LinkedList<Integer> candidateList = new LinkedList<>();
    private int targetNum = 0;
    private Set<String> combinationSet = new HashSet<>();

    public int subarraySum(int[] nums, int k) {
        this.k = k;
        Arrays.sort(nums);
        backtrack(nums, 0);
        return targetNum;
    }

    private void backtrack(int[] nums, int start) {
        String combinationStr = buildCombinationStr(candidateList);
        if (sumList(candidateList) == k && !combinationSet.contains(combinationStr)) {
            targetNum++;
            combinationSet.add(combinationStr);
        }
        // base case
        if (candidateList.size() == nums.length || start >= nums.length) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 选择
            candidateList.add(nums[i]);
            // 递归
            backtrack(nums, i + 1);
            // 撤销选择
            candidateList.removeLast();
        }
    }

    private int sumList(List<Integer> list) {
        int result = 0;
        for (Integer integer : list) {
            result += integer;
        }
        return result;
    }

    private String buildCombinationStr(List<Integer> list) {
        StringBuilder str = new StringBuilder();
        for (Integer integer : list) {
            str.append(integer);
        }
        return str.toString();
    }
}
