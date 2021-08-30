package first.no617;

/**
 * 617. 合并二叉树
 * link: https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author JellyfishMIX
 * @date 2021/8/30 16:53
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode newNode = new TreeNode();
        if (root1 != null && root2 != null) {
            newNode.val = root1.val + root2.val;
            newNode.left = mergeTrees(root1.left, root2.left);
            newNode.right = mergeTrees(root1.right, root2.right);
        } else if (root1 != null) {
            newNode.val = root1.val;
            newNode.left = mergeTrees(root1.left, null);
            newNode.right = mergeTrees(root1.right, null);
        } else {
            newNode.val = root2.val;
            newNode.left = mergeTrees(null, root2.left);
            newNode.right = mergeTrees(null, root2.right);
        }
        return newNode;
    }
}
