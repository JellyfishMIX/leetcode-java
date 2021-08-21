package no113;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * link: https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author JellyfishMIX
 * @date 2021/8/21 23:06
 */
public class Solution {
    private List<Integer> pathList = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    private int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int preSum) {
        if (node == null) {
            return;
        }
        preSum += node.val;
        pathList.add(node.val);
        if (preSum == targetSum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(pathList));
        }
        dfs(node.left, preSum);
        dfs(node.right, preSum);
        pathList.remove(pathList.size() - 1);
    }
}
