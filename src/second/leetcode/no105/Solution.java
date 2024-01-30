package second.leetcode.no105;

import second.leetcode.common.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/1/30 11:02
 */
public class Solution {
    private Map<Integer, Integer> value2IndexMap = Collections.emptyMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> tempValue2IndexMap = new HashMap<>();
        // 不考虑空
        for (int i = 0; i < inorder.length; i++) {
            tempValue2IndexMap.put(inorder[i], i);
        }
        value2IndexMap = tempValue2IndexMap;
        int length = preorder.length;
        return traverse(preorder, 0, length - 1, inorder, 0, length - 1);
    }

    private TreeNode traverse(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        int inRootIndex = value2IndexMap.get(rootValue);

        int preLeftSize = inRootIndex - inStart;

        // 递归构造左子树 left
        // 递归构造右子树 right
        TreeNode left = traverse(preorder, preStart + 1, preStart + preLeftSize, inorder, inStart, inRootIndex - 1);
        TreeNode right = traverse(preorder, preStart + preLeftSize + 1, preEnd, inorder, inRootIndex + 1, inEnd);

        // 构造当前 root
        TreeNode root = new TreeNode(rootValue, left, right);
        return root;
    }
}
