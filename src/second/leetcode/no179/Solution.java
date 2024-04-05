package second.leetcode.no179;

import java.util.Arrays;

/**
 * @author shijie.qian
 * @date 2024/4/6 03:01
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        // 针对测试用例[0, 0]需要特殊处理
        if ("0".equals(strs[0])) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }
}
