import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable{
    private int ticket = 5;
    @Override
    public void run(){
        for (int x = 0; x < 100; x++){
            if(this.ticket>0) {
                System.out.println("卖票，ticket =  " + this.ticket--);
            }
        }
    }
}
class MyThread2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int x = 0; x < 10; x++) {
            System.out.println("*******线程执行、x = " + x);
        }
        return "线程执行完毕。";
    }
}
public class MultiThread {
    public static void main(String [] args) throws Exception{
        //MyThread mt = new MyThread();
        //new Thread(mt).start();
        //new Thread(mt).start();
        //new Thread(mt).start();
        FutureTask<String> task = new FutureTask<>(new MyThread2());
        new Thread(task).start();
        System.out.println("【线程返回数据】：" + task.get());
    }
}
