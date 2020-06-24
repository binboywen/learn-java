package ReflectionAndAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface IMessageT{
    public void send(String msg);
}
class MessageTImpl implements IMessageT{
    @Override
    public void send(String msg) {
        System.out.println("【消息发送】"+msg);
    }
}
class Factory{
    private Factory(){}
    public static <T> T getInstance(Class<T> clazz) throws Exception {
        return (T) new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
    }
}
class MessageProxy implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    public boolean connect(){
        System.out.println("【代理操作】连接操作");
        return true;
    }
    public void close(){
        System.out.println("【代理操作】关闭操作");
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            if(this.connect()) {
                return method.invoke(this.target, args);
            }else{
                throw new Exception("消息无法发送");
            }
        }finally{
            this.close();
        }
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
    public Class<?> clazz();
}
@UseMessage(clazz = MessageTImpl.class)
class MessageService{
    private IMessageT message;
    public MessageService() throws Exception {
        UseMessage useMessage = MessageService.class.getAnnotation(UseMessage.class);
        this.message = (IMessageT) Factory.getInstance(useMessage.clazz());
    }
    public void send(String msg){
        this.message.send(msg);
    }
}


public class FactoryAndAnnotation {
    public static void main(String [] args) throws Exception {
        /*IMessageT msg = Factory.getInstance(MessageTImpl.class);
        msg.send("BinZi");*/
        MessageService messageService = new MessageService();
        messageService.send("BinZi");
    }
}
