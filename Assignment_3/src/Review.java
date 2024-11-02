import java.util.*;

class Review<T> {

    public List<T> reviews;

    public Product product;
    public String student_name;

    public Review(Product product, String name) {
        this.student_name = name;
        this.product = product;
        reviews = new ArrayList<>();
    }

    public void addFeedback(T feedback) {
        reviews.add(feedback);
    }

    public void viewFeedback() {
        System.out.println("Name: " + student_name + "\nProduct: " + product.name);
        for (T rev : reviews) {
            System.out.println(rev);
        }

        System.out.println();
    }
}