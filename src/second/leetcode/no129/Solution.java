package second.leetcode.no129;

import second.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/5 12:26
 */
public class Solution {
    private int resultSum = 0;
    private LinkedList<Integer> candidates = new LinkedList<>();

    public int sumNumbers(TreeNode root) {
        recursion(root);
        return resultSum;
    }

    private void recursion(TreeNode node) {
        // base case
        if (node == null) {
            return;
        }

        candidates.add(node.val);
        // 叶子节点
        if (node.left == null && node.right == null) {
            resultSum += computeSum();
            candidates.removeLast();
            return;
        }
        recursion(node.left);
        recursion(node.right);
        candidates.removeLast();
    }

    private int computeSum() {
        List<Integer> tempList = new ArrayList<>(candidates);
        Collections.reverse(tempList);
        int bit = 1;
        int result = 0;
        for (Integer currentInt : tempList) {
            result += currentInt * bit;
            bit *= 10;
        }
        return result;
    }
}
