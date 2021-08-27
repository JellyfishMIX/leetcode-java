package first.no103;

import java.util.Deque;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Queue;

/**
 * 103. 二叉树的锯齿形层序遍历
 * link: https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * @author JellyfishMIX
 * @date 2021/8/10 14:59
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 最终答案
        List<List<Integer>> ans = new LinkedList<>();
        // root 判空
        if (root == null) {
            return ans;
        }
        // 用于层序遍历的 queue
        Queue<TreeNode> linkedQueue = new LinkedList<>();
        // root 进队列
        linkedQueue.offer(root);
        // 遍历方向
        boolean orderLeft = true;
        // 开始遍历
        while (!linkedQueue.isEmpty()) {
            // 当前队列长度
            int currentSize = linkedQueue.size();
            // 当前 level 双端队列，根据 orderLeft 决定 offerLast 还是 offerRight
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < currentSize; i++) {
                // 当前节点
                TreeNode currentNode = linkedQueue.poll();
                if (orderLeft) {
                    deque.offerLast(currentNode.val);
                } else {
                    deque.offerFirst(currentNode.val);
                }
                if (currentNode.left != null) {
                    linkedQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    linkedQueue.offer(currentNode.right);
                }
            }
            orderLeft = !orderLeft;
            ans.add(new LinkedList<>(deque));
        }
        return ans;
    }
}
