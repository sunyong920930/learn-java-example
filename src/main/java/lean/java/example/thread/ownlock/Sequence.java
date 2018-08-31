package lean.java.example.thread.ownlock;

/**
 * Created by sunyong on 2018-08-31.
 * 使用自定义锁保证线程安全性
 */
public class Sequence {
    private int value = 0;

    MyLock l = new MyLock();

    public int getNext() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        l.lock();
        try {
            value++;
            return value;
        } finally {
            l.unlock();
        }
    }

    public static void main(String[] args) {

        Sequence s = new Sequence();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + s.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + s.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + s.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "  " + s.getNext());
                }
            }
        }).start();
    }
}
