package second.leetcode.no95;

import second.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/2/12 01:53
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return backtrack(1, n);
    }

    /**
     * 寻找 [low, high] 可能的 bst
     */
    private List<TreeNode> backtrack(int low, int high) {
        // base case
        List<TreeNode> results = new LinkedList<>();
        if (low > high) {
            results.add(null);
            return results;
        }
        for (int index = low; index <= high; index++) {
            List<TreeNode> leftResults = backtrack(low, index - 1);
            List<TreeNode> rightResults = backtrack(index + 1, high);
            // postOrder
            // leftResults 和 rightResults 叉乘构建 bst
            for (TreeNode leftResult : leftResults) {
                for (TreeNode rightResult : rightResults) {
                    TreeNode root = new TreeNode(index, leftResult, rightResult);
                    results.add(root);
                }
            }
        }
        return results;
    }
}
