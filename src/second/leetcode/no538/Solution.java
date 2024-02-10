package second.leetcode.no538;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/10 11:33
 */
public class Solution {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        // 不考虑空
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // 先递归 bst rightTree
        traverse(root.right);
        sum += root.val;
        root.val = sum;
        // 再递归 bst leftTree
        traverse(root.left);
    }
}
