package lean.java.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sunyong on 2018-08-31.
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        queue.put(1);
        Integer i = queue.take();
        System.out.println(i);

    }
}
