package second.leetcode.no31;

/**
 * @author shijie.qian
 * @date 2024/4/6 01:44
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int smallestBiggerIndex = nums.length - 1;
        // 整个 nums 单调递减
        boolean singleNegative = true;
        for (int i = nums.length - 1; i > 0; i--) {
            // 找到了递增区间
            if (nums[i] > nums[i - 1]) {
                while (nums[smallestBiggerIndex] <= nums[i - 1]) {
                    smallestBiggerIndex--;
                    continue;
                }
                exchange(nums, i - 1, smallestBiggerIndex);
                reverseSingle(nums, i, nums.length - 1);
                singleNegative = false;
                break;
            }
        }
        if (singleNegative) {
            reverseSingle(nums, 0, nums.length - 1);
        }
    }

    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverseSingle(int[] nums, int start, int end) {
        while (start < end) {
            exchange(nums, start, end);
            start++;
            end--;
        }
    }
}
