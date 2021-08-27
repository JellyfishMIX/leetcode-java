package first.no53;

/**
 * 53. 最大子序和
 * link: https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author JellyfishMIX
 * @date 2021/8/21 11:16
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
