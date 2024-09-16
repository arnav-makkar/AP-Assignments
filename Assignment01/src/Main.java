import java.util.*;

public class Main {
    public static void main(String[] args) {

        // polymorphism: create objects here
        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Welcome to the University Course Registration System");

            System.out.println("1: Student");
            System.out.println("2: Professor");
            System.out.println("3: Administrator");
            System.out.println("9: Exit the Application");

            System.out.print("Enter the login option: ");
            int number = scanner.nextInt();  // Read integer input

            if(number == 1){
                Student_Functionalities.main(null);  // Call the Student class
                break;
            }

            else if(number == 2){
                Prof_Functionalities.main(null);  // Call the Professor class
                break;
            }

            else if(number == 3){
                Admin_Functionalities.main(null);  // Call the Administrator class
                break;
            }

            else if(number == 9){
                System.out.println("Exiting the system...");
                System.exit(0);
            }
        }

        System.exit(0);
    }
    static int check_customer_type(Student student){
        int return_val = 0;

        for(int i = 0; i < Human.student_list.size(); i++){
            if(Human.student_list.get(i).getUsername().equals(student.getUsername()) && Human.student_list.get(i).getPassword().equals(student.getPassword())){
                return_val = 1;
                return return_val;
            }
        }
        return return_val;
    }
}