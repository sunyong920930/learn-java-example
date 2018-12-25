package lean.java.example.xuliehua.externalizable;

import java.io.*;

public class ExternalizableDemo1 {

    public static void main(String[] args) {

        //Write Obj to file
        User1 user = new User1();
        user.setName("start");
        user.setAge(18);
        System.out.println(user);

        try (FileOutputStream fos = new FileOutputStream("tempFile1");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File file = new File("tempFile1");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            User1 user1 = (User1) ois.readObject();
            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
