package lean.java.example.thread;

import org.springframework.util.StringUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by sunyong on 2018-08-31.
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("111正在计算结果...");
                Thread.sleep(1000);
                return 1;
            }
        };

        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "123";
            }
        };
        FutureTask<Integer> futureTask = new FutureTask(callable);
        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        Thread t1 = new Thread(futureTask);
        Thread t2 = new Thread(futureTask1);
        t1.start();
        t2.start();
        System.out.println("222做点其他的...");
        Integer o = null;
        String s = null;

        while (System.currentTimeMillis() - startTime < 18000){
            if(futureTask.isDone()){
                o = futureTask.get();
                System.out.println(o+"=========");
            }

            if(futureTask1.isDone()){
                s = futureTask1.get();
                System.out.println(s+"------------");
            }

            if(!StringUtils.isEmpty(o) || !StringUtils.isEmpty(s)){
                break;
            }
        }
    }
}
