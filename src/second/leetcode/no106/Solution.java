package second.leetcode.no106;

import second.leetcode.common.TreeNode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/2/3 17:42
 */
public class Solution {
    private Map<Integer, Integer> inorderValue2IndexMap = Collections.emptyMap();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 不考虑空
        Map<Integer, Integer> tempInorderValue = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            tempInorderValue.put(inorder[i], i);
        }
        inorderValue2IndexMap = tempInorderValue;
        return traverse(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 递归根据中序和后序得到二叉树
     */
    private TreeNode traverse(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd) {
            return null;
        }

        // root
        int rootValue = postorder[postEnd];
        // 中序中的 index
        int inorderRootIndex = inorderValue2IndexMap.get(rootValue);
        // 左子树长度
        int leftSize = inorderRootIndex - inStart;

        TreeNode left = traverse(inorder, inStart, inorderRootIndex - 1, postorder, postStart, postStart + leftSize - 1);
        TreeNode right = traverse(inorder, inorderRootIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return new TreeNode(rootValue, left, right);
    }
}
