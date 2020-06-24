package ReflectionAndClassOperation;



import java.lang.reflect.*;

public class ReflectionObtainClassInfo {
    public static void main(String [] args) throws Exception {
        Class<?> cls = Person.class;
        Package pack = cls.getPackage();//获取指定类的包定义
        System.out.println(pack.getName());//获取包名
        Class<?> parent = cls.getSuperclass();//获取父类
        System.out.println(parent.getName());
        Class<?> [] clazz = cls.getInterfaces();//获取父接口
        for(Class<?> temp : clazz){
            System.out.println(temp.getName());
        }
        //<=>getConstructors()
        Constructor<?>[] constructors = cls.getDeclaredConstructors();//获取所有构造函数
        for(Constructor<?> cons : constructors){
            System.out.println(cons);
        }
        Constructor<?> constru = cls.getConstructor(String.class,int.class);//调用有参构造函数
        Object obj = constru.newInstance("小强",78);
        System.out.println(obj);
        {
            //获取全部方法(包括父类中的方法)
            Method [] methods = cls.getMethods();
            for(Method met : methods){
                System.out.println(met);
            }
        }
        {
            //获取本类全部方法Declared
            Method [] methods2 = cls.getMethods();
            for(Method met : methods2){
                int mod = met.getModifiers();//修饰符
                System.out.print(Modifier.toString(mod) + " ");
                System.out.print(met.getReturnType().getName() + " ");
                System.out.print(met.getName() + "(");
                Class<?> [] params =  met.getParameterTypes();
                for(int x = 0; x < params.length; x++){
                    System.out.print(params[x].getName() + " " + "arg-" + x );
                    if(x < params.length -1){
                        System.out.print(",");
                    }

                }
                System.out.print(")");
                Class<?> [] exp = met.getExceptionTypes();
                if(exp.length>0){
                    System.out.print(" throws ");
                }
                for(int x = 0; x< exp.length;x++){
                    System.out.println(exp[x].getName());
                    if(x < exp.length-1){
                        System.out.print(",");
                    }
                }
                System.out.println();
            }
            //获取指定类的Class对象
            Class<?> clss = Class.forName("ReflectionAndClassOperation.Person");
            String value = "binZi";//要设置的属性内容
            //1、任何情况下如果要想保存类中的属性或者调用类中的方法都必须保证存在有实例化对象
            //即不允许导入包，那么就反射实例化
            Object obje = clss.newInstance();//调用无参构造实例化
            //2、如果要想进行方法的调用，那么一定要获取方法的名称
            String setMethodName = "setName";
            Method setMethod = clss.getDeclaredMethod(setMethodName,String.class);//获取指定方法
            setMethod.invoke(obje,value);//等价于：Person对象.setName(value);
            String getMethodName = "getName";
            Method getMethod = clss.getDeclaredMethod(getMethodName);//getter没有参数
            System.out.println(getMethod.invoke(obje));//等价于：Person对象.getName()

            Field [] fieldsP =cls.getFields();
            for(Field fie:fieldsP){
                System.out.println(fie);
            }
            Field [] fields =cls.getDeclaredFields();
            for(Field fie:fields){
                System.out.println(fie);
            }

            Object objF = cls.newInstance();
            Field nameFiled = cls.getDeclaredField("name");
            nameFiled.setAccessible(true);
            nameFiled.set(obj,"我是binZi");
            System.out.println(nameFiled.get(obj));
            System.out.println(nameFiled.getType().getSimpleName());

        }
    }
}
