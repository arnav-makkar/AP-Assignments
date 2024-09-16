import java.util.*;

public interface Human {
    ArrayList<Human> admins = new ArrayList<>();
    ArrayList<Student> student_list = new ArrayList<>();
    String getPassword();
    String getUsername();
}
