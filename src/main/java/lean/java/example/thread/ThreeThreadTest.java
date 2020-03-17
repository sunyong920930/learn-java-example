package lean.java.example.thread;

/**
 * @author sunyong
 * 2020/3/17 11:30
 * 三个线程一次打印1、2、3
 */
public class ThreeThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(3);
            }
        });

        t1.start();
        t1.join();
        t2.start();

        t2.join();
        t3.start();

    }
}
