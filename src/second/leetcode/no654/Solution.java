package second.leetcode.no654;

import second.leetcode.common.TreeNode;

/**
 * @author shijie.qian
 * @date 2024/1/30 01:00
 */
public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 不考虑空
        return traverse(nums, 0, nums.length - 1);
    }

    /**
     * 找到 [start, end] 中最大的数字作为 root，记为索引 largestIndex
     * [start, largestIndex - 1] 作为新的 traverse 入参，返回结果作为左子树
     * [largestIndex + 1, end] 作为新的 traverse 入参，返回结果作为右子树
     * @return 树节点
     */
    private TreeNode traverse(int[] nums, int start, int end) {
        // base case
        if (start > end) {
            return null;
        }
        // 找到最大值的 index 记为索引 largestIndex
        int maxValue = Integer.MIN_VALUE;
        int largestIndex = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                largestIndex = i;
            }
        }

        // [start, largestIndex - 1] 作为新的 traverse 入参，返回结果作为左子树
        TreeNode left = traverse(nums, start, largestIndex - 1);
        TreeNode right = traverse(nums, largestIndex + 1, end);
        return new TreeNode(maxValue, left, right);
    }
}
