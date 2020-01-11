package dynamicproxy.a.jdk;

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("Add User");
    }
    @Override
    public void updateUser() {
        System.out.println("update User");
    }
}
