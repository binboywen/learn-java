package FileOperation;

import java.io.*;

public class ReadDataFromFile {
    public static void main(String [] args) throws Exception {
        File file = new File("E:" + File.separator + "test" + File.separator + "test.txt");
        InputStream input = new FileInputStream(file);
        byte [] data = new byte [1024];
        int len = input.read(data);
        System.out.println("【" + new String(data,0,len) + "】");
        input.close();
    }
}
