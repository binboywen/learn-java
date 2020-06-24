package example;

public class Student implements Comparable<Student>{
    private String name;
    private double score;
    public Student(String name, double score){
        this.score = score;
        this.name = name;
    }
    public String toString(){
        return "姓名: " + this.name + "、成绩: " + this.score;
    }
    @Override
    public int compareTo(Student o) {
        if(this.score > o.score){
            return -1;
        }else if(this.score < o.score){
            return 1;
        }else{
            return 0;
        }
    }
}
