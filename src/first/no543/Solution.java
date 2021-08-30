package first.no543;

/**
 * 543. 二叉树的直径
 * link: https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/30 13:05
 */
public class Solution {
    private int result;

    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        depth(root);
        return result;
    }

    private int depth(TreeNode root) {
        // root
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        int currentResult = leftDepth + rightDepth;
        result = Math.max(result, currentResult);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
