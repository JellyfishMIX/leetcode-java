package no112;

/**
 * 112. 路径总和
 * link: https://leetcode-cn.com/problems/path-sum/
 *
 * @author JellyfishMIX
 * @date 2021/8/21 11:27
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum(root, targetSum - root.val) || hasPathSum(root, targetSum - root.val);
    }
}
