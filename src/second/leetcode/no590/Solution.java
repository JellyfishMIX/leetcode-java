package second.leetcode.no590;

import second.leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/12 02:31
 */
public class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        recursion(root);
        return result;
    }

    private void recursion(Node node) {
        // base case
        if (node == null) {
            return;
        }

        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                recursion(child);
            }
        }
        result.add(node.val);
    }
}
