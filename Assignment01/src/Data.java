import java.util.*;

public class Data {

    static ArrayList<Course> sem1 = new ArrayList<>();
    static ArrayList<Course> sem2 = new ArrayList<>();
    static ArrayList<Course> sem3 = new ArrayList<>();
    static ArrayList<Course> sem4 = new ArrayList<>();


    static ArrayList<ArrayList<Course>> sem_dir = new ArrayList<>(
            Arrays.asList(sem1, sem2, sem3, sem4)
    );
}