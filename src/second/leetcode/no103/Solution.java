package second.leetcode.no103;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shijie.qian
 * @date 2024/4/5 11:53
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        // 不考虑空入参
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean left2Rgiht = true;
        while (!queue.isEmpty()) {
            List<Integer> currentDepthNodes = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                currentDepthNodes.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            if (left2Rgiht) {
                // do nothing
            } else {
                Collections.reverse(currentDepthNodes);
            }
            result.add(new ArrayList<>(currentDepthNodes));
            left2Rgiht = !left2Rgiht;
        }

        return result;
    }
}
