package first.leetcode.no15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author JellyfishMIX
 * @date 2021/8/10 11:08
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 入参数组长度
        int length = nums.length;
        // 从小到大排序
        Arrays.sort(nums);
        // 答案
        List<List<Integer>> ans = new ArrayList<>();
        // 固定 a
        for (int a = 0; a < length; a++) {
            // a 需要和上一次枚举的数不相同
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // b 为 left 指针，从 head 开始。c 为 right 指针，从 tail 开始。
            int left = a + 1;
            int right = length - 1;
            // 所需目标值，nums[a] + nums[left] + nums[right] == 0
            int target = -nums[a];
            while (left < right) {
                // left 需要和上一次遍历的不同
                if (left > a + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                // right 需要和上一次遍历的不同
                if (right < length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                // sum 和 target 相同，记录结果
                if (sum == target) {
                    List<Integer> eachAns = new ArrayList<>();
                    eachAns.add(nums[a]);
                    eachAns.add(nums[left]);
                    eachAns.add(nums[right]);
                    ans.add(eachAns);
                    left++;
                    right--;
                    // sum 比 target 小，left 右移
                } else if (sum < target) {
                    left++;
                    continue;
                    // sum 比 target 大，right 左移
                } else {
                    right--;
                    continue;
                }
            }
        }
        return ans;
    }
}
