package Singleton;
//单例饱汉
class Singleton_ex1{
    private static final Singleton_ex1 INSTANCE = new Singleton_ex1();
    private Singleton_ex1(){}
    public static Singleton_ex1 getInstance(){
        return INSTANCE;
    }
    public void print(){
        System.out.println("单例饱汉");
    }
}
//单例饿汉
class Singleton_ex2 {
    private static Singleton_ex2 instance;
    private Singleton_ex2(){}
    public static Singleton_ex2 getInstance(){
        if(instance == null){
            instance = new Singleton_ex2();
        }
        return instance;
    }
    public void print(){
        System.out.println("单例饿汉");
    }
}
//多例
class Color{
    private static final Color RED = new Color("红色");
    private static final Color GREEN = new Color("绿色");
    private static final Color BLUE = new Color("蓝色");
    private String title;
    private Color(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }
    public static Color getInstance(String color){
        switch(color){
            case "red" : return RED;
            case "green" : return GREEN;
            case "blue" :return BLUE;
            default : return null;
        }
    }
}

public class Singleton{
    public static void main(String [] args){

        Singleton_ex1 instanceEx1;
        instanceEx1 = Singleton_ex1.getInstance();
        instanceEx1.print();

        Singleton_ex2 instanceEx2;
        instanceEx2 = Singleton_ex2.getInstance();
        instanceEx2.print();



    }
}