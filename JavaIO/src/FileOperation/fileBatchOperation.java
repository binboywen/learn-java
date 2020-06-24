package FileOperation;

import java.io.File;

public class fileBatchOperation {
    public static void main(String [] args){
        File file = new File("E:" + File.separator + "test" );
        long start = System.currentTimeMillis();
        renameDir(file);
        long end = System.currentTimeMillis();
        System.out.println("本次操作所花费的时间：" + (end - start));
    }
    private static void renameDir(File file){
        if(file.isDirectory()){
            File [] results = file.listFiles();
            if(results != null){
                for (File result: results) {
                    renameDir(result);
                }
            }
        }else{
            if(file.isFile()){
                //File newFile = new File(file.getParentFile());
                String fileName ;
                if(file.getName().contains(".")) {
                    fileName = file.getName().substring(0, file.getName().lastIndexOf(".")) + ".txt";
                }else{
                    fileName = file.getName() + ".txt";
                }
                File newFile = new File(file.getParentFile(),fileName);
                file.renameTo(newFile);
                //System.out.println(fileName);

            }
        }

    }
}
