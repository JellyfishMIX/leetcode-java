package second.leetcode.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shijie.qian
 * @date 2024/4/5 01:40
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 不考虑空入参
        // 先排序，后面使用的双指针解法要求数组有序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 重复的 nums[i] 不计入
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 固定 i, 使用双指针寻找 j, k
            int left = i + 1;
            int right = nums.length - 1;
            int target = 0 - nums[i];
            while (left < right) {
                // 重复的 nums[left] 不计入
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                // 重复的 nums[right] 不计入
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }

                // 标准双指针三个判断
                int twoSum = nums[left] + nums[right];
                if (twoSum == target) {
                    // 找到了目标
                    List<Integer> currentResultList = new ArrayList<>();
                    currentResultList.add(nums[i]);
                    currentResultList.add(nums[left]);
                    currentResultList.add(nums[right]);
                    result.add(currentResultList);
                    left++;
                    right--;
                } else if (twoSum > target) {
                    // 需要移动 right 指针让 threeSum 减小
                    right--;
                    continue;
                } else if (twoSum < target) {
                    // 需要移动 left 指针让 threeSum 增大
                    left++;
                    continue;
                }
            }
        }
        return result;
    }
}
