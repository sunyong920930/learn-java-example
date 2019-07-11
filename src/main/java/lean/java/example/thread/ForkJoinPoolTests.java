package lean.java.example.thread;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * https://mp.weixin.qq.com/s?__biz=MzI2OTQ4OTQ1NQ==&mid=2247486492&idx=1&sn=2f41854a5287548524c4bef9e9b9719d&chksm=eadec85cdda9414a98d157bb083078e194318d01cc0d48370803cc694891bf7c8d9059198e69&mpshare=1&scene=24&srcid=#rd
 */
public class ForkJoinPoolTests {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        final ExecutorService pool = Executors.newFixedThreadPool(10);
        final ExecutorService pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        List<Integer> list = Lists.newArrayList(1, 2, 3, null);

        //1.使用submit  异常没有抛出来
        pool.submit(() -> {
            list.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        });
        TimeUnit.SECONDS.sleep(3);

        //2.使用 execute
        pool.execute(() -> {
            list.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        });

        //3.使用submit，调用get()  抛出异常
        pool.submit(() -> {
            list.parallelStream().map(a -> a.toString()).collect(Collectors.toList());
        }).get();
        TimeUnit.SECONDS.sleep(3);

//        pool.shutdown();
    }
}
