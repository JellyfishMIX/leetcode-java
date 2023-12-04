package second.leetcode.no35;

/**
 * @author shijie.qian
 * @date 2023/12/5 00:32
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        // 不考虑空
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int middleElement = nums[middle];
            if (middleElement == target) {
                return middle;
            } else if (middleElement < target) {
                left = middle + 1;
            } else if (middleElement > target) {
                right = middle - 1;
            }
        }
        // 无目标元素，返回 left，是第一个比 target 大的元素
        return left;
    }
}
