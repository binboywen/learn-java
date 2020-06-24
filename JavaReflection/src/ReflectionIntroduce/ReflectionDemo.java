package ReflectionIntroduce;

import java.util.Date;//1、导入程序所在的包.类，知道对象的出处了

public class ReflectionDemo {
    public static void main(String [] args){
        Date date = new Date();//2、通过类产生实例化对象
        System.out.println(date.getClass());//3、根据对象调用类中的方法
                                            //1、根据实例化对象找到对象的所属类型
    }
}
