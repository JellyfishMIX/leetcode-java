package first.leetcode.no31;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * link: https://leetcode-cn.com/problems/next-permutation/solution/
 *
 * @author JellyfishMIX
 * @date 2021/8/23 22:01
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }
        // 用于判断是不是递减序列，递减序列的下一个排列返回递增排列
        boolean decreaseFlag = true;
        // 较大值中的最小值的下标初始化为 length - 1
        int smallestBiggerIndex = length - 1;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                while (nums[smallestBiggerIndex] <= nums[i - 1]) {
                    smallestBiggerIndex--;
                }
                exchange(nums, i - 1, smallestBiggerIndex);
                reverse(nums, i);
                // 发生交换则说明不是递减序列
                decreaseFlag = false;
                break;
            }
        }
        // 如果是递减序列，递减序列的下一个排列返回递增排列
        if (decreaseFlag) {
            Arrays.sort(nums);
        }
    }

    private void exchange(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            exchange(nums, start, end);
            start++;
            end--;
        }
    }
}
