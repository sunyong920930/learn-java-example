package lean.java.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyong on 2018-08-31.
 * Lock锁可重入
 */
public class LockTest2 {

    private Lock lock = new ReentrantLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();//调用b方法
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        LockTest2 loc = new LockTest2();
        loc.a();
    }
}
