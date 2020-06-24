package example;

import java.util.Arrays;

public class VoteServiceImpl implements IVoteService{
    private StudentMentor [] studentMentors = new StudentMentor[] {
            new StudentMentor(1,"张三",0),
            new StudentMentor(2,"李四",0),
            new StudentMentor(3,"王五",0),
            new StudentMentor(4,"赵六",0),
    };
    @Override
    public boolean inc(long sid) {
        for(int x = 0; x < studentMentors.length; x++){
            if(this.studentMentors[x].getSid() == sid){
                this.studentMentors[x].setVote(this.studentMentors[x].getVote()+1);
                return true;
            }
        }
        return false;
    }

    @Override
    public StudentMentor[] getData() {
        return this.studentMentors;
    }

    @Override
    public StudentMentor[] result() {
        Arrays.sort(this.studentMentors);
        return this.studentMentors;
    }
}
