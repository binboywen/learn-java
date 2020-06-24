package example;

import java.util.Scanner;

public class InputUtil {
    private InputUtil() {}
    public static String getString(String prompt){
        String str = null;
        boolean flag = true;
        while(flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);
            if(input.hasNext()){
                str = input.next().trim();
                if(!"".equals(str)){
                    flag = false;
                }else{
                    System.out.println("输入的内容不允许为空！");
                }
            }else{
                System.out.println("输入的内容不允许为空！");
            }
        }
        return str;
    }
    /*
    * 实现键盘接受数字的操作
    * @param prompt 提示信息
    * @return 一个可以使用的数字
    * */
    public static int getInt(String prompt){
        int num = 0;
        boolean flag = true;

        while(flag){
            Scanner input = new Scanner(System.in);
            System.out.print(prompt);
            if(input.hasNext("\\d+")){
                num = Integer.parseInt(input.next("\\d+"));
                flag = false;
            }else{
                System.out.println("输入的内容不是数字！");
            }
        }
        return num;
    }
}
