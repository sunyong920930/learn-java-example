package lean.java.example.reflect.reflect8;


import java.lang.reflect.Field;

/**
 * Created by sunyong on 2018-09-14.
 */
public class TestAnnotation {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {

        Class<?> clazz = Class.forName("lean.java.example.reflect.reflect8.StudentController");
        Field[] fields = clazz.getDeclaredFields();// 拿到公有的、私有的
        for (Field field : fields) {
            //获取属性上的注解
            Autowired autowired = field.getAnnotation(Autowired.class);
            String trim = autowired.value().trim();
            System.out.println(trim);
        }

    }
}
