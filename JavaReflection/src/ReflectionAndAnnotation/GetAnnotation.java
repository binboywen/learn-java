package ReflectionAndAnnotation;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@FunctionalInterface
@Deprecated
interface IMessage{
    public void send(String msg);
}
@SuppressWarnings("serial")//无法在程序执行的时候获取
class MessageImpl implements IMessage, Serializable {
    @Override//无法在程序执行的时候获取
    public void send(String msg){
        System.out.println("【发送消息】");
    }
}
public class GetAnnotation {
    public static void main(String [] args) throws Exception {
        //获取接口上的信息
        Annotation [] annotation = IMessage.class.getAnnotations();
        for(Annotation temp : annotation){
            System.out.println(temp);
        }
        //获取子类上的Annotation
        annotation = MessageImpl.class.getAnnotations();
        for(Annotation temp : annotation)
            System.out.println(temp);
        //获取子类send()方法上的Annotation
        Method method = MessageImpl.class.getDeclaredMethod("send",String.class);
        annotation = method.getAnnotations();
        for(Annotation temp : annotation)
            System.out.println(temp);
    }
}
