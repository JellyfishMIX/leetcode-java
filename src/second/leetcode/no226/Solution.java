package second.leetcode.no226;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/1/17 21:55
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
