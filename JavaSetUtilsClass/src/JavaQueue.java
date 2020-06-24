import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class JavaQueue {
    public static void main(String [] args){
        Queue<String> queue = new PriorityQueue<>();
        queue.offer("X"); //追加队列数据，通过队尾追加
        queue.offer("A");
        queue.offer("Z");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
