package second.leetcode.no128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shijie.qian
 * @date 2024/3/19 12:37
 */
public class Solution {
    private Set<Integer> hashSet = new HashSet<>();

    public int longestConsecutive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }
        return calculateLongest();
    }

    private int calculateLongest() {
        int longestLength = 0;
        for (Integer currentInt : hashSet) {
            // 从最小的开始记
            if (!hashSet.contains(currentInt - 1)) {
                int pointer = currentInt;
                int currentLength = 1;
                while (hashSet.contains(pointer + 1)) {
                    currentLength++;
                    pointer++;
                }
                longestLength = Math.max(longestLength, currentLength);
            }
        }
        return longestLength;
    }
}
