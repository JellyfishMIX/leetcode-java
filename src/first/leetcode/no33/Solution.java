package first.leetcode.no33;

/**
 * 33. 搜索旋转排序数组
 * link: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环。
 * 题解：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-by-leetcode-solut/
 *
 * @author JellyfishMIX
 * @date 2021/9/22 10:12
 */
public class Solution {
    public int search(int[] nums, int target) {
        // 特殊判断
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        if (length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = length - 1;
        // 二分查找
        while (left <= right) {
            // 防止过大溢出
            int middle = left + (right - left);
            // 找到 target，返回索引
            if (target == nums[middle]) {
                return middle;
            }
            if (nums[0] < nums[middle]) {
                if (nums[0] <= target && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                if (nums[middle] <= target && target < nums[length - 1]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }
        // 二分查找完毕，未找到
        return -1;
    }
}
