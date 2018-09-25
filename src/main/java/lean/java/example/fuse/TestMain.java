package lean.java.example.fuse;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by sunyong on 2018-09-25.
 * 熔断器
 * 来源：https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650122130&idx=1&sn=fb3e88c48f607c83e91cc3f550c7f205
 * &chksm=f36bbab3c41c33a51439b33be7edf11ee1d25dbd8fda3bc2d02581008addb34d433a48e90a6e&mpshare=1&scene=1&srcid
 * =0925vRrJfDUtQsfpcDgPr2AX#rd
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        final int maxNum = 200;
        final CountDownLatch countDownLatch = new CountDownLatch(maxNum);

        final CircuitBreaker circuitBreaker = new LocalCircuitBreaker("5/20", 10, "5/10", 2);

        for (int i = 0; i < maxNum; i++) {
            new Thread(new Runnable() {
                public void run() {
                    // 模拟随机请求
                    try {
                        Thread.sleep(new Random().nextInt(20) * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        // 过熔断器
                        if (circuitBreaker.canPassCheck()) {
                            // do something
                            System.out.println("正常业务逻辑操作");

                            // 模拟后期的服务恢复状态
                            if (countDownLatch.getCount() >= maxNum / 2) {
                                // 模拟随机失败
                                if (new Random().nextInt(2) == 1) {
                                    throw new Exception("mock error");
                                }
                            }
                        } else {
                            System.out.println("拦截业务逻辑操作");
                        }
                    } catch (Exception e) {
                        System.out.println("业务执行失败了");
                        // 熔断器计数器
                        circuitBreaker.countFailNum();
                    }

                    countDownLatch.countDown();
                }
            }).start();

            // 模拟随机请求
            try {
                Thread.sleep(new Random().nextInt(5) * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        countDownLatch.await();
        System.out.println("end");
    }
}
