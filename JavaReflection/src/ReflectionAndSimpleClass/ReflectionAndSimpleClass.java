package ReflectionAndSimpleClass;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class StringUtils {
     static String initcap(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        } else {

            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}

class BeanUtils {
    private BeanUtils() {
    }

    /**
     * 实现指定对象的属性设置
     *
     * @param obj   要进行反射操作的实例化对象
     * @param value 包含有指定内容的字符串，格式“属性：内容|属性：内容|”
     */
     static void setValue(Object obj, String value) {
        String[] results = value.split("\\|");
         for (String result : results) {
             String[] attval = result.split(":");
             try {
                 if(attval[0].contains(".")){//多级配置
                    String [] temp = attval[0].split("\\.");
                    Object currentObject = obj;
                    for(int y = 0; y < temp.length; y++){
                        //调用相应的getter方法，如果getter方法返回了null表示该对象未实例化
                        Method getMethod = currentObject.getClass().getDeclaredMethod("get" + StringUtils.initcap(temp[y]));
                        Object tempObject = getMethod.invoke(currentObject);
                        if(tempObject == null){//该对象并没有实例化
                            Field field = currentObject.getClass().getDeclaredField(temp[y]);//获取属性类型
                            Method method = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[y]),field.getType());
                            Object newObject = field.getType().getDeclaredConstructor().newInstance();
                            method.invoke(currentObject,newObject);
                            currentObject = newObject;
                        }else{
                            currentObject = tempObject;
                        }
                    }
                    //进行属性内容的设置
                     Field field = currentObject.getClass().getDeclaredField(temp[temp.length -1]);//获取属性类型
                     Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[temp.length -1]), field.getType());
                     Object convertValue = BeanUtils.convertAttributeValue(field.getType().getName(), attval[1]);
                     setMethod.invoke(currentObject, convertValue);
                 }else{
                     Field field = obj.getClass().getDeclaredField(attval[0]);
                     Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attval[0]), field.getType());
                     Object convertValue = BeanUtils.convertAttributeValue(field.getType().getName(), attval[1]);
                     setMethod.invoke(obj, convertValue);
                 }
             } catch (Exception e) {
                    e.printStackTrace();
             }
         }
    }

    /**
     * 实现属性类型转换处理
     *
     * @param type  属性类型，通过Field获取
     * @param value 属性的内容，传入的都是字符串需要将其变为指定类型
     * @return 转换后的数据类型
     */
     private static Object convertAttributeValue(String type, String value) {
        if ("long".equals(type) || "java.lang.Long".equals(type)) {
            return Long.parseLong(value);
        } else if ("int".equals(type) || "java.lang.int".equals(type)) {
            return Integer.parseInt(value);
        } else if ("double".equals(type) || "java.lang.double".equals(type)) {
            return Double.parseDouble(value);
        } else if ("java.util.Date".equals(type)) {
            SimpleDateFormat sdf = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            } else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            } else {
                return new Date();
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        } else {
            return value;
        }
    }
}

class Company {
    private String name;
    private Date createdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}

class Dept {
    private String dname;
    private String loc;
    private Company company;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

class Emp {
    private String ename;
    private String job;
    private double salary;
    private long empno;
    private Date hiredate;
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


     String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

     String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

     double getSalary() {
        return salary;
    }

     void setSalary(double salary) {
        this.salary = salary;
    }

     long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

     Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}

class ClassInstanceFactory {
    private ClassInstanceFactory() {
    }

    /*
     * 实例化对象的创建方法，该对象可以根据传入的字符串结构创建实例化对象
     * @param clazz 要进行反射实例化的class类对象，有Class就可以反射实例化对象
     * @ param value 要设置给对象的属性内容
     * @return 一个已经配置好属性内容的简单Java类对象
     * */
     static <T> T create(Class<?> clazz, String value) throws Exception {
        //如果要想采用反射进行简单java类对象属性设置的时候，类中必须要有无参构造
        Object obj = clazz.newInstance();
        BeanUtils.setValue(obj, value);// 通过反射设置属性
        return (T) obj;
    }
}


public class ReflectionAndSimpleClass {
    public static void main(String[] args) throws Exception {
        String value = "empno:7369|ename:Mis|job:Mr|salary:750.00|hiredate:1989-10-10|" +
                "dept.dname:财务部|dept.company.name:ALi";
        Emp empObject = ClassInstanceFactory.create(Emp.class, value);
        System.out.println(empObject.getEname() + " " + empObject.getJob() + " "
                + empObject.getEmpno() + " " + empObject.getSalary() + " " + empObject.getHiredate());
        System.out.println(empObject.getDept().getDname());
        System.out.println(empObject.getDept().getCompany().getName());
        /*Emp emp = new Emp();
        emp.setEname("WenMin");
        emp.setJob("BinZi");
        System.out.println(emp.getEname());
        System.out.println(emp.getJob());*/
    }
}