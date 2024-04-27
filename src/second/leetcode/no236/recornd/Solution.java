package second.leetcode.no236.recornd;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/4/24 11:48
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursion(root, p, q);
    }

    private TreeNode recursion(TreeNode node, TreeNode p, TreeNode q) {
        // base case
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode leftNode = recursion(node.left, p, q);
        TreeNode rightNode = recursion(node.right, p, q);

        // 左侧没找到，返回右侧
        if (leftNode == null) {
            return rightNode;
        }
        // 右侧没找到，返回左侧
        if (rightNode == null) {
            return leftNode;
        }
        // 左右侧都找到了，说明 p q 分布在 node 异侧，node 是公共节点
        return node;
    }
}
