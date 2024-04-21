package second.leetcode.concurrent.no1114.cas;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author shijie.qian
 * @date 2024/4/17 11:24
 */
public class Foo {
    private AtomicBoolean firstDone = new AtomicBoolean(false);
    private AtomicBoolean secondDone = new AtomicBoolean(false);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstDone.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!firstDone.get()) {
            // cas self-spin
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondDone.set(true);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!secondDone.get()) {
            // cas self-spin
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
