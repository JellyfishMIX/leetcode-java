package second.leetcode.no116;

/**
 * @author shijie.qian
 * @date 2024/1/17 22:19
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        // 连接当前传入的两个节点
        node1.next = node2;

        traverse(node1.left, node1.right);
        traverse(node1.right, node2.left);
        traverse(node2.left, node2.right);
    }
}
