package lean.java.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExceptionTests {

    public static void main(String[] args){

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {

                int i = 1 / 0;

                return "success";
            }
        };

        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        try {
            String get = futureTask.get();
            System.out.println(get+"===");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
