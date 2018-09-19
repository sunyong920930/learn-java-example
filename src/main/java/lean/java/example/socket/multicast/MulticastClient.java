package lean.java.example.socket.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by sunyong on 2018-09-18.
 */
@SuppressWarnings("Duplicates")
public class MulticastClient {

    public static void main(String[] args) throws IOException {

        InetAddress group = InetAddress.getByName("224.5.6.7");

        MulticastSocket socket = new MulticastSocket(8888);

        //添加到指定的组里面
        socket.joinGroup(group);

        byte[] bytes = new byte[256];
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            socket.receive(datagramPacket);
            String msg = new String(datagramPacket.getData());
            System.out.println("接收到的数据：" + msg);
        }
    }
}
