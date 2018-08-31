package lean.java.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by sunyong on 2018-08-31.
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("111正在计算结果...");
                Thread.sleep(1000);
                return 1;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask(callable);
        Thread t1 = new Thread(futureTask);
        t1.start();
        System.out.println("222做点其他的...");
        Integer o = futureTask.get();
        System.out.println(o);

    }
}
