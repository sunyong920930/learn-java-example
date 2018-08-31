package lean.java.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyong on 2018-08-31.
 * 使用Lock锁保证线程安全性
 */
public class LockTest {

    private Integer value = 0;

    Lock lock = new ReentrantLock();

    public Integer getNext() {
        lock.lock();
        value++;
        lock.unlock();
        return value;
    }


    public static void main(String[] args) {

        LockTest l = new LockTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + l.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + l.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + l.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "===" + l.getNext());
                }
            }
        }).start();
    }
}
