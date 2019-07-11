package lean.java.example.thread;

import java.util.concurrent.*;

public class ForkJoinPoolTests2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        final ExecutorService pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        pool.submit(()->{

            System.out.println(111);
        });

        pool.execute(()->{
            System.out.println(222);
        });

        Integer str = pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 222222;
            }
        }).get();

        System.out.println(str);
        TimeUnit.SECONDS.sleep(3);
    }
}
