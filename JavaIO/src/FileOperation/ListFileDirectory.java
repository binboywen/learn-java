package FileOperation;

import java.io.File;

public class ListFileDirectory {
    public static void main(String [] args){
        File file = new File("D:" + File.separator + "Cloudmusic" + File.separator);
        listDir(file);
    }
    private static void listDir(File file){
        if(file.isDirectory()){
            File [] results = file.listFiles();
            if(results != null){
                for (File result : results) {
                    listDir(result);
                }
            }
        }else{
            System.out.println(file);
        }
        //file.delete();
    }
}
