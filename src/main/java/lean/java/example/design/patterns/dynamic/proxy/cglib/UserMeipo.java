package lean.java.example.design.patterns.dynamic.proxy.cglib;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by sunyong on 2018-09-06.
 */
public class UserMeipo implements MethodInterceptor {
    //好像并没有持有被代理的对象
    public Object getInstance(Class clazz) {
        Enhancer enhancer = new Enhancer();
        // 把父类设置为谁，这一步就是告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(clazz);
        // 设置回调， 指向intercept
        enhancer.setCallback(this);
        //第一步:生成源代码
        //第二步:编译成class文件
        //第三步:加载到jvm中，并返回被代理对象
        return enhancer.create();
    }
    // 同样是做了字节码重组这样一件事
    // 对于使用api的用户来说，是无感知的
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("==========");
        //这个obj的引用是由CGLib给我们new出来的
        //cglib new出来以后的对象，是被代理对象的子类（继承了我们自己写的那个类）
        //OOP, 在new子类之前，实际上默认先调用了我们super()方法的，
        //new了子类的同时，必须先new出来父类，这就相当于是间接的持有了我们父类的引用
        //子类重写了父类的所有的方法
        //我们改变子类对象的某些属性，是可以间接的操作父类的属性的
        Object o = methodProxy.invokeSuper(obj, args);
        System.out.println(method.getName());
        System.out.println("==========");
        return o;
    }
}
