package ReflectionIntroduce;

class Person{}
public class ClassObjectInstance {
    public static void main(String [] args) throws ClassNotFoundException {
        Person per = new Person();//已经存在有指定类的实例化对象
        Class<? extends Person> cls1 = Person.class;//JVM直接支持
        Class<? extends Person> cls2 = per.getClass();
        Class<?> cls3 = Class.forName("ReflectionIntroduce.Person");

        System.out.println(cls1.getName());
        System.out.println(cls2.getName());//获取类的完整名称
        System.out.println(cls3.getName());//获取类的完整名称
    }
}
