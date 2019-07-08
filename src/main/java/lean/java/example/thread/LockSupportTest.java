package lean.java.example.thread;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                LockSupport.park();
                System.out.println("thread:"+Thread.currentThread().getId()+" awake!");
            }
        });
        t.start();
        Thread.sleep(3000);
//        t.interrupt();
        LockSupport.unpark(t);
    }
}
