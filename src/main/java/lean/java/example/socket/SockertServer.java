package lean.java.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sunyong on 2018-09-18.
 */
public class SockertServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            // 启动一个服务
            serverSocket = new ServerSocket(8888);
            while (true) {
                // 等待接收一个服务 这一步是阻塞状态
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    try {
                        // 读取数据
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                        while (true) {
                            // 读取客户端发送过来的数据
                            String clinetData = reader.readLine();
                            if (clinetData == null) {
                                break;
                            }
                            System.out.println("服务端接收到的数据:" + clinetData);
                            writer.println("客户端");
                            writer.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
