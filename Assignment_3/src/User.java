import java.util.*;

public interface User {

    // store user list
    // store admin list
    // store vip
    ArrayList<Admin> admin_list = new ArrayList<>();
    ArrayList<Customer> cust_list = new ArrayList<>();


    String getUserName();
    String getPassword();
}
