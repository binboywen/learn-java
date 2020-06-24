import BinZi.HelloWorld;
//import FileOperation.FileFundamentalOperation;

class Person{
     private String name;
     private String addr;
     private char sex;
     private int age;

     Person(){}

     Person(String name, String addr){
         this(name,addr,'男',0);
     }

     Person(String name,String addr,char sex,int age){
         this.name = name;
         this.addr = addr;
         this.sex = sex;
         this.age = age;
     }

     public String getInfo(){
         return "姓名：" +this.name + "、地址："+this.addr + "、性别："+this.sex+"、年龄："+this.age;
     }

}

class Student extends Person{
    private double math;
    private double english;

    public Student(){}

    public Student(String name, String addr){
        super(name,addr);
    }

    public Student(String name, String addr, char sex, int age, double math, double english){
        super(name,addr,sex,age);
        this.math = math;
        this.english = english;

    }

    public String getInfo(){
        return super.getInfo() + "、数学成绩：" +this.math + "、英语成绩："+this.english;
    }

}

class StringUtil{
    //返回的第一个内容为字母n的个数，第二个内容为字母o的个数
    static int [] count(String str){
        int countData [] = new int [2];
        char data []  = str.toCharArray();//将字符串变为字符数组
        for (int x = 0; x < data.length ; x++){
            if (data[x] == 'n' || data[x] == 'N'){
                countData[0]++;
            }
            if (data[x] == 'o' || data[x] == 'O'){
                countData[1]++;
            }
        }
        return countData;
    }

}

class Array{
    private int [] data;
    private int foot;
    Array (int len){
        if (len > 0){
            this.data = new int [len];
        }
        else{
            this.data = new int [1];
        }
    }

    void increment(int num){
        int [] newData = new int [this.data.length + num];
        System.arraycopy(this.data,0,newData,0,this.data.length);
        this.data = newData;
    }

    boolean add(int num){
        if(this.foot < this.data.length){
            this.data[this.foot++] = num;
            return true;
        }
        return false;
    }

    public int [] getData(){
        return this.data;
    }
}

class SortArray extends Array{
    SortArray(int len){
        super(len);
    }

    public int [] getData(){
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}

class ReverseArray extends Array{
    public ReverseArray(int len){
        super(len);
    }

    public int [] getData(){
        int center = super.getData().length / 2;
        int head = 0;
        int tail = super.getData().length - 1;
        for (int x = 0; x < center ; x++){
            int temp = super.getData()[head];
            super.getData()[head] = super.getData()[tail];
            super.getData()[tail] = temp;
            head++;
            tail--;
        }
        return super.getData();
    }

}

public class Inherit {
    public static void main(String [] args){
        HelloWorld h = new HelloWorld();
        /*FileFundamentalOperation f = new FileFundamentalOperation();
        f.aaaa("文件操作调用！");*/
        //Student stu = new Student("张三","天安门",'男',18,90,91);
        //System.out.println(stu.getInfo());
        String str = "do you want to know one thing";
        int  result [] = StringUtil.count(str);

        System.out.println("字母n的个数: "+ result[0]);
        System.out.println("字母o的个数: "+ result[1]);

        SortArray arr = new SortArray(5);
        System.out.println(arr.add(9));
        System.out.println(arr.add(20));
        System.out.println(arr.add(16));
        System.out.println(arr.add(10));
        System.out.println(arr.add(1));
        arr.increment(3);
        System.out.println(arr.add(55));

        int [] out= arr.getData();
        for(int temp : out)
        {
            System.out.println(temp + "、");
        }

    }
}
