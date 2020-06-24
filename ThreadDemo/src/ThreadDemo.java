//class MyThread extends Thread
class MyThread implements Runnable{//线程的主体类
    private String title;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run(){//线程的主体方法
        for(int i = 0; i < 100; i ++){
            System.out.println(this.title + "运行, i = " + i);
        }
    }

}

public class ThreadDemo {
    public static void main(String [] args) throws Exception {
        /*Thread thread = new Thread(new MyThread("线程A"));
        thread.start();
        new MyThread("线程A").start();
        new MyThread("线程B").start();
        new MyThread("线程C").start();*/
        /*for (int x = 0; x < 3; x++){
            String title = "线程对象-" + x;
            Runnable run = ()->{
                for (int y = 0; y < 10; y++){
                    System.out.println(title + "运行，y = " + y);
                }
            };
            new Thread(run).start();
        }*/
        //线程休眠，自动唤醒
        /*new Thread(()->{
           for (int x = 0; x < 10; x++){
               System.out.println(Thread.currentThread().getName()+"、x = " + x);
               try{
                   Thread.sleep(1000);
               }catch(InterruptedException e){
                   e.printStackTrace();
               }
           }
        },"线程对象").start();*/

        //多个线程休眠处理
        /*for (int num = 0; num < 5; num++){
            new Thread(()->{
                for (int x = 0; x < 10; x++){
                    System.out.println(Thread.currentThread().getName()+"、x = " + x);
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            },"线程对象 - " + num).start();
        }*/
        //线程中断
        /*Thread thread = new Thread(()->{
            System.out.println("****需要睡觉****");
            try{
                Thread.sleep(10000);
                System.out.println("****休息结束****");
            }catch(InterruptedException e){
                System.out.println("****谁打扰我休息？****");
                e.printStackTrace();
            }

        });
        thread.start();//开始睡
        Thread.sleep(1000);
        if(!thread.isInterrupted()){//判断该线程是否已经被中断
            System.out.println("****休息中断****");
            thread.interrupt();//中断执行
        }*/

        //线程强制运行
        /*Thread mainThread = Thread.currentThread();
        Thread thread = new Thread(()->{
            for (int x = 0; x <= 100; x++){
                if(x > 10){
                    try{
                        mainThread.join();//主线程要先执行
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "执行、x = " + x);
            }
        },"bin");
        thread.start();
        for(int x = 0; x <= 100; x++){
            System.out.println("【main线程】number = " + x);
        }*/

        //线程的礼让
        Thread thread = new Thread(()->{
            for (int x = 0; x <= 100; x++){
                if(x%3 == 0){
                    System.out.println("bin线程礼让执行。");
                    Thread.yield();

                }
                System.out.println(Thread.currentThread().getName() + "执行、x = " + x);
            }
        },"bin");
        thread.start();
        for(int x = 0; x <= 100; x++){
            System.out.println("【main线程】number = " + x);
        }
    }
}
