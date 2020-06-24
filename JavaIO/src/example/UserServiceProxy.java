package example;

public class UserServiceProxy implements IUserService{
    private IUserService userService;
    public UserServiceProxy(IUserService userService){
        this.userService = userService;
    }
    @Override
    public boolean isExit() {
        return this.userService.isExit();
    }
    @Override
    public boolean login(String name, String password) {
        while(!this.isExit()){
            String inputData = InputUtil.getString("请输入信息：");
            if(inputData.contains("/")){
                String [] temp = inputData.split("/");
                if(this.userService.login(temp[0],temp[1])){
                    return true;
                }else{
                    System.out.println("登陆失败，错误的用户名或密码！");
                }
            }else{
                String pwd = InputUtil.getString("请输入密码：");
                if(this.userService.login(inputData,pwd)){
                    return true;
                }else{
                    System.out.println("登陆失败，错误的用户名或密码！");
                }
            }
        }
        return false;
    }
}
