
class Dept{   //类名称可以明确描述出某类事物
    private long deptno;
    private String dname;
    private String loc;
    public Dept(){ };//必须提供无参构造方法
    public Dept(long deptno,String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }
    public String getInfo(){
        return "【部门信息】部门编号："+this.deptno+"、部门名称："+this.dname+"、部门位置："+this.loc;
    }
    public void SetDeptno(long deptno){
        this.deptno = deptno;
    }
    public long GetDeptno(){
        return this.deptno;
    }
    public void SetDname(String dname){
        this.dname = dname;
    }
    public String GetDname(){
        return this.dname;
    }
    public void SetLoc(String loc){
        this.loc = loc;
    }
    public String GetLoc(){
        return this.loc;
    }
}

public class SampleClass {
    public static void main(String args []){
        Dept dept = new Dept(10,"国务院","北京");
        System.out.println(dept.getInfo());

    }
}
