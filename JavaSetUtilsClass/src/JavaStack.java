import java.util.Stack;

public class JavaStack {
    public static void main(String [] args){
        Stack<String>  all = new Stack<>();
        all.push("A");
        all.push("B");
        all.push("C");
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
        System.out.println(all.pop());
    }
}
