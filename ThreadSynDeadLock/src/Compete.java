import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThreads implements Callable<String> {
    private boolean flag = false;
    @Override
    public String call() throws Exception {
        synchronized(this){
            if(!this.flag){
                this.flag = true;
                return Thread.currentThread().getName() + "抢答成功！";
            }else{
                return Thread.currentThread().getName() + "抢答失败！";

            }
        }
    }
}
public class Compete {
    public static void main(String [] args) throws ExecutionException, InterruptedException {
        MyThreads mt = new MyThreads();
        FutureTask<String> taskA = new FutureTask<>(mt);
        FutureTask<String> taskB = new FutureTask<>(mt);
        FutureTask<String> taskC = new FutureTask<>(mt);

        new Thread(taskC,"竞赛者C").start();
        new Thread(taskA,"竞赛者A").start();
        new Thread(taskB,"竞赛者B").start();

        System.out.println(taskA.get());
        System.out.println(taskB.get());
        System.out.println(taskC.get());
    }
}
