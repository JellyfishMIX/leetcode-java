package second.leetcode.no1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/2/28 16:40
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 不考虑 null 入参
        // value, index
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            int anotherValue = target - currentValue;
            Integer anotherIndex = valueIndexMap.get(anotherValue);
            if (anotherIndex == null) {
                valueIndexMap.put(currentValue, i);
            } else {
                return new int[]{i, anotherIndex};
            }
        }
        // 理论上不会走到这里，题目包装一定存在解
        return new int[2];
    }
}
