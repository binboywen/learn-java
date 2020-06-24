import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaMap {
    public static void main(String [] args){
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        //map.put("zero",null);//value为空
        //map.put(null,9);//key为空
        map.put("two",2);

        System.out.println(map);
    }
}

