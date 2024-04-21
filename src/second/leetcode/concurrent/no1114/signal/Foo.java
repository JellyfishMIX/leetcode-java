package second.leetcode.concurrent.no1114.signal;

/**
 * @author shijie.qian
 * @date 2024/4/17 11:43
 */
public class Foo {
    private boolean firstDone = false;
    private boolean secondDone = false;
    private Object signal = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (signal) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstDone = true;
            signal.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (signal) {
            while (!firstDone) {
                signal.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondDone = true;
            signal.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (signal) {
            while (!secondDone) {
                signal.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
