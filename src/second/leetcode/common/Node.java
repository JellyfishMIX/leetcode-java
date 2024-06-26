package second.leetcode.common;

import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/12 02:32
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
