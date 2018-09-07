package lean.java.example.design.patterns.singleton;

/**
 * Created by sunyong on 2018-09-06.
 */
public class Singleton2 {

    // 使用volatile 防止指令重排序
    private static volatile Singleton2 INSTANCE = null;

    private Singleton2() {
    }

    // 双重synchronized
    public synchronized static Singleton2 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) {
                    return new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}
