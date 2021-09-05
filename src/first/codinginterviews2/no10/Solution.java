package first.codinginterviews2.no10;

import org.junit.Test;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * link: https://leetcode-cn.com/problems/QTMn0o/
 * 前缀和
 * 题解：https://mp.weixin.qq.com/s/4TxF0xVhlUO6v3teip9Jzg
 *
 * @author JellyfishMIX
 * @date 2021/9/4 01:44
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        // 前缀和，preSum[i] 表示 nums [0, i - 1] 的和
        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        // 求前缀和
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        // 求和为 k 的子数组
        int result = 0;
        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j <= length; j++) {
                // preSum[j] - preSum[i] 表示 nums[i, j - 1] 的和
                if (preSum[j] - preSum[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int result = subarraySum(new int[] {-1, -1, 1}, 0);
        System.out.println(result);
    }
}
