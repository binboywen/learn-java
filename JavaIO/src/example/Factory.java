package example;

public class Factory {
    private Factory(){}
    public static INumberService getInstance(){ return new NumberServiceImpl();}
    public static IFileService getInstanceFileService(){
        return new FileServiceImpl();
    }
    public static IStringService getInstanceStringService() {return new StringServiceImpl();}
    public static IStudentService getInstanceStudentService() {return new StudentServiceImpl();}
    public static IOddEvenService gerInstanceOddEvenService() {return new OddEvenServiceImpl();}
    public static IUserService getInstanceUserService(){return new UserServiceProxy(new UserServiceImpl());}
    public static IVoteService getInstanceVoteService(){return new VoteServiceImpl();}
}
