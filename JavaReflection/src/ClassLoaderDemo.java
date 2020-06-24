class Messagew{}
public class ClassLoaderDemo {
    public static void main(String [] args) throws Exception{
        Class<?> clazz = Messagew.class;
        System.out.println(clazz.getClassLoader());//获取当前类的加载器sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(clazz.getClassLoader().getParent());//获取父类加载器sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println(clazz.getClassLoader().getParent().getParent());//获取祖父类加载器null

    }
}
