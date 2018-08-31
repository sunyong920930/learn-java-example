package lean.java.example.jdk8;

/**
 * Created by sunyong on 2018-08-31.
 */
public class RunnableTest {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " #1234");
        });

        t.start();
        System.out.println(Thread.currentThread().getName() + " ##5678");
    }
}
