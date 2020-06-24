package example;

public class UserServiceImpl implements IUserService {
    private int count = 0;
    @Override
    public boolean isExit() {
        return this.count>=3;
    }

    @Override
    public boolean login(String name, String password) {
        this.count++;
        return "binzi".equals(name) && "hello".equals(password);
    }
}
