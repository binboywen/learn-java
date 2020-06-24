package example;

public class StudentMentor implements Comparable<StudentMentor>{
    private long sid;
    private String name;
    private int vote;
    public StudentMentor(long sid, String name, int vote){
        this.sid = sid;
        this.name = name;
        this.vote = vote;
    }
    @Override
    public String toString(){
        return "【" + this.sid + "】姓名：" + this.name + "、票数：" + this.vote ;
    }
    @Override
    public int compareTo(StudentMentor o) {
        return o.vote - this.vote;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
