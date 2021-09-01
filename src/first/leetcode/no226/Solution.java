package first.leetcode.no226;

/**
 * 226. 翻转二叉树
 * link: https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/21 11:03
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }
}
