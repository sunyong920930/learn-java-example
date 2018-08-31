package lean.java.example.thread.ownlock;

/**
 * Created by sunyong on 2018-08-31.
 * 线程不安全的
 */
public class Sequence2 {

    private int value = 0;

    public int getNext() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
        return value++;
    }

    public static void main(String[] args) {

        Sequence2 s = new Sequence2();

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
