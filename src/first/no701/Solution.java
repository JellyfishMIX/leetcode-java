package first.no701;

/**
 * 701. 二叉搜索树中的插入操作
 * link: https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/30 00:18
 */
public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // root
        if (root == null) {
            return new TreeNode(val, null, null);
        }
        if (val == root.val) {
            // do nothing
        } else if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
