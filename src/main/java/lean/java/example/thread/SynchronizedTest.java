package lean.java.example.thread;

/**
 * Created by sunyong on 2018-08-31.
 * synchronized锁可重入
 */
public class SynchronizedTest {

    public synchronized void a() {
        System.out.println("a");
        b();
    }

    public synchronized void b() {
        System.out.println("b");
    }

    public static void main(String[] args) {
        SynchronizedTest s = new SynchronizedTest();
        s.a();
    }
}
