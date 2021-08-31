package first.no167;

/**
 * 167. 两数之和 II - 输入有序数组
 * link: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author JellyfishMIX
 * @date 2021/8/31 15:26
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                // 题目要求的索引从 1 开始
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
                continue;
            } else if (sum > target) {
                right--;
                continue;
            }
        }
        return new int[] {-1, -1};
    }
}
