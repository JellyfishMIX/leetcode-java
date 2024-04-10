package second.leetcode.exam.no151;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shijie.qian
 * @date 2024/4/8 18:20
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> light(TreeNode root) {
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                if (i == queueSize - 1) {
                    result.add(currentNode.val);
                }
            }
        }

        return result;
    }
}
