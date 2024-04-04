package second.leetcode.no102;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shijie.qian
 * @date 2024/4/5 02:14
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 不考虑空入参
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            // 记录当前 depth 横向的 node
            int queueSize = queue.size();
            List<Integer> currentDepthList = new ArrayList<>(queueSize);
            for (int i = 0; i < queueSize; i++) {
                TreeNode currentNode = queue.poll();
                currentDepthList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            result.add(currentDepthList);
        }

        return result;
    }
}
