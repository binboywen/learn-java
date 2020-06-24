package example;

import java.io.File;

public interface IFileService {
    public static final String SAVE_DIR = "E:" + File.separator + "test" + File.separator;
    /*
    *定义文件的保存处理方法
    * @return 保存成功为true
    * */
    public boolean save();
}
