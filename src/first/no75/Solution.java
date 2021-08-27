package first.no75;

/**
 * 75. 颜色分类
 * link: https://leetcode-cn.com/problems/sort-colors/
 *
 * @author JellyfishMIX
 * @date 2021/8/27 14:19
 */
public class Solution {
    public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
        for (int i = ptr; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr);
                ptr++;
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
