package first.codinginterviews2.no4;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * link: https://leetcode-cn.com/problems/WGki4K/
 *
 * @author JellyfishMIX
 * @date 2021/9/16 14:13
 */
public class Solution {
    public int singleNumber(int[] nums) {
        // 特判
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                if (count != 3) {
                    return nums[i - 1];
                } else {
                    count = 1;
                }
            }
        }
        return nums[nums.length - 1];
    }

    @Test
    public void test() {
        int result = singleNumber(new int[] {0,1,0,1,0,1,99});
        System.out.println(result);
    }
}
