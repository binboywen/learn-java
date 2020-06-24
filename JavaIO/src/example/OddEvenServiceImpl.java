package example;

public class OddEvenServiceImpl implements IOddEvenService{
    @Override
    public int[] stat() {
        int stat [] = new int [] {0,0};//第一个为偶数的统计个数，第二个为奇数的统计个数
        String str = InputUtil.getString("请输入数字信息：");
        String result [] =  str.split("");
        for(int x = 0; x < result.length; x++){
            if(Integer.parseInt(result[x]) % 2 == 0){
                stat[0] ++;
            }else{
                stat[1]++;
            }

        }
        return stat;
    }
}
