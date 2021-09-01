package first.leetcode.no101;

/**
 * 101. 对称二叉树
 * link: https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 23:57
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        if (leftNode.val != rightNode.val) {
            return false;
        }
        return dfs(leftNode.left, rightNode.right) && dfs(leftNode.right, rightNode.left);
    }
}
