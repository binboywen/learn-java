import java.util.ArrayList;
import java.util.List;

public class JavaListDemo {
    public static void main(String [] args){
        List<String> all = new ArrayList<>();
        all.add("你好");
        all.add("嗯，好");
        System.out.println(all);
        Object [] result = all.toArray();
        for(Object temp : result){
            System.out.println(temp);
        }
    }
}
