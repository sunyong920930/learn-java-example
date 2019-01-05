package lean.java.example.basic.basic5;

/**
 * Created by sunyong on 2019/1/5.
 */
public class Demo {

    public int add(int a, int b) {
        try {
//            int i = 1 /0; //catch 语句块 finally 语句块  和是：0
            return a + b;
        } catch (Exception e) {
            System.out.println("catch 语句块");
        } finally {
            System.out.println("finally 语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("和是：" + demo.add(9, 35)); //"finally 语句块" 和是：44
    }
}
