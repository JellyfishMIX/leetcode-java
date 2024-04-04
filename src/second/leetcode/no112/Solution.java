package second.leetcode.no112;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/4/5 02:28
 */
public class Solution {
    private int targetSum = 0;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.targetSum = targetSum;
        return recursion(root, 0);
    }

    private boolean recursion(TreeNode node, int currentTargetSum) {
        // base case
        if (node == null) {
            return false;
        }
        int currentVal = node.val;
        currentTargetSum += currentVal;
        if (node.left == null && node.right == null) {
            return currentTargetSum == targetSum;
        }


        boolean leftBollean = recursion(node.left, currentTargetSum);
        boolean rightBollean = recursion(node.right, currentTargetSum);
        return leftBollean || rightBollean;
    }
}
