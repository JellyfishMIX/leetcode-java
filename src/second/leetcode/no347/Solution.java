package second.leetcode.no347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author shijie.qian
 * @date 2024/4/4 18:45
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyMap.merge(nums[i], 1, Integer::sum);
        }

        // 使用最小堆维护 frequency 前 k
        PriorityQueue<Model> biggestHeap = new PriorityQueue<>((o1, o2) -> o1.getFrequency() - o2.getFrequency());
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            // priorityQueue 长度会自动扩大，因此需要添加元素时手动维护固定大小的最小堆
            int currentIntKey = entry.getKey();
            int currentFrequency = entry.getValue();
            if (biggestHeap.size() < k) {
                biggestHeap.add(new Model(currentIntKey, currentFrequency){});
            } else {
                Model minimum = biggestHeap.peek();
                if (currentFrequency > minimum.getFrequency()) {
                    biggestHeap.poll();
                    biggestHeap.add(new Model(currentIntKey, currentFrequency){});
                }
            }
        }

        int[] result = new int[k];
        int resultIndex = 0;
        while (!biggestHeap.isEmpty()) {
            Model model = biggestHeap.poll();
            result[resultIndex] = model.getIntKey();
            resultIndex++;
        }

        return result;
    }

    public static class Model {
        private int intKey;
        private int frequency;

        public Model(int intKey, int frequency) {
            this.intKey = intKey;
            this.frequency = frequency;
        }

        public int getIntKey() {
            return intKey;
        }

        public int getFrequency() {
            return frequency;
        }
    }
}
