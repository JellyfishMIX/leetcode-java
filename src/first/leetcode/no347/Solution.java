package first.leetcode.no347;

import java.util.*;

/**
 * @author JellyfishMIX
 * @date 2020/9/24 17:40
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Map用于统计元素对应频次
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }
        
        // 优先队列（最小堆）
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (Integer key : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Freq(key, hashMap.get(key)));
            } else if (hashMap.get(key) > priorityQueue.peek().freq) {
                priorityQueue.remove();
                priorityQueue.add(new Freq(key, hashMap.get(key)));
            }
        }

        // 组装返回结果
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            linkedList.add(priorityQueue.remove().e);
        }
        return linkedList.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Freq implements Comparable<Freq> {
        /**
         * 元素e
         */
        int e;
        /**
         * 出现的频次
         */
        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq anotherFreq) {
            if (this.freq < anotherFreq.freq) {
                return -1;
            } else if (this.freq > anotherFreq.freq) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
