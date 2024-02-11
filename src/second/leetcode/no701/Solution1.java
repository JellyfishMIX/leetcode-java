package second.leetcode.no701;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/11 02:10
 */
public class Solution1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return traverse(root, val);
    }

    private TreeNode traverse(TreeNode root, final int target) {
        // base case
        // 找到了 null 位置可以构造新 node
        if (root == null) {
            return new TreeNode(target);
        }
        if (root.val == target) {
            // do nothing
            return root;
        }
        if (root.val < target) {
            root.right = traverse(root.right, target);
            return root;
        }
        if (root.val > target) {
            root.left = traverse(root.left, target);
            return root;
        }
        // 不会走到此情况
        return null;
    }
}
