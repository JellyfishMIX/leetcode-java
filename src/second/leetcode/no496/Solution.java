package second.leetcode.no496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author shijie.qian
 * @date 2024/1/2 23:21
 */
public class Solution {
    /**
     * 单调栈
     */
    private Stack<Integer> monotonicStack = new Stack<>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[] {4,1,2};
        int[] nums2 = new int[] {1,3,4,2};
        int[] result = solution.nextGreaterElement(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 不考虑空
        int[] nums2NextBiggerElement = prepareNextBiggerElement(nums2);
        Map<Integer, Integer> element2nextBiggerMap = new HashMap<>();
        int[] resultBiggerElements = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            element2nextBiggerMap.put(nums2[i], nums2NextBiggerElement[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            resultBiggerElements[i] = element2nextBiggerMap.get(nums1[i]);
        }
        return resultBiggerElements;
    }

    /**
     * 计算 nums 中每一个 offset 位置的元素下一个 biggerElement
     */
    private int[] prepareNextBiggerElement(int[] nums) {
        int[] biggerElements = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!monotonicStack.isEmpty() && monotonicStack.peek() <= nums[i]) {
                monotonicStack.pop();
            }
            int nextBiggerElement = monotonicStack.isEmpty() ? -1 : monotonicStack.peek();
            biggerElements[i] = nextBiggerElement;
            monotonicStack.push(nums[i]);
        }
        return biggerElements;
    }
}
