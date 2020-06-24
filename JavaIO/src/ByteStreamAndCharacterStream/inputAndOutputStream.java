package ByteStreamAndCharacterStream;

import java.io.*;

public class inputAndOutputStream {
    public static void main(String [] args) throws Exception {
        File file = new File("E:" + File.separator + "test" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try(OutputStream output = new FileOutputStream(file,true)){
            String str = "www.baidu.com " + "\r\n";
            output.write(str.getBytes());//将字符串变为字节数组
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
