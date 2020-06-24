import java.util.HashSet;
import java.util.Set;

public class JavaHashSet {
    public static void main(String [] args){
        Set<String> all = new HashSet<String>();
        all.add("C");
        all.add("Hello ");
        all.add("World ");
        all.forEach(System.out::println);
    }
}
