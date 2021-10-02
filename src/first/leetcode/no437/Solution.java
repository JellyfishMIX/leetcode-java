package first.leetcode.no437;

/**
 * 437. 路径总和 III
 * link: https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @author JellyfishMIX
 * @date 2021/10/2 18:36
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return dfsMaster(root, targetSum);
    }

    private int dfsMaster(TreeNode root, int target) {
        // base case
        if (root == null) {
            return 0;
        }
        int sum = 0;
        sum += dfsAssist(root, target);
        sum += dfsMaster(root.left, target);
        sum += dfsMaster(root.right, target);
        return sum;
    }

    private int dfsAssist(TreeNode root, int target) {
        // base case
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (target - root.val == 0) {
            sum += 1;
        }

        sum += dfsAssist(root.left, target - root.val);
        sum += dfsAssist(root.right, target - root.val);
        return sum;
    }
}
