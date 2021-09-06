package first.leetcode.no704;

/**
 * 704. 二分查找
 * link: https://leetcode-cn.com/problems/binary-search/
 * 递归写法
 *
 * @author JellyfishMIX
 * @date 2021/9/6 10:39
 */
public class SolutionRecursion {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        // 防止数据过大溢出
        int middle = left + (right - left) / 2;
        // base case
        if (target == nums[middle]) {
            return middle;
        } else if (left >= right) {
            return -1;
        } else if (target < nums[middle]) {
            right = middle - 1;
        } else if (target > nums[middle]) {
            left = middle + 1;
        }
        return binarySearch(nums, left, right, target);
    }
}
