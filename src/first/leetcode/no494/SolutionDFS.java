package first.leetcode.no494;

/**
 * 494. 目标和
 * link: https://leetcode-cn.com/problems/target-sum/
 *
 *  @author JellyfishMIX
 * @date 2021/10/2 11:43
 */
class SolutionDFS {
    private int[] nums;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        int result = dfs(0, target);
        return result;
    }

    private int dfs(int index, int target) {
        // base case
        if (index == nums.length) {
            return target == 0 ? 1 : 0;
        }

        // 两种选择 + nums[index] or - nums[index]
        int targetNum = dfs(index + 1, target + nums[index])
                + dfs(index + 1, target - nums[index]);
        return targetNum;
    }
}
