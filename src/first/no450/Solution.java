package first.no450;

/**
 * 450. 删除二叉搜索树中的节点
 * link: https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * @author JellyfishMIX
 * @date 2021/8/29 03:37
 */
public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // root
        if (root == null) {
            return null;
        }
        if (key == root.val) {
            // do something
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            int rightMin = getMin(root.right);
            root.right = deleteNode(root.right, rightMin);
            root.val = rightMin;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private int getMin(TreeNode root) {
        // root
        if (root.left == null) {
            return root.val;
        } else {
            return getMin(root.left);
        }
    }
}
