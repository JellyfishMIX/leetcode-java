package first.no128;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * link: https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 14:03
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // 最长连续序列的长度
        int res = 0;
        for (int num : nums) {
            // 在一个连续序列的头部开始
            if (!set.contains(num - 1)) {
                int cur = num;
                while (set.contains(cur + 1)) {
                    cur++;
                }
                // 记录最长的长度
                res = Math.max(res, cur - num + 1);
            }
        }
        return res;
    }
}
