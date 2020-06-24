import java.util.Arrays;
public class StudentInfoCompare {
    public static void main(String [] args){
        String input = "张三:21:98|李四:22:89|王五:20:70";
        String [] result  = input.split("\\|");
        Student [] students  = new Student [result.length];
        for(int x = 0; x < result.length; x++){
            String [] temp = result[x].split(":");
            students[x] = new Student(temp[0],
                    Integer.parseInt(temp[1]),Double.parseDouble(temp[2]));
        }
        Arrays.sort(students);
        System.out.println((Arrays.toString((students))));
    }
}
class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double score;
     Student(String name, int age, double score){
        super();
        this.age = age;
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Student stu) {
        if(this.score < stu.score){
            return 1;
        }else if(this.score > stu.score){
            return -1;
        }else{
            return this.age - stu.age;
        }
    }
    @Override
    public String toString(){
        return "【学生信息】姓名：" + this.name
                + "、年龄：" + this.age + "、分数：" + this.score + "\n";
    }
}
