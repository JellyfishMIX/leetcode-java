package second.leetcode.no700;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/11 01:53
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // 不考虑空
        return traverse(root, val);
    }

    private TreeNode traverse(TreeNode root, final int target) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode leftResult = traverse(root.left, target);
        if (leftResult != null) {
            return leftResult;
        }
        TreeNode rightResult = traverse(root.right, target);
        if (rightResult != null) {
            return rightResult;
        }
        return null;
    }
}
