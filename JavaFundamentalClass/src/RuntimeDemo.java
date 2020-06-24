import sun.misc.Cleaner;

public class RuntimeDemo {
    public static void main(String [] args) {
        Runtime run = Runtime.getRuntime();
        System.out.println("【内核数】："  + run.availableProcessors());
        System.out.println("1、【最大内存空间】：" + run.maxMemory());
        System.out.println("1、【可用内存空间】：" + run.totalMemory());
        System.out.println("1、【空闲内存空间】：" + run.freeMemory());
        long start = System.currentTimeMillis();
        String str = "";
        for (int x = 0; x < 30000; x++){
            str += x;
        }
        long end = System.currentTimeMillis();
        System.out.println("操作耗时：" + (end - start));
        System.out.println("2、【最大内存空间】：" + run.maxMemory());
        System.out.println("2、【可用内存空间】：" + run.totalMemory());
        System.out.println("2、【空闲内存空间】：" + run.freeMemory());

        run.gc();
        System.out.println("3、【最大内存空间】：" + run.maxMemory());
        System.out.println("3、【可用内存空间】：" + run.totalMemory());
        System.out.println("3、【空闲内存空间】：" + run.freeMemory());
        System.gc();

    }
}
/*
class m implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();
    @Override
    public void close() throws Exception {

    }
}*/
