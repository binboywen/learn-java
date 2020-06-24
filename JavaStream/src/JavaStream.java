import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    public static void main(String [] args){
        List<String> all = new ArrayList<>();
        Collections.addAll(all,"Hello","World");
        Stream<String> stream = all.stream();
        //System.out.println(stream.count());
        //System.out.println(stream.filter((ele)->ele.toLowerCase().contains("w")).count());
        //将满足条件的数据收集起来转为List
        List<String> result = stream.filter((ele)->ele.toLowerCase().contains("w")).collect(Collectors.toList());
        System.out.println(result);
    }
}
