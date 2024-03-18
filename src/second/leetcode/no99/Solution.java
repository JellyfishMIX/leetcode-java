package second.leetcode.no99;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/3/17 21:59
 */
public class Solution {
    private TreeNode x = null;
    private TreeNode y = null;
    private TreeNode prePointer = null;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if (x != null && y != null) {
            convert(x, y);
        }
    }

    private void dfs(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        dfs(root.left);
        // 二叉搜索树的中序遍历应该是升序的
        if (prePointer == null) {
            prePointer = root;
        } else {
            if (prePointer.val > root.val) {
                // 出现错误需要交换
                if (x == null) {
                    x = prePointer;
                }
                y = root;
            }
            prePointer = root;
        }
        dfs(root.right);
    }

    private void convert(TreeNode x, TreeNode y) {
        // 不考虑空
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}
