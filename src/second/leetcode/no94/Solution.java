package second.leetcode.no94;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/6 03:04
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        recursion(root);
        return result;
    }

    private void recursion(TreeNode node) {
        // base case
        if (node == null) {
            return;
        }
        recursion(node.left);
        result.add(node.val);
        recursion(node.right);
    }
}
