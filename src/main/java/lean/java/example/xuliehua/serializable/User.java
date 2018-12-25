package lean.java.example.xuliehua.serializable;


import java.io.Serializable;

public class User implements Serializable {


    private static final long serialVersionUID = -5138219265063664215L;
    //使用transient 修饰的变量不会被序列化
    private transient String name;

    private static int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
