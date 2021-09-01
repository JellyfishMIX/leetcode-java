package first.leetcode.no700;

/**
 * 700. 二叉搜索树中的搜索
 * link: https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/30 00:30
 */
public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // root
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
