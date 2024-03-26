package second.leetcode.no560.correct2;

/**
 * @author shijie.qian
 * @date 2024/3/26 02:46
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 不考虑空入参
        int targetNum = 0;
        // 前缀和, 表示 [0,i - 1] 和为多少
        int[] preSum = new int[nums.length + 1];
        preSum[0] = nums[0];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (preSum[j + 1] - preSum[i] == k) {
                    targetNum++;
                }
            }
        }
        return targetNum;
    }
}
