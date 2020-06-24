package example;

public interface INumberService {
    /*
    * 输入数据并返回输入数据的最大值与最小值
    * @param count 表示要输入数据的个数
    * @return 包含有两个内容，第一个是最大值，第二个是最小值
    * */
    public int [] stat(int count);
}
