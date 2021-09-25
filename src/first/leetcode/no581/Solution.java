package first.leetcode.no581;

/**
 * 581. 最短无序连续子数组
 * link: https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * 题解：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/gong-shui-san-xie-yi-ti-shuang-jie-shuan-e1le/
 *
 * @author JellyfishMIX
 * @date 2021/9/25 09:18
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] <= nums[left + 1]) {
            left++;
        }
        while (left < right && nums[right] >= nums[right - 1]) {
            right--;
        }
        int i = left;
        int j = right;
        int min = nums[left];
        int max = nums[right];
        for (int k = left; k <= right; k++) {
            if (nums[k] < min) {
                while (i >= 0 && nums[i] > nums[k]) {
                    i--;
                }
                min = i >= 0 ? nums[i] : Integer.MIN_VALUE;
            }
            if (nums[k] > max) {
                while (j < nums.length &&  nums[j] < nums[k]) {
                    j++;
                }
                max = j < nums.length ? nums[j] : Integer.MAX_VALUE;
            }
        }
        // for 中的 if 必定会执行至少一次，因为 nums[left + 1] 肯定比 nums[left] 小，nums[right - 1] 肯定比 nums[left] 大，否则 left == right
        return left == right ? 0 : (j - 1) - (i + 1) + 1;
    }
}
