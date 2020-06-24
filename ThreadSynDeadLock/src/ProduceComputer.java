class Computer{
    private static int count = 0;
    private String name;
    private double price;
    public Computer(String name, double price){
        this.name = name;
        this.price = price;
        this.count++;
    }
    public String toString(){
        return "【第" + count + "台电脑】电脑名字：" + this.name + "、价值：" + this.price;
    }
}
class Resources{
    private Computer computer;
    //private boolean flag = true;
    public synchronized void produce(){
        if(this.computer != null){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.computer = new Computer("华硕电脑",5000);
        System.out.println("【生产电脑】" + this.computer);
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //this.flag = false;
        super.notifyAll();
    }
    public synchronized void carry(){
        if(this.computer == null){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("【搬运电脑】" + this.computer);
        this.computer = null;
        super.notifyAll();
        /*try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
class Producers implements Runnable{
    private Resources resources;
    public Producers(Resources resources){
        this.resources = resources;
    }
    @Override
    public void run(){
        for(int x = 0; x < 50; x++){
            this.resources.produce();
        }
    }
}
class Consumers implements Runnable{
    private Resources resources;
    public Consumers(Resources resources){
        this.resources = resources;
    }
    @Override
    public void run(){
        for(int x = 0; x < 50; x++){
            this.resources.carry();
        }
    }
}

public class ProduceComputer {
    public static void main(String [] args){
        Resources res = new Resources();
        new Thread(new Producers(res)).start();
        new Thread(new Consumers(res)).start();
    }
}
