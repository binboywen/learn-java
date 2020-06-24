import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaCollections {
    public static void main(String [] args){
        List<String> all = new ArrayList<>();
        all.add("A");
        all.add("B");
        all.add("C");
        Collections.addAll(all,"Hello","World");
        System.out.println(all);
        Collections.reverse(all);
        System.out.println(all);
        Collections.sort(all);
        System.out.println(Collections.binarySearch(all,"Hello"));
    }
}
