package first.leetcode.no104;

/**
 * 104. 二叉树的最大深度
 * link: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 22:26
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
