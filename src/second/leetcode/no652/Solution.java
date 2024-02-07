package second.leetcode.no652;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/2/7 16:28
 */
public class Solution {
    private static final String NULL_FLAG = "null";
    private static final String SPLIT_CHAR = "#";
    private Map<String, Integer> nodeCountMap = new HashMap<>();
    private List<TreeNode> duplicateNodes = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // 不考虑空
        preTraverse(root);
        return duplicateNodes;
    }

    /**
     * 前序遍历找重复 node
     */
    private void preTraverse(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        String rootStr = serializeTraverse(root);
        nodeCountMap.merge(rootStr, 1, Integer::sum);
        if (nodeCountMap.get(rootStr) == 2) {
            duplicateNodes.add(root);
        }
        preTraverse(root.left);
        preTraverse(root.right);
    }

    private String serializeTraverse(TreeNode root) {
        // base case
        if (root == null) {
            return NULL_FLAG;
        }
        // left tree
        String leftStr = serializeTraverse(root.left);
        String rightStr = serializeTraverse(root.right);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(root.val).append(SPLIT_CHAR).append(leftStr).append(SPLIT_CHAR).append(rightStr);
        return stringBuilder.toString();
    }
}
