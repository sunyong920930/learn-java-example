package lean.java.example.thread.ownlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by sunyong on 2018-08-31.
 * 自定义锁
 */
public class MyLock implements Lock {


    private boolean isLock = false;

    private Thread lockBy = null;

    private int lockCount = 0;

    /**
     * 加锁
     */
    @Override
    public synchronized void lock() {
        Thread thread = Thread.currentThread();
        while (isLock && lockBy != thread) {
            try {
                wait();//使线程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
        lockBy = thread;
        lockCount++;
    }

    /**
     * 释放锁
     */
    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0) {
                notify();
                isLock = false;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
