package second.leetcode.no146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shijie.qian
 * @date 2024/4/27 23:53
 */
public class LRUCache {
    private Map<Integer, Node> nodeMap;

    private Node headPointer;

    private Node tailPointer;

    private int size = 0;

    private int capacity = 0;

    private class Node {
        private int key;
        private int value;
        private Node pre;
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

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>(capacity);
        this.capacity = capacity;
        headPointer = new Node();
        tailPointer = new Node();
        headPointer.next = tailPointer;
        tailPointer.pre = headPointer;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node existNode = nodeMap.get(key);
        if (existNode == null) {
            if (size < capacity) {
                Node newNode = new Node(key, value, null, null);
                addAfterWithMap(headPointer, newNode);
                size++;
            } else {
                removeNodeWithMap(tailPointer.pre);
                Node newNode = new Node(key, value, null, null);
                addAfterWithMap(headPointer, newNode);
            }
        } else {
            existNode.value = value;
            move2Head(existNode);
        }
    }

    private void move2Head(Node node) {
        removeNode(node);
        addAfter(headPointer, node);
    }

    private void removeNode(Node node) {
        // 有 haedPointer 和 tailPointer, 此处不会空指针
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeNodeWithMap(Node node) {
        nodeMap.remove(node.key);
        removeNode(node);
    }

    private void addAfter(Node benchmark, Node node) {
        node.next = benchmark.next;
        node.pre = benchmark;
        benchmark.next.pre = node;
        benchmark.next = node;
    }

    private void addAfterWithMap(Node benchmark, Node node) {
        nodeMap.put(node.key, node);
        addAfter(benchmark, node);
    }
}
