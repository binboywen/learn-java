package FileOperation;

import java.io.File;
import java.io.IOException;

public class FileFundamentalOperation {
    public static void main(String [] args){
        System.out.println("文件操作调用");
        File file = new File("C:" + File.separator + "Users" + File.separator + "BinPC" + File.separator
                + "IdeaProjects" + File.separator + "JavaTest" + File.separator + "JavaIO" + File.separator + "test.txt");
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        if (file.exists()){
            file.delete();
        }
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public void aaaa(String aaa){
        System.out.println(aaa);
    }*/
}


