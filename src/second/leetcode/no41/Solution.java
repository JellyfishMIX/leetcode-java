package second.leetcode.no41;

/**
 * @author shijie.qian
 * @date 2024/4/24 11:44
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int numsLength = nums.length;
        for (int i = 0; i < numsLength; i++) {
            while (nums[i] > 0 && nums[i] - 1 != i && nums[i] < numsLength && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < numsLength; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return numsLength + 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
