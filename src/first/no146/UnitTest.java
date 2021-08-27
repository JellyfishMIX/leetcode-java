package first.no146;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author JellyfishMIX
 * @date 2021/8/12 13:28
 */
public class UnitTest {
    @Test
    public void test0() {
        LRUCache_LinkedList lruCacheLinkedList = new LRUCache_LinkedList(2);
        lruCacheLinkedList.put(1, 0);
        lruCacheLinkedList.put(2, 2);
        Assert.assertEquals(lruCacheLinkedList.get(1), 0);
        lruCacheLinkedList.put(3, 3);
        Assert.assertEquals(lruCacheLinkedList.get(2), -1);
        lruCacheLinkedList.put(4, 4);
        Assert.assertEquals(lruCacheLinkedList.get(1), -1);
        Assert.assertEquals(lruCacheLinkedList.get(3), 3);
        Assert.assertEquals(lruCacheLinkedList.get(4), 4);
    }

    @Test
    public void test1() {
        LRUCache_LinkedList lruCacheLinkedList = new LRUCache_LinkedList(2);
        lruCacheLinkedList.put(2, 1);
        lruCacheLinkedList.put(2, 2);
        Assert.assertEquals(lruCacheLinkedList.get(2), 2);
        lruCacheLinkedList.put(1, 1);
        lruCacheLinkedList.put(4, 1);
        Assert.assertEquals(lruCacheLinkedList.get(2), -1);
    }

    @Test
    public void test2() {
        LRUCache_LinkedList lruCacheLinkedList = new LRUCache_LinkedList(2);
        Assert.assertEquals(lruCacheLinkedList.get(2), -1);
        lruCacheLinkedList.put(2, 6);
        Assert.assertEquals(lruCacheLinkedList.get(1), -1);
        lruCacheLinkedList.put(1, 5);
        lruCacheLinkedList.put(1, 2);
        Assert.assertEquals(lruCacheLinkedList.get(1), 2);
        Assert.assertEquals(lruCacheLinkedList.get(2), 6);
    }
}
