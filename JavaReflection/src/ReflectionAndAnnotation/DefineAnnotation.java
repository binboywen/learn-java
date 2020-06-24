package ReflectionAndAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface DefaultAnnotation{
    public String title();
    public String url() default "www.mldn.cn";
}
class Message{
    @DefaultAnnotation(title = "hello")
    public void send(String msg){
        System.out.println("【消息发送】" + msg);
    }
}
public class DefineAnnotation {
    public static void main(String [] args) throws Exception{
        Method method = Message.class.getMethod("send",String.class);
        DefaultAnnotation defaultAnnotation = method.getAnnotation(DefaultAnnotation.class);
        String msg = defaultAnnotation.title() + "(" + defaultAnnotation.url() + ")";
        method.invoke(Message.class.newInstance(),msg);
        System.out.println(defaultAnnotation.title() + " " + defaultAnnotation.url());
    }
}
