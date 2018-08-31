package lean.java.example.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sunyong on 2018-08-31.
 * ReentrantReadWriteLock实现ReadWriteLock 内部继承了同步器AQS
 */
public class ReentrantReadWriteLockTest {

    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock rl = rwl.readLock();

    private Lock wl = rwl.writeLock();


    public Object get(String key) {
        rl.lock();
        System.out.println(Thread.currentThread().getName() + " read start..");
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            rl.unlock();
            System.out.println(Thread.currentThread().getName() + " read over..");
        }
    }

    public void put(String key, Object value) {
        wl.lock();
        System.out.println(Thread.currentThread().getName() + " write start..");
        try {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        } finally {
            wl.unlock();
            System.out.println(Thread.currentThread().getName() + " wirte over..");
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockTest r = new ReentrantReadWriteLockTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                r.put("key1", "value1");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                r.put("key2", "value2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + r.get("key1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + r.get("key2"));
            }
        }).start();


    }
}
