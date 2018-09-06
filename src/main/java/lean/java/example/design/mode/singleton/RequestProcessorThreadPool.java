package lean.java.example.design.mode.singleton;

/**
 * Created by sunyong on 2018-09-06.
 */
public class RequestProcessorThreadPool {


    /**
     * 单例有很多种方式去实现：我采取绝对线程安全的一种方式
     * <p>
     * 静态内部类的方式，去初始化单例
     */
    private static class Singleton {

        private static RequestProcessorThreadPool instance;

        static {
            instance = new RequestProcessorThreadPool();
        }

        public static RequestProcessorThreadPool getInstance() {
            return instance;
        }
    }


    /**
     * jvm的机制去保证多线程并发安全
     * <p>
     * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
     *
     * @return
     */
    public static RequestProcessorThreadPool getInstance() {
        return Singleton.getInstance();
    }

    /**
     * 初始化便捷方法
     */
    public void init() {
        RequestProcessorThreadPool.getInstance();
    }
}
