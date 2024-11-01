import java.util.*;

class Review<T> {

    public List<T> reviews;

    public Course course;
    public String student_name;

    public Review(Course course, String name) {
        this.student_name = name;
        this.course = course;
        reviews = new ArrayList<>();
    }

    public void addFeedback(T feedback) {
        reviews.add(feedback);
    }

    public void viewFeedback() {
        System.out.println("Name: " + student_name + "\nCourse: " + course.name);
        for (T feedback : reviews) {
            System.out.println(feedback);
        }

        System.out.println();
    }
}
