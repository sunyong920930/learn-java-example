package lean.java.example.thread.AwaitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyong on 2018-08-31.
 */
public class ConditionTest {

    private int count;

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public final int MAX_COUNT = 10;

    public void push() {
        lock.lock();
        while (count >= MAX_COUNT) {
            try {
                c1.await();// 等待
                System.out.println(Thread.currentThread().getId() + " push,store stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getId() + " push,store " + count);
        c2.signal();//唤醒c2
        lock.unlock();
    }

    public void take() {
        lock.lock();
        while (count <= 0) {
            try {
                c2.await();
                System.out.println(Thread.currentThread().getId() + " take,store:" + 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getId() + " take,store:" + count);
        c1.signal();//唤醒c1
        lock.unlock();
    }
}
