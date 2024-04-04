package second.leetcode.no113;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/5 02:45
 */
public class Solution {
    private LinkedList<Integer> candidates = new LinkedList<>();
    private int targetSum = 0;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        recursion(root, 0);
        return result;
    }

    private void recursion(TreeNode node, int currentSum) {
        // base case
        if (node == null) {
            return;
        }

        int currentVal = node.val;
        currentSum += currentVal;
        candidates.add(currentVal);
        // 叶子节点
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(candidates));
            }
            candidates.removeLast();
            return;
        }

        recursion(node.left, currentSum);
        recursion(node.right, currentSum);
        candidates.removeLast();
    }
}
