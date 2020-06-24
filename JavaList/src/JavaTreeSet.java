import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
class Person2 implements Comparable<Person2>{
    private String name;
    private int age;
    public Person2(String name,int age) {
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "姓名：" + this.name + "年龄：" + this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person2)) return false;
        Person2 person2 = (Person2) o;
        return age == person2.age &&
                Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person2 per) {
        if(this.age < per.age){
            return -1;
        }else if(this.age > per.age){
            return 1;
        }else{
            return this.name.compareTo(per.name);
        }
    }
}
public class JavaTreeSet {
    public static void main(String [] args){
        Set<Person2> all = new TreeSet<Person2>();
        all.add(new Person2("C",22));
        all.add(new Person2("D",22));//姓名不同年龄相同
        all.add(new Person2("A",23));
        all.add(new Person2("A",23));//数据重复
        all.add(new Person2("B",24));
        all.forEach(System.out::println);
    }
}

