package first.no146;

import java.util.LinkedList;
import java.util.List;

/**
 * 146. LRU 缓存机制
 * LinkedList 解法，timeout
 * link: https://leetcode-cn.com/problems/lru-cache/
 *
 * @author JellyfishMIX
 * @date 2021/8/10 19:38
 */
public class LRUCache_LinkedList {
    private class Element {
        int key;
        int value;
        long invokeTime;

        public Element(int key, int value, long invokeTime) {
            this.key = key;
            this.value = value;
            this.invokeTime = invokeTime;
        }
    }

    private List<Element> list;
    // 容量
    private int capacity;

    public LRUCache_LinkedList(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
    }

    public LRUCache_LinkedList() {
    }

    public int get(int key) {
        for (Element element : list) {
            if (element.key == key) {
                // 更新调用时间
                element.invokeTime = System.nanoTime();
                return element.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        // 调用时间
        long now = System.nanoTime();
        // 相同的 key 覆盖
        for (Element element : list) {
            if (element.key == key) {
                element.value = value;
                element.invokeTime = System.nanoTime();
                return;
            }
        }
        // 如未找到相同的 key
        if (list.size() < capacity) {
            list.add(new Element(key, value, now));
            // 寻找最久未使用的元素，置换出去
        } else {
            long earliestInvokeTime = Long.MAX_VALUE;
            int earliestIndex = -1;
            int index = 0;
            for (Element element : list) {
                if (element.invokeTime < earliestInvokeTime) {
                    earliestInvokeTime = element.invokeTime;
                    earliestIndex = index;
                }
                // 索引++;
                index++;
            }
            // 置换掉最久未使用的元素
            list.remove(earliestIndex);
            // 放入新的元素
            list.add(new Element(key, value, now));
        }
    }
}
