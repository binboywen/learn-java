package example;

import static example.Factory.getInstance;

public class example1 {
    public static void main(String [] args){
        INumberService numberService =  getInstance();
        int [] result = numberService.stat(5);
        System.out.println("最大值：" + result[0] + "    最小值：" + result[1]);
    }
}
