import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaCollectionOutput {
    public static void main(String [] args){
        List<String> all = new ArrayList<>();
        all.add("Hello, ");
        all.add("Hello, ");
        all.add("world.");
        /*all.forEach((str)->{
            System.out.println(str + "、");
        });*/
        Iterator<String> iterator = all.iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
