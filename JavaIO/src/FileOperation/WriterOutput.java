package FileOperation;

import java.io.*;

public class WriterOutput {
    public static void main(String [] args) throws Exception {
        File file = new File("E:" + File.separator + "test" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();//父目录必须存在
        }
        /*Writer out = new FileWriter(file,true);
        String str = "我是饼子！\r\n";
        out.write(str);
        out.append("我不是饼子！\r\n");
        out.append("我到底是不是饼子？");
        out.flush();*/
        //out.close();
        OutputStream output = new FileOutputStream(file);
        Writer out = new OutputStreamWriter(output);//字节流变为字符流
        out.write("我究竟是不是饼子？\r\n");
        out.close();
    }
}
