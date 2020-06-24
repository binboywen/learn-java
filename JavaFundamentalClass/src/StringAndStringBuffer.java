public class StringAndStringBuffer {
    public static void main(String [] args){
        String str = "Hello ";
        change(str);
        System.out.println(str);

        StringBuffer buf = new StringBuffer("Hello ");
        change(buf);
        System.out.println(buf);
        //System.out.println(buf.toString());
    }
    private static void change(String temp){
        temp += "World !";
        //内容不会发生改变
    }

    private static void change(StringBuffer temp){
        temp.append("World!");
    }
}
