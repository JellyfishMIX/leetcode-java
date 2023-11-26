package second.leetcode.no167;

/**
 * @author shijie.qian
 * @date 2023/11/27 01:19
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 不考虑空
        int left = 0;
        int right = numbers.length - 1;
        // left 和 right 相向而行
        while (left != right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
