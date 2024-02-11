package second.leetcode.no701;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/11 01:57
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        traverse(root, val);
        return root;
    }

    /**
     * @return true 已执行插入 false 未执行插入
     */
    private void traverse(TreeNode root, final int target) {
        // base case
        if (root == null) {
            return;
        }
        if (root.val == target) {
            // do nothing
            return;
        }
        if (root.val < target) {
            if (root.right == null) {
                root.right = new TreeNode(target);
                return;
            } else {
                traverse(root.right, target);
            }
        }
        if (root.val > target) {
            if (root.left == null) {
                root.left = new TreeNode(target);
                return;
            } else {
                traverse(root.left, target);
            }
        }
    }
}
