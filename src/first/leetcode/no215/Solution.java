package first.leetcode.no215;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * link: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 最小堆解法
 *
 * @author JellyfishMIX
 * @date 2021/8/14 09:59
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 使用一个含有 k 个元素的最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }
        // 堆中仅存储最大的 k 个元素
        for (int i = k; i < nums.length; i++) {
            // 先 peek 一下，不 poll，因为不一定会替换堆顶
            Integer top = minHeap.peek();
            // 如果比堆顶大，则替换堆顶
            if (nums[i] > top) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        // 由于是最小堆，所以堆顶就是第 k 大个元素
        return minHeap.peek();
    }
}
