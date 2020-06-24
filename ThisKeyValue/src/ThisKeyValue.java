class Person{
    private String name;
    private int age;
    public Person(String n, int a){
        this.setName(n);
        this.setAge(a);
    }
    public void tell(){
        System.out.println("姓名："+name+"、年龄："+age);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
}
public class ThisKeyValue {
    public static void main(String [] args){
        Person per = new Person("binZi",24);
        per.tell();
    }
}
