package lean.java.example.xuliehua.arraylist;


import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * arrayList 序列化
 * https://mp.weixin.qq.com/s?__biz=MzI3NzE0NjcwMg==&mid=2650120882&idx=1&sn=8e355b5ee3cce0a2d0108edbdf88e606&chksm=f36bbf93c41c3685340d4f658dddec6bcbd5903b5d92875bb06d51a0dfc49ee7326417a0edff&scene=21#wechat_redirect
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("world");
        stringList.add("hollis");
        stringList.add("chuang");
        System.out.println("init StringList" + stringList);

        try {
            FileOutputStream fos = new FileOutputStream("stringlist");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(stringList);
            IOUtils.closeQuietly(oos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("stringlist");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<String> newStringList = (List<String>) ois.readObject();
            IOUtils.closeQuietly(ois);
            if (file.exists()) {
                file.delete();
            }
            System.out.println("new StringList" + newStringList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    outPut
//    init StringList[hello, world, hollis, chuang]
//    new StringList[hello, world, hollis, chuang]
}
