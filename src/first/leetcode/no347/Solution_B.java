package first.leetcode.no347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Simplified code of Solution using the anonymous inner class
 *
 * @author JellyfishMIX
 * @date 2020/9/24 22:46
 */
public class Solution_B {
    public int[] topKFrequent(int[] nums, int k) {
        // Map is used to count the corresponding frequency of elements.
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        // PriorityQueue(MinHeap). Use anonymous inner class to simplify code.
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>(new Comparator<Freq>() {
            @Override
            public int compare(Freq o1, Freq o2) {
                return o1.freq - o2.freq;
            }
        });

        for (Integer key : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Freq(key, hashMap.get(key)));
            } else if (hashMap.get(key) > priorityQueue.peek().freq) {
                priorityQueue.remove();
                priorityQueue.add(new Freq(key, hashMap.get(key)));
            }
        }

        // Assemble the returned data.
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            linkedList.add(priorityQueue.remove().e);
        }
        return linkedList.stream().mapToInt(Integer::intValue).toArray();
    }

    private class Freq {
        /**
         * element
         */
        int e;
        /**
         * frequency of occurrence
         */
        int freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }
    }
}
