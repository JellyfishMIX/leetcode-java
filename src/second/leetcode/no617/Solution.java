package second.leetcode.no617;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/4/12 02:21
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return recursion(root1, root2);
    }

    private TreeNode recursion(TreeNode node1, TreeNode node2) {
        // base case
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        TreeNode leftNode = recursion(node1.left, node2.left);
        TreeNode rightNode = recursion(node1.right, node2.right);
        int sum = node1.val + node2.val;
        TreeNode result = new TreeNode(sum);
        result.left = leftNode;
        result.right = rightNode;

        return result;
    }
}
