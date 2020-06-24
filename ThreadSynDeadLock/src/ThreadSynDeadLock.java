class MyThread implements Runnable{
    private int ticket = 10;
    public synchronized boolean sale(){
        if (this.ticket > 0) {
            try {
                Thread.sleep(1000);//模拟网络延迟

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "买票.ticket = " + this.ticket--);
            return true;
        } else {
            System.out.println("*******票已抢光******");
            return false;
        }
    }
    @Override
    public void run(){
        while(this.sale()){
            ;
        }
    }
}
public class ThreadSynDeadLock {
    public static void main(String [] args){
        MyThread mt = new MyThread();
        new Thread(mt,"票贩子A").start();
        new Thread(mt,"票贩子B").start();
        new Thread(mt,"票贩子C").start();
    }
}
