package lean.java.example.reflect.reflect3;

/**
 * Created by sunyong on 2018-09-14.
 */
public class Student {

    public Student() {

    }

    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }

}
