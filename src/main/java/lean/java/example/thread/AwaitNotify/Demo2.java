package lean.java.example.thread.AwaitNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyong on 2018-08-31.
 * 使用Condition使线程顺序执行
 */
public class Demo2 {
    private int signal;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void a() {
        lock.lock();
        while (signal != 0) {
            try {
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        System.out.println("a");
        c2.signal();// 唤醒c2
        lock.unlock();
    }

    public void b() {
        lock.lock();
        while (signal != 1) {
            try {
                c2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        System.out.println("b");
        c3.signal();// 唤醒c3
        lock.unlock();
    }

    public void c() {
        lock.lock();
        while (signal != 2) {
            try {
                c3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal = 0;
        System.out.println("c");
        c1.signal();//唤醒c1
        lock.unlock();
    }

    public static void main(String[] args) {

        Demo2 demo = new Demo2();
        AA aa = new AA(demo);
        BB bb = new BB(demo);
        CC cc = new CC(demo);

        new Thread(aa).start();
        new Thread(bb).start();
        new Thread(cc).start();

    }
}

class AA implements Runnable {

    private Demo2 demo;

    public AA(Demo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.a();
        }
    }
}

class BB implements Runnable {

    private Demo2 demo;

    public BB(Demo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.b();
        }
    }
}

class CC implements Runnable {

    private Demo2 demo;

    public CC(Demo2 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.c();
        }
    }
}
