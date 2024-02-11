package second.leetcode.no450;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/12 01:17
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // 不考虑空
        return traverse(root, key);
    }

    private TreeNode traverse(TreeNode root, final int target) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            int minNodeVal = obtainMinNode(root.right).val;
            root.val = minNodeVal;
            root.right = traverse(root.right, minNodeVal);
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
        // can not happen
        return null;
    }

    private TreeNode obtainMinNode(TreeNode root) {
        // bst 最左叶子即为最小的
        if (root == null) {
            return null;
        }
        TreeNode treeNode = obtainMinNode(root.left);
        if (treeNode == null) {
            return root;
        } else {
            return treeNode;
        }
    }
}
