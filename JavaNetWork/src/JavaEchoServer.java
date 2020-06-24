import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class JavaEchoServer {
    private static class ClientThread implements Runnable{
        private Socket client = null;
        private Scanner scanner = null;
        private PrintStream out = null;
        private boolean flag = true;
        public ClientThread(Socket client) throws Exception{
            this.client = client;
            this.scanner = new Scanner(client.getInputStream());//客户端输入流
            this.scanner.useDelimiter("\n");
            this.out = new PrintStream(client.getOutputStream());//客户端输出流
        }
        @Override
        public void run() {
            while(this.flag) {
                if (this.scanner.hasNext()) {
                    String val = this.scanner.next().trim();
                    if ("exit".equals(val)) {
                        out.println("you are off line now!");
                        this.flag = false;
                    } else {
                        out.println("[ECHO]" + val);
                    }
                }
            }
            try {
                scanner.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String [] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
        System.out.println("等待客户端连接！");
        //首先需要先接受客户端发送来的消息，而后才可将信息处理之后发送会客户端
        boolean flag = true;
        while(flag){
            Socket client = server.accept();//有客户端连接
            new Thread(new ClientThread(client)).start();
        }
        server.close();


    }
}
