package no1;

import java.util.HashMap;

/**
 * leetCode link: https://leetcode-cn.com/problems/two-sum/
 *
 * @author JellyfishMIX
 * @date 2021/6/21 14:03
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int another = target - nums[i];
            if (hashMap.containsKey(another)) {
                int anotherIndex = hashMap.get(another);
                return new int[] {anotherIndex, i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}
