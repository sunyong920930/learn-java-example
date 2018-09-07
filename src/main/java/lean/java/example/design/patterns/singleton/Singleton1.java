package lean.java.example.design.patterns.singleton;

/**
 * Created by sunyong on 2018-09-06.
 * 懒汉式（静态内部类）
 * 这种写法，即解决安全问题，又解决了性能问题
 * 这个代码，没有浪费一个字
 */
public class Singleton1 {

    //1、先声明一个静态内部类
    //private 私有的保证别人不能修改
    //static 保证全局唯一
    private static class LazyHolder {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    //2、将默认构造方法私有化
    private Singleton1() {
    }
    //相当于有一个默认的public的无参的构造方法，就意味着在代码中随时都可以new出来

    //3、同样提供静态方法获取实例
    //final 确保别人不能覆盖

    public static Singleton1 getInstance() {
        //方法中的逻辑，是要在用户调用的时候才开始执行的
        //方法中实现逻辑需要分配内存，也是调用时才分配的
        return LazyHolder.INSTANCE;
    }
}
