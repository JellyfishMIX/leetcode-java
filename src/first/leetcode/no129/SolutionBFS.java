package first.leetcode.no129;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. 求根节点到叶节点数字之和
 * link: https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * BFS 解法
 *
 * @author JellyfishMIX
 * @date 2021/8/20 14:25
 */
public class SolutionBFS {
    public int sumNumbers(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        int sum = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            if (node.left == null && node.right == null) {
                sum += num;
                continue;
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                numQueue.offer(10 * num + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                numQueue.offer(10 * num + node.right.val);
            }
        }
        return sum;
    }
}
