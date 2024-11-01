import java.util.*;

public interface User {

    // store user list
    // store admin list
    // store vip
    ArrayList<User> admin_list = new ArrayList<>();

    String getUserName();
    String getPassword();
}
