package lean.java.example.thread;

/**
 * Created by sunyong on 2018-08-31.
 */
@SuppressWarnings("Duplicates")
public class ThreadLocalTest {

    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        }
    };

    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int next = t.getNext();
                    System.out.println(Thread.currentThread().getName() + " " + next);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int next = t.getNext();
                    System.out.println(Thread.currentThread().getName() + " " + next);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int next = t.getNext();
                    System.out.println(Thread.currentThread().getName() + " " + next);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
