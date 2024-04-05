package second.leetcode.no136;

/**
 * @author shijie.qian
 * @date 2024/4/6 03:11
 */
public class Solution {
    public int singleNumber(int[] nums) {
        // 不考虑空入参
        int result = nums[0];
        // 异或满足交换律，结果与元素顺序无关
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
