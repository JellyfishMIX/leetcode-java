package first.no146;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * DIY LinkedHashMap 解法
 * link: https://leetcode-cn.com/problems/lru-cache/
 *
 * @author JellyfishMIX
 * @date 2021/8/14 02:14
 */
public class LRUCache_DIY_LinkedHashMap {
    private class Node {
        private int key;
        private int value;
        // 前驱节点
        private Node pre;
        // 后继节点
        private Node next;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public Node() {

        }
    }

    private Map<Integer, Node> nodeMap;
    /**
     * head.next 头指针，头指针指向的是最近调用的 node
     */
    private Node head;
    /**
     * tail.pre 尾指针，尾指针指向的是最久未调用的 node
     */
    private Node tail;
    private int capacity;
    private int size;

    public LRUCache_DIY_LinkedHashMap(int capacity) {
        // 初始化 nodeMap
        int mapCapacity = (int) (capacity / 0.8);
        nodeMap = new HashMap<>(mapCapacity);
        this.capacity = capacity;
        // 头指针，尾指针初始化
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * O(1) 时间复杂度
     *
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    /**
     * O(1) 时间复杂度
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node == null) {
            if (size < capacity) {
                size++;
                Node newNode = new Node(key, value, null, null);
                firstAdd(newNode);
                nodeMap.put(key, newNode);
            } else {
                Node newNode = new Node(key, value, null, null);
                nodeMap.remove(tail.pre.key);
                nodeMap.put(key, newNode);
                removeTail();
                firstAdd(newNode);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 在头部 add
     *
     * @param node
     */
    private void firstAdd(Node node) {
        backAdd(head, node);
    }

    private void moveToHead(Node node) {
        removeNode(node);
        backAdd(head, node);
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeTail() {
        removeNode(tail.pre);
    }

    /**
     * 在 a node 后面增加 b node
     */
    private void backAdd(Node a, Node b) {
        b.next = a.next;
        a.next.pre = b;
        b.pre = a;
        a.next = b;
    }
}
