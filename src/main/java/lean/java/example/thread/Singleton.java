package lean.java.example.thread;

/**
 * Created by sunyong on 2018-08-31.
 * 懒加载
 */
public class Singleton {

    private volatile Singleton singleton;

    private Singleton() {

    }

    public Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();// 会出现指令重排序所以singleton用volatile修饰
                }
            }
        }
        return singleton;
    }
}
