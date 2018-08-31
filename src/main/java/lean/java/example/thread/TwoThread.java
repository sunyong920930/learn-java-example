package lean.java.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyong on 2018-08-31.
 * 两个线程交替打印 1---100
 */
public class TwoThread {

    private int start;
    private boolean flag = true;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        TwoThread twoThread = new TwoThread();

        Thread t1 = new Thread(new OuNum(twoThread));
        t1.start();

        Thread t2 = new Thread(new JiNum(twoThread));
        t2.start();
    }


    public static class OuNum implements Runnable {

        private TwoThread twoThread;

        public OuNum(TwoThread twoThread) {
            this.twoThread = twoThread;
        }

        @Override
        public void run() {
            while (twoThread.start <= 100) {
                if (!twoThread.flag) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + twoThread.start);
                        twoThread.start++;
                        twoThread.flag = true;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    try {
                        //防止线程空转
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class JiNum implements Runnable {

        private TwoThread twoThread;

        public JiNum(TwoThread twoThread) {
            this.twoThread = twoThread;
        }

        @Override
        public void run() {
            while (twoThread.start <= 100) {
                if (twoThread.flag) {
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName() + "+-+" + twoThread.start);
                        twoThread.start++;
                        twoThread.flag = false;
                    } finally {
                        lock.unlock();
                    }
                } else {
                    try {
                        //防止线程空转
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
