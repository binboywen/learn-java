package ReflectionExample;

class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){
        System.out.println("【" + Thread.currentThread().getName()
                + "】******实例化Singleton类对象*****");
    }
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void print(){
        System.out.println("我是binZi!");
    }
}
public class ReflectionSingleton {
    public static void main(String [] args) throws Exception{
        for(int x = 0; x < 3; x++){
            new Thread(()->{
                Singleton.getInstance().print();
            },"单例消费端-" + x).start();
        }
    }
}
