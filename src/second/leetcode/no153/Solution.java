package second.leetcode.no153;

/**
 * @author shijie.qian
 * @date 2024/4/22 00:01
 */
public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] == nums[high]) {
                low = pivot;
                break;
            } else if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            }
        }

        return nums[low];
    }
}
