package second.leetcode.no560.correct;

/**
 * @author shijie.qian
 * @date 2024/3/26 02:27
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 不考虑空入参
        int targetNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    targetNum++;
                }
            }
        }
        return targetNum;
    }
}
