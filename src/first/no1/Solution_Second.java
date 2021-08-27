package first.no1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * link: https://leetcode-cn.com/problems/two-sum/
 * 二刷
 *
 * @author JellyfishMIX
 * @date 2021/8/14 10:48
 */
public class Solution_Second {
    public int[] twoSum(int[] nums, int target) {
        // value, index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int another = target - nums[i];
            Integer anotherIndex = map.get(another);
            if (anotherIndex == null) {
                map.put(nums[i], i);
            } else {
                return new int[] {i, anotherIndex};
            }
        }
        return new int[] {};
    }
}
