package lean.java.example.thread.AwaitNotify;

/**
 * Created by sunyong on 2018-08-31.
 */
public class AwaitNotifyTest {

    private volatile int signal;

    public void set() {
        signal = 1;
    }

    public int get() {
        return signal;
    }

    public static void main(String[] args) {
        AwaitNotifyTest d = new AwaitNotifyTest();

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                System.out.println(Thread.currentThread().getName() + " " + "set start");
                d.set();
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " " + "set end");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                while (d.get() != 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + d.get());
            }
        }).start();


    }
}
