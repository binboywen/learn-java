public class TestClassLoader {
    public static void main(String [] args)throws Exception{
        MLDNClassLoader classLoader = new MLDNClassLoader();
        Class<?> cls = classLoader.loadData("ReflectionIntroduce.Message");
        System.out.println(cls);
        System.out.println(cls.getClassLoader());//获取当前类的加载器sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(cls.getClassLoader().getParent());//获取父类加载器sun.misc.Launcher$ExtClassLoader@1b6d3586
        System.out.println(cls.getClassLoader().getParent().getParent());//获取祖父类加载器null
    }
}
