package second.leetcode.no77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/2/27 11:44
 */
public class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> candidates = new LinkedList<>();
    private int k = 0;

    public List<List<Integer>> combine(int n, int k) {
        // 不考虑空
        this.k = k;
        backtrack(n, 1);
        return result;
    }

    private void backtrack(int n, int start) {
        // base case
        if (candidates.size() == k) {
            result.add(new ArrayList<>(candidates));
            return;
        }

        for (int i = start; i <= n; i++) {
            // 选择
            candidates.addLast(i);
            // 递归
            backtrack(n, i + 1);
            // 撤销选择
            candidates.removeLast();
        }
    }
}
