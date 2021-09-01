package first.leetcode.no283;

/**
 * 283. 移动零
 * link: https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author JellyfishMIX
 * @date 2021/8/29 00:24
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int sortedTail = 0;
        int unsortedHead = 0;
        while (unsortedHead < nums.length) {
            if (nums[unsortedHead] != 0) {
                swap(nums, sortedTail, unsortedHead);
                sortedTail++;
            }
            unsortedHead++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
