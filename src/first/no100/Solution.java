package first.no100;

/**
 * 100. 相同的树
 * link: https://leetcode-cn.com/problems/same-tree/
 *
 * @author JellyfishMIX
 * @date 2021/8/29 03:16
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
