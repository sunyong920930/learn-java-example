package lean.java.example.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by sunyong on 2018-08-31.
 */
public class ListTest {
    
    public static void main(String[] args){
        List<User> list = new ArrayList<>();
        list.add(new User("1", "1"));
        list.add(null);
        list.add(new User("1", "3"));
        list.forEach(user -> {
            //System.out.println(user);
        });
        // 去处集合中空的对象并返回去除后的集合
        //List<User> users = list.stream().limit(list.size()).filter(Objects::nonNull).collect(Collectors.toList());
        //System.out.println(users.size());
        // 集合中的第一个对象
        //Optional<User> user = list.stream().findFirst();
        //System.out.println("user: " + user);
        //List<User> users = list.stream().filter(Objects::nonNull).filter(u -> "1".equals(u.getName())).collect
        //        (Collectors.toList());
        //users.forEach(user -> {
        //    System.out.println(user);
        //});
        List<String> strings = list.stream().filter(Objects::nonNull).map(User::getName).collect(Collectors.toList());
        strings.forEach(s -> {
            System.out.println(s);
        });
    }
}
