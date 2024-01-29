package second.leetcode.no114;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/1/30 00:46
 */
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root);
    }

    /**
     * 传入一个 node, 递归处理左和右，然后把右子树拼接到左子树的最深右子树，然后把左子树拼到右子树
     * @return 处理完的 currentNode
     */
    private TreeNode traverse(TreeNode currentNode) {
        // base case
        if (currentNode == null) {
            return null;
        }
        TreeNode left = traverse(currentNode.left);
        TreeNode right = traverse(currentNode.right);
        TreeNode target = left;
        if (target != null) {
            while (target.right != null) {
                target = target.right;
            }
            target.right = right;
            currentNode.right = currentNode.left;
        }
        currentNode.left = null;
        return currentNode;
    }
}
