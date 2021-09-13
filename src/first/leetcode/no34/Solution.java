package first.leetcode.no34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * link: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 题目要求时间复杂度为 O(log n)，因此使用二分查找。找到后前后指针寻找元素第一个和最后一个位置。
 *
 * @author JellyfishMIX
 * @date 2021/9/11 21:00
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        // 二分查找的左右指针
        int left = 0, right = nums.length - 1;
        int targetIndex = -1;
        while (left <= right) {
            // 防止溢出
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                targetIndex = middle;
                break;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        // 未找到，返回 [-1, -1]
        if (targetIndex == -1) {
            return new int[] {-1, -1};
        }

        return bothSidesSearch(nums, target, targetIndex);
    }

    /**
     * 从 targetIndex 开始，使用左右指针寻找元素第一个和最后一个位置
     *
     * @param nums
     * @param targetIndex
     * @return
     */
    private int[] bothSidesSearch(int[] nums, int target, int targetIndex) {
        int left = targetIndex, right = targetIndex;
        // 左指针迭代
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        // 右指针迭代
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[] {left + 1, right - 1};
    }
}
