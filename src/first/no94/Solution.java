package first.no94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * link: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/submissions/
 * 题解：颜色标记法-一种通用且简明的树遍历方法。https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
 *
 * @author JellyfishMIX
 * @date 2021/8/28 00:23
 */
public class Solution {
    private class BooleanNode {
        private TreeNode node;
        /**
         * 是否访问过
         */
        private boolean access;

        public BooleanNode(TreeNode node, boolean access) {
            this.node = node;
            this.access = access;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<BooleanNode> stack = new LinkedList<>();
        stack.push(new BooleanNode(root, false));
        List<Integer> result = new LinkedList<>();
        while (!stack.isEmpty()) {
            BooleanNode booleanNode = stack.pop();
            if (booleanNode.access == false) {
                if (booleanNode.node.right != null) {
                    stack.push(new BooleanNode(booleanNode.node.right, false));
                }
                stack.push(new BooleanNode(booleanNode.node, true));
                if (booleanNode.node.left != null) {
                    stack.push(new BooleanNode(booleanNode.node.left, false));
                }
            } else {
                result.add(booleanNode.node.val);
            }
        }
        return result;
    }
}
