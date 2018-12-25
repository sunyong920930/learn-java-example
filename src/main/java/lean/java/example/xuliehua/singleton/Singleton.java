package lean.java.example.xuliehua.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 单例模式 实现Serializable 接口
 */
public class Singleton implements Serializable {

    // volatile 防止指令重排序
    private volatile static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    // 防止序列化破坏单列模式
    private Object readResolve() throws ObjectStreamException {
        return singleton;
    }
}
