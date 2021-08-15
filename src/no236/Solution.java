package no236;

/**
 * 236. 二叉树的最近公共祖先
 * link: https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/14 11:25
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
