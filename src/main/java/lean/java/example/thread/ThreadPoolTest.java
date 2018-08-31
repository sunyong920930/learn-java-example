package lean.java.example.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunyong on 2018-08-31.
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        //1、ThreadPoolExecutor.AbortPolicy() 中止策略（默认），抛出异常
        //2、ThreadPoolExecutor.DiscardPolicy() 抛弃策略，直接抛弃任务
        //3、ThreadPoolExecutor.DiscardOldestPolicy() 抛弃旧任务策略，先将阻塞队列中的头元素出队抛弃，再尝试提交任务。如果此时阻塞队列使用PriorityBlockingQueue
        //优先级队列，将会导致优先级最高的任务被抛弃，因此不建议将该种策略配合优先级队列使用。

        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 10, TimeUnit.DAYS, new ArrayBlockingQueue<>(10), new
                ThreadPoolExecutor.DiscardOldestPolicy());

        while (true) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
