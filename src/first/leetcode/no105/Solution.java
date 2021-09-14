package first.leetcode.no105;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * link: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 题解：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 *
 * @author JellyfishMIX
 * @date 2021/9/14 10:57
 */
public class Solution {
    /**
     * inorder <element, index>
     */
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    private int[] preorder;
    private int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        // 使用 HashMap 存储 inorder <element, index>
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return recursion(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recursion(int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        // base case
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 寻找 inorder 中的 root
        int rootValue = preorder[preorderLeft];
        int rootIndex = inorderIndexMap.get(rootValue);
        // 构造一个 root 结点
        TreeNode root = new TreeNode(rootValue);
        // 左子树的数目
        int leftNum = rootIndex - inorderLeft;
        // recursion
        root.left = recursion(preorderLeft + 1, preorderLeft + leftNum, inorderLeft, rootIndex - 1);
        root.right = recursion(preorderLeft + leftNum + 1, preorderRight, rootIndex + 1, inorderRight);
        return root;
    }
}
