package PipedStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class SendThread implements Runnable{
    private PipedOutputStream output;
    public SendThread(){
        this.output = new PipedOutputStream();//实例化管道输出流
    }
    @Override
    public void run() {
        for (int x = 0; x < 10; x++){
            try {
                this.output.write(("【第" + (x+1) + "次信息发送 - "+ Thread.currentThread().getName()+ "】我是饼子！\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            this.output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PipedOutputStream getOutput() {
        return this.output;
    }
}
class ReceiveThread implements Runnable{
    private PipedInputStream input;
    public ReceiveThread(){
        this.input = new PipedInputStream();
    }
    @Override
    public void run() {
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] data = new byte [1024];
        try {
            while((len = this.input.read(data)) != -1){
                bos.write(data,0,len);//所有的数据保存在内存流里面
            }
            System.out.println("【信息接收 - "+ Thread.currentThread().getName()+ "】" + new String(bos.toByteArray()));
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public PipedInputStream getInput() {
        return input;
    }
}
public class PipedStream {
    public static void main(String [] args) throws IOException {
        SendThread send = new SendThread();
        ReceiveThread receive = new ReceiveThread();
        send.getOutput().connect(receive.getInput());
        new Thread(send,"消息发送线程").start();
        new Thread(receive,"消息接收线程").start();
    }
}
