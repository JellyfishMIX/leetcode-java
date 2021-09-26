package first.leetcode.no496;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * link: https://leetcode-cn.com/problems/next-greater-element-i/
 * 单调栈
 * 题解：https://leetcode-cn.com/problems/next-greater-element-i/solution/dan-diao-zhan-jie-jue-next-greater-number-yi-lei-w/
 *
 * @author JellyfishMIX
 * @date 2021/9/26 11:36
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // <nums1 value, nums1 value in nums2 corresponding index>
        Map<Integer, Integer> map = new HashMap<>();
        for (int integer : nums1) {
            // -1 表示暂未在 nums2 中找到位置
            map.put(integer, -1);
        }
        // 填充 hashMap
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], i);
            }
        }
        // 求 nums2 中，每位数在 nums2 中下一个大的数
        int[] nextGreater = new int[nums2.length];
        Arrays.fill(nextGreater, -1);
        // 单调递减栈中存储下标
        Deque<Integer> monoStack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!monoStack.isEmpty() && nums2[i] > nums2[monoStack.peek()]) {
                int index = monoStack.poll();
                nextGreater[index] = nums2[i];
            }
            monoStack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = nextGreater[map.get(nums1[i])];
        }
        return result;
    }

    @Test
    public void test() {
        int[] result = nextGreaterElement(new int[] {4, 1, 2}, new int[] {1, 3, 4, 2});
        for (int integer : result) {
            System.out.print(integer + " ");
        }
    }
}
