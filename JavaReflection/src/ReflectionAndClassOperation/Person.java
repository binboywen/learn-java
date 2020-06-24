package ReflectionAndClassOperation;

public class Person extends AbstractBase implements IMessageService,IChannelService {
    private String name;
    private int age;
    public Person(){}
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "姓名：" + this.name + "、年龄：" + this.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public void send() {
        if(this.connect()){
            System.out.println("【信息发送】");
        }
    }
}
