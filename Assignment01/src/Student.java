import java.util.*;

public class Student {
    private String password;

    public String name;
    public int sem;

    Student(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return name;
    }
}