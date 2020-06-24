package FileOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class ReaderFile {
    public static void main (String [] args) throws Exception {
        File file = new File("E:" + File.separator + "test" + File.separator + "test.txt");
        if(file.exists()){
            Reader in = new FileReader(file);
            char [] data = new char[1024];
            int len = in.read(data);
            System.out.println("【" + new String(data,0,len) + "】");
        }
    }
}
