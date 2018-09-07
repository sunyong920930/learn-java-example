package lean.java.example.design.patterns.dynamic.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by sunyong on 2018-09-06.
 * 执行者
 */
public class Meipo implements InvocationHandler {

    //被代理对象的引用作为一个成员变量保存下来了
    private PersonDao target;

    public Object getInstance(PersonDao target) {
        this.target = target;
        Class<? extends PersonDao> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("=====");
        Object o = method.invoke(target, args);
        System.out.println("=====");
        return o;
    }
}
