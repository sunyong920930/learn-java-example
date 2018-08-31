package lean.java.example.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by sunyong on 2018-08-31.
 */
public class TwoThread2 {

    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();

    private int start = 1;

    public static void main(String[] args) {
        TwoThread2 number = new TwoThread2();
        Thread t1 = new Thread(new OuNum(number));
        t1.start();

        Thread t2 = new Thread(new JiNum(number));
        t2.start();
    }

    public static class JiNum implements Runnable {

        private TwoThread2 number;

        public JiNum(TwoThread2 number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                try {
                    lock.lock();
                    if (number.start % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " " + number.start);
                        number.start++;
                        c2.signal();
                    } else {
                        try {
                            c1.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static class OuNum implements Runnable {

        private TwoThread2 number;

        public OuNum(TwoThread2 number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                try {
                    lock.lock();
                    if (number.start % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " " + number.start);
                        number.start++;
                        c1.signal();
                    } else {
                        try {
                            c2.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
