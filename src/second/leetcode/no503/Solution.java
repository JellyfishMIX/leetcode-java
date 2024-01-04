package second.leetcode.no503;

import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2024/1/3 22:54
 */
public class Solution {
    private Stack<Integer> monoStack = new Stack<>();

    public int[] nextGreaterElements(int[] nums) {
        // 不考虑空
        // 数组长度加倍
        int twoLength = nums.length * 2;
        int[] nextGreaterArray = new int[nums.length];
        for (int i = twoLength - 1; i >= 0; i--) {
            int realIndex = i % nums.length;
            while (!monoStack.isEmpty() && monoStack.peek() <= nums[realIndex]) {
                monoStack.pop();
            }
            nextGreaterArray[realIndex] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(nums[realIndex]);
        }
        return nextGreaterArray;
    }
}
