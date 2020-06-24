package example;

import java.util.Arrays;

public class Menu {
    //private IStringService stringService;
    public Menu(){
        //this.stringService = Factory.getInstanceStringService();
        this.choose();
    }
    public void choose(){
        this.show();
        String choose = InputUtil.getString("请进行选择：");
        switch(choose){
            case "1":{
                String str = InputUtil.getString("请输入要追加的数据：");
                IStudentService studentService = Factory.getInstanceStudentService();
                studentService.append(str);
                //this.stringService.append(str);
                choose();
            }
            case "2":{
               // String str = InputUtil.getString("请输入字符串数据：");
                IStudentService studentService = Factory.getInstanceStudentService();

                System.out.println(Arrays.toString(studentService.getData()));
                choose();
            }
            case "0":{
                System.out.println("退出程序！");
                System.exit(1);
            }
            default:{
                System.out.println("您选择了非法的内容！");
                choose();
            }
        }
    }
    public void show(){
        System.out.println("【0】退出程序\n");
        System.out.println("【1】追加字符串数据\n");
        System.out.println("【2】显示所有的学生数据");
        System.out.println("\n");

    }
}
