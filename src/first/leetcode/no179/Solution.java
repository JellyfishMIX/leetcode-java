package first.leetcode.no179;

import java.util.Arrays;

/**
 * 179. 最大数
 * link: https://leetcode-cn.com/problems/largest-number/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 22:05
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrArr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrArr, (a, b) -> (b + a).compareTo(a + b));
        // 针对测试用例 [0, 0] 特判，需要返回 "0"
        if ("0".equals(numStrArr[0])) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String s : numStrArr) {
            result.append(s);
        }
        return result.toString();
    }
}
