import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class JavaUDPServer {
    public static void main(String[] args)throws Exception {
        DatagramSocket server = new DatagramSocket(9000);
        String str = "BinZi";//要发送的消息的内容
        DatagramPacket packet = new DatagramPacket(str.getBytes(),
                0,str.length(), InetAddress.getByName("localhost"),9999);//发送数据
        server.send(packet);
        System.out.println("消息发送完毕");
        server.close();
    }
}
