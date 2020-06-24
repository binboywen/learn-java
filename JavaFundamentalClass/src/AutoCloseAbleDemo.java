interface IMessage {
    public void send(); //消息发送
}
class NetMessage implements IMessage,AutoCloseable{ //实现消息的处理机制
    private String msg;
     NetMessage(String msg){
        this.msg = msg;
    }
    @Override
    public void send(){//获取资源链接
        System.out.println("【****发送消息****】" + this.msg);
    }
     boolean open(){
        System.out.println("【OPEN】获取消息发送链接资源");
        return true;
    }
    public void close() throws Exception{
        System.out.println("【CLOSE】关闭消息发送通道");
    }

}
public class AutoCloseAbleDemo {
    public static void main(String [] args) throws Exception {
        try (NetMessage nm = new NetMessage("bin zi")){
            if(nm.open()){
                nm.send();
            }
        }catch(Exception e){e.printStackTrace();}
        Runtime e;
    }
}
