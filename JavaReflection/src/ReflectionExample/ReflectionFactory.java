package ReflectionExample;

import javax.swing.*;

interface IMessage{
    public void send();
}
interface IService{
    public void service();
}
class NetMessage implements IMessage{
    @Override
    public void send() {
        System.out.println("【消息发送】我是网络binZi");
    }
}
class CloudMessage implements IMessage{
    @Override
    public void send() {
        System.out.println("【消息发送】我是云端binZi");
    }
}
class HouseService implements IService{
    @Override
    public void service() {
        System.out.println("【InnHome竭诚为您服务】");
    }
}
class Factory{
    private Factory(){}
    /*
    * 获取接口实例化对象
    * @param className接口的子类
    * @param clazz 描述的是一个接口类型
    * @return 如果资料欸存在则返回指定接口实例化对象
    * */
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(String className,Class<T> clazz) throws Exception {
        T instance = null;
        instance = (T) Class.forName(className).newInstance();
        return instance;
    }
}
public class ReflectionFactory {
    public static void main(String [] args) throws Exception {
        //IMessage msg = new NetMessage();//如果直接实例化则一定会有耦合问题，
        IMessage msg = Factory.getInstance("ReflectionExample.CloudMessage",IMessage.class);
        msg.send();
    }
}
