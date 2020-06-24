class Person{
	private String name;
	private int age;
	public Person(String name, int age){
		this.name = name;
		this.age = age;
		
	}
	public String toString(){
		return "name:" + this.name + "  age:" + this.age; 
	}
}
@FunctionalInterface
interface IFunction<R>{
	public R create(String s, int a);
}
public class testJava{
	public static void main(String args []){
		IFunction<Person> fun = Person :: new;
		System.out.println(fun.create("binzi",20));
	}
}