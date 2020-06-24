import java.util.ArrayList;
import java.util.List;

public class JavaArrayList {
    public static void main(String [] args){
        List<String> all = new ArrayList<>();
        all.add("Hello, ");
        all.add("Hello, ");
        all.add("world.");
        all.forEach((str)->{
            System.out.println(str + "、");
        });
    }
}
