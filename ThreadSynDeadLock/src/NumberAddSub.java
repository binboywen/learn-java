class Resource{
    private int num = 0;
    private boolean flag = true;
    //falg = true;表示可以加但不可以减
    public synchronized void add(){
         if(!this.flag ){
             try {
                 super.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
        /*try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.num++;
        System.out.println("【加法操作-"+Thread.currentThread().getName()+"】num = "+ this.num);
        this.flag = false;
        super.notifyAll();
    }
    public synchronized void sub(){
         if(this.flag){
             try {
                 super.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
        /*ry {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        this.num--;

        System.out.println("【减法操作-"+Thread.currentThread().getName()+"】num = "+ this.num);

        this.flag = true;
        super.notifyAll();

    }
}

class AddThread implements Runnable{
    private Resource resource;
    public AddThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        for (int x = 0; x < 50; x++){
            this.resource.add();
        }
    }
}
class SubThread implements Runnable{
    private Resource resource;
     SubThread(Resource resource){
        this.resource = resource;
    }
    @Override
    public void run(){
        for (int y = 0; y < 50; y++){
            this.resource.sub();
        }
    }
}
public class NumberAddSub {
    public static void main(String [] args){
        Resource res = new Resource();
        AddThread at = new AddThread(res);
        SubThread st = new SubThread(res);
        new Thread(at,"加法线程 - A").start();
        new Thread(st,"减法线程 - X").start();
        new Thread(at,"加法线程 - B").start();
        new Thread(st,"减法线程 - Y").start();
    }
}
