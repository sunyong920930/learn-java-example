package lean.java.example.basic.basic1;

/**
 * Created by sunyong on 2019/1/5.
 */
public class Child extends Person {
    private String grade;

    public static void main(String[] args){
        Person p = new Child();
//        System.out.println(p.name);//编译出错
//        System.out.println(p.age); // 0
    }
}
