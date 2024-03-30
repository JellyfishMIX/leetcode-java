package second.leetcode.no189;

/**
 * @author shijie.qian
 * @date 2024/3/27 10:36
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        // 不考虑空入参
        final int numsLength = nums.length;
        int[] tempArr = new int[numsLength];
        for (int i = 0; i < numsLength; i++) {
            tempArr[(i + k) % numsLength] = nums[i];
        }
        System.arraycopy(tempArr, 0, nums, 0, numsLength);
    }
}
