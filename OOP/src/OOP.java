

class Message{
    private String title;
    public Message(String t){
        title = t;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String t){
        title =t;
    }
}

class Person{
    private String name;
    private int age;
    //构造函数与类名称相同，无返回值定义
    public Person(Message msg, int a){
        name = msg.getTitle();
        age = a;
    }
    public Message getInfo(){
        return new Message(name + ":" + age);
    }
    public void getPerson(){
        System.out.println("name: "+ name + "; age:"+ age);
    }
}

public class OOP {
    public static void main(String [] args)
    {
       // Person binzi = new Person("zhangsan",19);
       // binzi.age = 15;
       // binzi.name = "binzi";
       // binzi.getPerson();
       // System.out.println("hello world bin zi!");
        Message msg = new Message("mldn");
        Person per = new Person(msg, 20);
        msg = per.getInfo();
        System.out.println(msg.getTitle());

    }
}
