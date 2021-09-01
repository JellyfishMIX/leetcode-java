package first.leetcode.no347;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * On the basis of Solution_C, replace inner class to lambda expression.
 *
 * @author JellyfishMIX
 * @date 2020/9/24 23:35
 */
public class Solution_D {
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

        // PriorityQueue(MinHeap). Use lambda expression to simplify code. Generic<Integer> represents the key.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> hashMap.get(o1) - hashMap.get(o2)
        );

        for (Integer key : hashMap.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (hashMap.get(key) > hashMap.get(priorityQueue.peek())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        // Assemble the returned data.
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            linkedList.add(priorityQueue.remove());
        }
        return linkedList.stream().mapToInt(Integer::intValue).toArray();
    }
}
