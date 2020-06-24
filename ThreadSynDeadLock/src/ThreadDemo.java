class Message {
    private String title;
    private String content;
    private boolean flag = true;//表示生产或消费的形式

    // flag = true，允许生产，但是不允许消费
    // flag = false，允许消费，但是不允许生产
    synchronized void set(String title, String content) {
        if (!this.flag) {//无法进行生产，应该等待被消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;//已经生产过了
        super.notify();
    }

    synchronized String get() {
        if (this.flag) {//还未生产，需要等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            return this.title + "  -  " + this.content;
        } finally {//不管如何都要执行
            this.flag = true;//继续生产
            super.notify();//唤醒等待线程
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();//启动生产者线程
        new Thread(new Consumer(msg)).start();//启动消费者线程
    }
}

class Producer implements Runnable {
    private Message msg;

    Producer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            if (x % 2 == 0) {
                this.msg.set("小喵", "喵喵");
            } else {
                this.msg.set("小狗", "汪汪");
            }
        }
    }
}

class Consumer implements Runnable {
    private Message msg;

    Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int x = 0; x < 100; x++) {
            System.out.println(this.msg.get());
        }
    }
}



