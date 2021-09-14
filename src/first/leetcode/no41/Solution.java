package first.leetcode.no41;

/**
 * 41. 缺失的第一个正数
 * link: https://leetcode-cn.com/problems/first-missing-positive/
 * 题解：https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
 *
 * @author JellyfishMIX
 * @date 2021/9/14 11:53
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 需要在指定的范围内，且没有放在正确的位置上才交换
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 查找第一个缺失的正数
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        // 都正确则返回数组长度 + 1
        return nums.length + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
