package lean.java.example.xuliehua.serializable;

import java.io.*;

/**
 * holis:Java对象的序列化与反序列化
 * https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650120836&idx=1&sn=c83a980c0871faf607ae613092c69760&chksm=f36bbfa5c41c36b317c103f27b9d99c26aecba52e4bf614bd73dcadc1e4bc5ab8f99fb082eba&scene=21#wechat_redirect
 */
public class Serializable1 {

    public static void main(String[] args) {

        User user = new User();
        user.setName("start");
        user.setAge(18);
        System.out.println(user);

        // write obj to file
        try (FileOutputStream fos = new FileOutputStream("tempFile");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }


        // read obj from file
        File file = new File("tempFile");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            User newUser = (User) ois.readObject();
            System.out.println(newUser);
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    output
//    User{name='start', age=18}
//    User{name='start', age=18}

}
