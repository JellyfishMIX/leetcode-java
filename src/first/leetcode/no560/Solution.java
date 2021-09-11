package first.leetcode.no560;

/**
 * 560. 和为 K 的子数组
 * link: https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 前缀和解法
 *
 * @author JellyfishMIX
 * @date 2021/9/10 23:56
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 求前缀和
        // preSum[i] 表示 [0, i - 1] 的和。i 从 1 开始
        int[] preSum = new int[nums.length + 1];
        // base case
        preSum[0] = 0;
        // 求前缀和
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int result = 0;
        // 判断和为 k 的子数组有几个
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] == k) {
                    result++;
                }
            }
        }

        return result;
    }
}
