package example;

import java.io.File;

public class example2 {

    static{ //项目启动的时候路径应该首先创建
        File file = new File(IFileService.SAVE_DIR);
        boolean flag = false;
        if(!file.exists()){
            flag = file.mkdirs();
            System.out.println(flag?"文件路径创建成功！":"文件路径创建失败！");
        }

    }
    public static void main(String [] args){
        IFileService fileService = Factory.getInstanceFileService();
        System.out.println(fileService.save());
    }
}
