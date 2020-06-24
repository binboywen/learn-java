class Dept{
    private long deptno;
    private String dname;
    private String loc;
    private Emp emps [] ;

    public void setEmps(Emp [] emps){
        this.emps = emps;
    }

    public Emp [] getEmps(){return this.emps;}

    public Dept(long deptno, String dname, String loc){
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public String getInfo(){
        return "【部门信息】部门编号："+this.deptno+"、部门名称："+this.dname+"、部门位置："+this.loc;
    }
}
class Emp{
    private long empno;
    private String ename;
    private String job;
    private double sal;
    private double comm;

    //关联字段
    private Dept dept;
    private Emp mgr;

    void setDept(Dept dept){
        this.dept = dept;
    }
    void setMgr(Emp mgr){
        this.mgr = mgr;
    }
    Dept getDept(){
        return this.dept;
    }
    Emp getMgr(){
        return this.mgr;
    }

    Emp(long empno, String ename, String job, double sal, double comm){
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal =sal;
        this.comm = comm;
    }

    String getInfo(){
        return "【雇员信息】：雇员编号"+this.empno+"、雇员姓名："+this.ename+"、雇员职位："+this.job +"、基本工资"+this.sal +"、佣金"+this.comm;
    }
}

public class DataTableToJavaClass {
     {
        //第一步根据关系进行类的定义
        Dept dept = new Dept(10,"财务部","上海");
        Emp empA = new Emp(7269,"binzi","manager",800.0,0.0);
        Emp empB = new Emp(7270,"miaomiao","coder",900.0,200.0);
        Emp empC = new Emp(7271,"ouou","financial",1000.0,9000.0);
        //进行关联定义
        empA.setDept(dept);
        empB.setDept(dept);
        empC.setDept(dept);

        empB.setMgr(empA);
        empC.setMgr(empA);

        dept.setEmps(new Emp[] {empA,empB,empC});
        System.out.println(dept.getInfo());

        System.out.println("*************");

        for (int x = 0; x < dept.getEmps().length; x++){
            System.out.println(dept.getEmps()[x].getInfo());
        }

        System.out.println("*************");

        System.out.println(empB.getInfo());
        System.out.println(empB.getDept().getInfo());
        System.out.println(empB.getMgr().getInfo());

    }

}
