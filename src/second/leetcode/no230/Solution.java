package second.leetcode.no230;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/2/10 11:21
 */
public class Solution {
    private int result;
    private int k;
    private int index;

    public int kthSmallest(TreeNode root, int k) {
        // 不考虑空
        this.k = k;
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        traverse(root.left);
        // bst 中序是升序的
        index++;
        if (index == k) {
            result = root.val;
        }
        traverse(root.right);
    }
}
