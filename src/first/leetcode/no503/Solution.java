package first.leetcode.no503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * link: https://leetcode-cn.com/problems/next-greater-element-ii/
 * 题解：https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
 *
 * @author JellyfishMIX
 * @date 2021/9/26 13:10
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        // 下一个更大元素的值
        int[] nextGreater = new int[length];
        Arrays.fill(nextGreater, -1);
        // 单调递减栈，存储元素的下标
        Deque<Integer> monoStack = new LinkedList<>();
        for (int i = 0; i < 2 * length; i++) {
            int index = i % length;
            while (!monoStack.isEmpty() && nums[index] > nums[monoStack.peek()]) {
                nextGreater[monoStack.pop()] = nums[index];
            }
            monoStack.push(index);
        }
        return nextGreater;
    }
}
