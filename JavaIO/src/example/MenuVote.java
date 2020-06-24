package example;

import java.util.Arrays;

public class MenuVote {
    private IVoteService voteService;
    public MenuVote(){
        //this.stringService = Factory.getInstanceStringService();
        this.voteService = Factory.getInstanceVoteService();
        this.vote();
    }
    public void vote(){
        StudentMentor stu [] = this.voteService.getData();
        for(StudentMentor temp:stu){
            System.out.println(temp.getSid() + " : " + temp.getName() + "【" + temp.getVote() + "】");
        }
        int num = 10;
        while(num != 0){
            num = InputUtil.getInt("请输入班长候选人代号（数字0结束）：");
            if(num != 0){
                if(!this.voteService.inc(num)){
                    System.out.println("此选票无效，请输入正确的候选人代号！");
                }
            }

        }
        System.out.println("投票最终结果： ");
        stu = this.voteService.result();
        System.out.println(stu[0].getName() + "同学，以" + stu[0].getVote() + "票数当选班长。");
    }

}