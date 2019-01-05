package lean.java.example.basic.basic2;

import lombok.Data;

/**
 * Created by sunyong on 2019/1/5.
 */
@Data
public class Teacher extends Person {
    private String name = "tom";

    public Teacher() {
        System.out.println("this is a teacher");
//        super();//编译出错
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
//        System.out.println(this);//编译出错
    }
}
