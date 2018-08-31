package lean.java.example.thread;

/**
 * Created by sunyong on 2018-08-31.
 * 使用synchronized保证线程安全性
 */
public class SynchronizedTest2 {

    private int value = 0;

    public synchronized int getNext() {
        return value++;
    }

    public static void main(String[] args) {
        SynchronizedTest2 s = new SynchronizedTest2();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "==" + s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "==" + s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "==" + s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + "==" + s.getNext());
                }
            }
        }).start();
    }
}
