import java.util.ArrayList;
import java.util.List;

class Person{
    private String name;
    private int age;
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Person)){
            return false;
        }
        Person per = (Person) obj;
        return this.name.equals(per.name) && this.age == age;
    }

    public String toString(){
        return "姓名: " + this.name + "  年龄: " + this.age;
    }
}
public class JavaArrayListSaveObject {
    public static void main(String [] args){
        List<Person> all = new ArrayList<Person>();
        all.add(new Person("张",30));
        all.add(new Person("李",40));
        all.add(new Person("刘",50));
        all.add(null);
        System.out.println(all.contains(new Person("刘",50)));
        all.remove(new Person("刘",50));
        all.forEach(System.out::println);
    }
}
