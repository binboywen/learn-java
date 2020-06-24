package FileOperation;

import java.io.*;

class FileUtil{
    private File srcFile;
    private File desFile;
    private FileUtil(File srcFile, File desFile){
        this.srcFile = srcFile;
        this.desFile = desFile;
    }
    FileUtil(String src, String des){
        this(new File(src), new File(des));
    }
    boolean copyDir() {
        try{
            this.copyImpl(this.srcFile);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    private void copyImpl(File file) throws Exception{
        if(file.isDirectory()){
            File [] result = file.listFiles();
            if(result != null){
                for(int x= 0; x < result.length; x++){
                    copyImpl(result[x]);
                }
            }
        }
        else{
            String newFilePath = file.getPath().replace (this.srcFile.getPath() + File.separator,"");
            File newFile = new File(this.desFile,newFilePath);
            this.copyFileImpl(file,newFile);
        }
    }
    private boolean copyFileImpl(File srcFile, File desFile) throws Exception{
        if(!desFile.getParentFile().exists()){
            desFile.getParentFile().mkdirs();
        }
        InputStream input = null;
        OutputStream output = null;
        byte [] data = new byte[1024];
        try{
            input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            int len = 0;
            while((len = input.read(data)) != -1){
                output.write(data,0,len);
            }
            /*do{
                len = input.read(data);
                if(len != -1){
                    output.write(data,0,len);
                }
            }while(len != -1);*/
            System.out.println("文件拷贝完成！");
            return true;
        } catch(Exception e){
            throw e;
        }finally{
            if(input != null){
                input.close();
            }
            if(output != null){
                output.close();
            }

        }
    }
    boolean copy() throws Exception {
        if(!this.srcFile.exists()){
            System.out.println("源文件不存在！");
            return false;
        }
        return this.copyFileImpl(this.srcFile,this.desFile);
    }
}
public class FileCopy {
    public static void main(String [] arg) throws Exception {
        /*if(arg.length != 2){
            System.out.println("没有输入文件路径");
            System.exit(1);
        }*/
        long start = System.currentTimeMillis();
        String src = "E:/lwm";
        String des = "E:/hello";
        FileUtil fu = new FileUtil(src,des);
        if(new File(src).isFile()){
            System.out.println(fu.copy() ? "文件拷贝成功!" : "文件拷贝失败!");
        }else{
            System.out.println(fu.copyDir() ? "文件拷贝成功!" : "文件拷贝失败!");
        }
        long end = System.currentTimeMillis();
        System.out.println("拷贝消耗时间：" + (end - start));
    }
}
