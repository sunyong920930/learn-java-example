package lean.java.example.design.mode.dynamic.proxy.jdk;


/**
 * Created by sunyong on 2018-09-06.
 * jdk动态代理：
 * 1、执行者，被代理对象
 * 2、注重过程， 必须要做，被代理对象没时间去做或者不想做
 * 3、执行者必须拿到被代理对象的个人资料（执行者持有被代理对象的引用）
 */
public class TestJDKProxy {

    public static void main(String[] args) {
        Meipo meipo = new Meipo();
        PersonDao o = (PersonDao) meipo.getInstance(new PersonDaoImpl());
        o.findLove();
    }
}
