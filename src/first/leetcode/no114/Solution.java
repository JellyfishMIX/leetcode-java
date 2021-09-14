package first.leetcode.no114;

/**
 * 114. 二叉树展开为链表
 * link: https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 题解：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
 *
 * @author JellyfishMIX
 * @date 2021/9/13 17:47
 */
public class Solution {
    public void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为空，直接看下一个结点
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode cur = root.left;
                // 寻找左子树的最右边结点
                while (cur.right != null) {
                    cur = cur.right;
                }
                // 把当前 root 的 right 拼接到当前 root 左子树的最右边结点
                cur.right = root.right;
                // 把 root 的左子树拼接到 root 的右子树
                root.right = root.left;
                root.left = null;
                // 继续下次迭代
                root = root.right;
            }
        }
    }
}
