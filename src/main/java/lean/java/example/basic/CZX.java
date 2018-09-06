package lean.java.example.basic;

/**
 * Created by sunyong on 2018-09-03.
 */
public class CZX {

    /**
     * 在Java中，==比较的是对象应用，而equals比较的是值。
     * 原因就和Integer中的缓存机制有关。在Java 5中，在Integer的操作上引入了一个新功能来节省内存和提高性能。整型对象通过使用相同的对象引用实现了缓存和重用。
     * 适用于整数值区间-128 至 +127。
     * 只适用于自动装箱。使用构造函数创建对象不适用。
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer i = 127;
        Integer j = 127;
        if (i == j) {
            System.out.println("i 等于 j");
        } else {
            System.out.println("i 不等于 j");
        }

        Integer ii = 300;
        Integer jj = 300;
        if (ii == jj) {
            System.out.println("ii 等于 jj");
        } else {
            System.out.println("ii 不等于 jj");
        }

        //只适用于自动装箱。使用构造函数创建对象不适用。
        Integer a = new Integer("1");
        Integer b = new Integer("1");
        if (a == b) {
            System.out.println("a 等于 b");
        } else {
            System.out.println("a 不等于 b");
        }
    }
}
