package second.leetcode.no111;

import com.apple.eawt.AppEvent;
import second.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shijie.qian
 * @date 2024/3/17 21:32
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        // bfs start
        bfsQueue.offer(root);
        int depth = 1;
        // base case
        while (!bfsQueue.isEmpty()) {
            final int bfsQueueSize = bfsQueue.size();
            for (int i = 0; i < bfsQueueSize; i++) {
                TreeNode currentNode = bfsQueue.poll();
                TreeNode leftNode = currentNode.left;
                TreeNode rightNode = currentNode.right;
                // bfs end
                if (leftNode == null && rightNode == null) {
                    return depth;
                }
                if (leftNode != null) {
                    bfsQueue.offer(leftNode);
                }
                if (rightNode != null) {
                    bfsQueue.offer(rightNode);
                }
            }
            depth++;
        }
        return depth;
    }
}
