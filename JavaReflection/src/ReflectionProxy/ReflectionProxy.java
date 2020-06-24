package ReflectionProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessage{
    public void send();
}

class MessageReal implements IMessage {
    @Override
    public void send(){
        System.out.println("BinZi");
    }
}

/*class MessageProxy implements IMessage{
    private IMessage message;
    public MessageProxy(IMessage message){
        this.message = message;
    }
    public boolean connect(){
        System.out.println("消息代理，连接");
        return true;
    }
    public void close(){
        System.out.println("消息代理，关闭");
    }
    @Override
    public void send() {
        if(this.connect()){
            this.message.send();
            this.close();
        }
    }
}*/

class MLDNProxy implements InvocationHandler {
    private Object target;//保存真实业务对象

    /**
     * 进行真实业务对象与代理业务对象之间的banding处理
     * @param target 真实业务对象
     * @return Proxy 生成的代理业务对象
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object pro, Method method, Object[] args) throws Throwable {
        System.out.println("*******【执行方法：】" + method);
        Object returnData = null;
        if(this.connect()){
            returnData = method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }
    public boolean connect(){
        System.out.println("消息代理，连接");
        return true;
    }
    public void close(){
        System.out.println("消息代理，关闭");
    }
}

public class ReflectionProxy {
    public static void main(String [] args){
        IMessage iMessage = (IMessage) new MLDNProxy().bind(new MessageReal());
        iMessage.send();
    }
}
