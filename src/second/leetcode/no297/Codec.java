package second.leetcode.no297;

import second.leetcode.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author shijie.qian
 * @date 2024/2/6 03:58
 */
public class Codec {
    private static final String SPLIT_CHARACTER = "#";
    private static final String NULL_STR = "NULL";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 前序遍历
        return traverseSerialize(root);
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(11));
    }

    private String traverseSerialize(TreeNode root) {
        // base case
        if (root == null) {
            return NULL_STR;
        }
        // root.val 拼接上去
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(root.val));
        // left tree
        String leftStr = traverseSerialize(root.left);
        // right tree
        String rightStr = traverseSerialize(root.right);
        stringBuilder.append(SPLIT_CHARACTER).append(leftStr).append(SPLIT_CHARACTER).append(rightStr);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        // 字符串转链表
        String[] strs = data.split(SPLIT_CHARACTER);
        LinkedList<String> nodeStrList = new LinkedList<>(Arrays.asList(strs));
        // 前序遍历
        TreeNode treeNode = traverseDeserialize(nodeStrList);
        return treeNode;
    }

    private TreeNode traverseDeserialize(LinkedList<String> nodeStrList) {
        // base case
        if (nodeStrList == null || nodeStrList.isEmpty()) {
            return null;
        }
        String rootVal = nodeStrList.removeFirst();
        // base case
        if (NULL_STR.equals(rootVal)) {
            return null;
        }

        // left tree
        TreeNode leftTree = traverseDeserialize(nodeStrList);
        // right tree
        TreeNode rightTree = traverseDeserialize(nodeStrList);
        TreeNode treeNode = new TreeNode(Integer.parseInt(rootVal), leftTree, rightTree);
        return treeNode;
    }
}
