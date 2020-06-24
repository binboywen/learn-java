import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JavaVector {
    public static void main(String [] args){
        List<String> all = new Vector<>();
        all.add("你好");
        all.add("嗯，好");
        System.out.println(all);
        Object [] result = all.toArray();
        for(Object temp : result){
            System.out.println(temp);
        }
    }
}
