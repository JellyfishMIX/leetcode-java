package first.leetcode.no704;

/**
 * 704. 二分查找
 * link: https://leetcode-cn.com/problems/binary-search/
 * 非递归写法
 *
 * @author JellyfishMIX
 * @date 2021/9/6 11:03
 */
public class SolutionNonRecursion {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (target == nums[middle]) {
                // 找到 target，返回索引
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else if (target > nums[middle]) {
                left = middle + 1;
            }
        }
        // 未找到 target，返回 -1
        return -1;
    }
}
