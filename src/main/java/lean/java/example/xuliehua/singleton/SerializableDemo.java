package lean.java.example.xuliehua.singleton;

import java.io.*;

/**
 * 通过对Singleton的序列化与反序列化得到的对象是一个新的对象，这就破坏了Singleton的单例性。
 * https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650120643&idx=1&sn=72ffc1018f5fe4451f885be56e972b30&chksm=f36bbce2c41c35f4d18a841b6fcc5688e7ab3d520be46bc72825b16c0d507a31e48f77dcf0fa&scene=21#wechat_redirect
 */
public class SerializableDemo {

    public static void main(String[] args) {
        try {
            Singleton s1 = Singleton.getInstance();
            Singleton s2 = Singleton.getInstance();
            System.out.println(s1 == s2);


            // write obj to file
            FileOutputStream fos = new FileOutputStream("singleton.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s1);
            oos.close();
            fos.close();

            // read obj from file
            File file = new File("singleton.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Singleton s3 = (Singleton) ois.readObject();
            ois.close();
            // 判断是否为同一个对象
            System.out.println(s3 == s1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
