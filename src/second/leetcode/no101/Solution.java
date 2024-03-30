package second.leetcode.no101;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/3/26 14:25
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 不考虑空入参
        return recurse(root, root);
    }

    private boolean recurse(TreeNode leftRoot, TreeNode rightRoot) {
        // base case
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }

        if (leftRoot.val != rightRoot.val) {
            return false;
        }
        boolean outerResult = recurse(leftRoot.left, rightRoot.right);
        boolean innerResult = recurse(leftRoot.right, rightRoot.left);
        return outerResult && innerResult;
    }
}
