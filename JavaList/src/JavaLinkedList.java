import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class JavaLinkedList {
    public static void main(String [] args){
        List<String> all = new LinkedList<>();
        all.add("Hello, ");
        all.add("Hello, ");
        all.add("world.");
        all.forEach((str)->{
            System.out.println(str + "、");
        });
    }
}
