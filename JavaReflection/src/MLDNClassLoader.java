import java.io.*;

public class MLDNClassLoader extends ClassLoader {
    private static final String MESSAGE_CLASS_PATH = "E:" + File.separator + "Message.class";
    /**
     * 进行指定类的加载，
     * @param className 类的完整名称“包.类名称”
     * @return 返回一个指定类的Class对象
     * @throws Exception 如果类文件不存在则无法加载
     */
    public Class<?> loadData(String className) throws Exception{
        byte [] data = this.loadClassDate();
        if(data!= null){
            return super.defineClass(className,data,0,data.length);
        }
        return null;
    }
    private byte [] loadClassDate() throws Exception{//通过文件进行类的加载
        InputStream input = null;
        ByteArrayOutputStream bos = null;//将数据加载到内存之中
        byte [] data_ = null;
        try{
            /*input = new FileInputStream(srcFile);
            output = new FileOutputStream(desFile);
            int len = 0;
            while((len = input.read(data)) != -1){
                output.write(data,0,len);
            }*/
            bos = new ByteArrayOutputStream();
            int len = 0;
            input = new FileInputStream(new File(MESSAGE_CLASS_PATH));
            byte [] data = new byte [1024];
            while((len = input.read(data)) != -1){
                bos.write(data,0,len);
            }
            data_ = bos.toByteArray();
            return data_;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(input != null){
                input.close();
            }
            if(bos != null){
                bos.close();
            }
        }
        return data_;
    }
}
