package lean.java.example.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by sunyong on 2018-09-18.
 * 客户端
 */
public class SocketClint {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 8888);
            // 从客户端读取数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 往服务端写数据
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("hello");
            while (true) {
                String serverData = reader.readLine();
                if (serverData == null) {
                    break;
                }
                System.out.println("客户端接收到数据：" + serverData);
            }
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
