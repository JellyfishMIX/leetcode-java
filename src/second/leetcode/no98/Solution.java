package second.leetcode.no98;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/11 01:44
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // 不考虑空
        return traverse(root, null, null);
    }

    private boolean traverse(TreeNode root, TreeNode minNode, TreeNode maxNode) {
        // base case
        if (root == null) {
            return true;
        }
        if (minNode != null && root.val <= minNode.val) {
            return false;
        }
        if (maxNode != null && root.val >= maxNode.val) {
            return false;
        }
        return traverse(root.left, minNode, root) && traverse(root.right, root, maxNode);
    }
}
