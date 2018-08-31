package lean.java.example.thread.ownlock;

/**
 * Created by sunyong on 2018-08-31.
 * 自定义锁实现可重入
 */
public class Demo {
    MyLock lock = new MyLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();

    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.a();
    }
}
