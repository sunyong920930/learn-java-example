package lean.java.example.thread;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by sunyong on 2018-08-31.
 * https://segmentfault.com/a/1190000012645273
 * put  和 take 构成阻塞模式
 */
public class ArrayBlockingQueueTest {

    @Test
    public void main() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        queue.put(1);
        Integer i = queue.take();
        System.out.println(i+"_"+queue.size());
    }

    @Test
    public void test1(){
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        queue.add(1);
        queue.add(2);
        Integer e = queue.poll();
        System.out.println(e+"_"+queue.size());
    }
}
