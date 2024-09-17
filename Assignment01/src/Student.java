import java.util.*;

public class Student {
    private String password;
    public String name;

    public int grades_assigned = 0;
    HashMap<Course, Float> grades_map = new HashMap<>();

    Student(String name, String password){
        this.name = name;
        this.password = password;
    }

    public ArrayList<Course> courses_taken = new ArrayList<>();

    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return name;
    }
}