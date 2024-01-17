package second.leetcode.no104;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/1/17 19:16
 */
public class Solution {
    private int globalMaxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root, 0);
        return globalMaxDepth;
    }

    /**
     * 回溯
     */
    private void traverse(TreeNode root, int currentDepth) {
       if (root == null) {
           globalMaxDepth = Math.max(currentDepth, globalMaxDepth);
           return;
       }
       int nextDepth = currentDepth + 1;
       traverse(root.left, nextDepth);
       traverse(root.right, nextDepth);
    }
}
