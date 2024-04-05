package second.leetcode.no236;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/4/5 12:19
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recursion(root, p, q);
    }

    private TreeNode recursion(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) {
            return node;
        }

        TreeNode leftResult = recursion(node.left, p, q);
        TreeNode rightResult = recursion(node.right, p, q);
        // 左侧没找到, 返回右侧
        if (leftResult == null) {
            return rightResult;
        }
        // 右侧没找到，返回左侧
        if (rightResult == null) {
            return leftResult;
        }
        // 左右都有目标，说明 p q 分布在了 node 的异侧, node 是公共节点
        return node;
    }
}
