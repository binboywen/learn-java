package ReflectionExample;

class Person_{
    public Person_(){
        System.out.println("Person_类构造方法！");
    }
    @Override
    public String toString() {
        return "i'm binZi!";
    }
}

public class ReflectionInstanceObject {
    public static void main(String [] args) throws Exception{
        Class<?> cls = Class.forName("ReflectionExample.Person_");
        Object obj = cls.newInstance();//实例化对象，JDK1.9后被废除了
        //Object obj = cls.getDeclaredConstructors().newInstance();
        System.out.println(obj);//输出对象调用toString
    }
}
