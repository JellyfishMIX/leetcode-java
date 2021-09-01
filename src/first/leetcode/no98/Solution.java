package first.leetcode.no98;

/**
 * 98. 验证二叉搜索树
 * link: https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
 *
 * @author JellyfishMIX
 * @date 2021/8/30 00:35
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // root
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
