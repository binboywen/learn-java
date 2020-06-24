package ReflectionAndClassOperation;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {
    public static void main(String [] args) throws Exception{
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafeObject = (Unsafe) field.get(null);
        //利用Unsafe类绕过了JVM的管理机制，可以在没有实例化对象的情况下获取一个Singleton类实例化对象
        Singleton singleton = (Singleton) unsafeObject.allocateInstance(Singleton.class);
        singleton.print();
        //Singleton.getInstance().print();
    }
}

class Singleton{
    //private static final Singleton INSTANCE = new Singleton();
    private Singleton(){
        System.out.println("调用构造方法");
    }
    /*public static Singleton getInstance(){
        return INSTANCE;
    }*/
    public void print(){
        System.out.println("binZi");
    }
}