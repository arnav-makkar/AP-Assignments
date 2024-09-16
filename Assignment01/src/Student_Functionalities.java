import java.util.*;

public class Student_Functionalities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Portal!");

        while(true){
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.println("Please choose an option: ");

            int choice_customer_first = scanner.nextInt();
            scanner.nextLine();

            if (choice_customer_first == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                //Polymorphism
                Student new_student = new Student(name, password);
                int user_check;
                user_check = Main.check_customer_type(new_student);
                if (user_check == -1){
                    Human.student_list.add(new_student);
                    Human.student_list.add(new_student);
                    System.out.println("User successfully registered");
                }
                else{
                    System.out.println("User already exists, please login");
                }
            }

            else if (choice_customer_first == 2) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                Student temp_check = new Student(name, password);
                int user_check;
                Student current_user;
                user_check = Main.check_customer_type(temp_check);

                if(user_check == 0){
                    System.out.println("User cannot be found, please Sign-Up first");
                }

                else{
                    current_user = Human.student_list.get(user_check);
                    System.out.println("Hi" + current_user.getUsername());

                    while(true){
                        System.out.println("Please choose any of the following options: ");
                        System.out.print("1. View Available Courses");
                        System.out.print("2. Register for Courses");
                        System.out.print("3. View Schedule");
                        System.out.print("4. Track Academic Progress");
                        System.out.print("5. Drop Courses");
                        System.out.print("6. Submit Complaints");
                        System.out.print("7. Update personal information");
                        System.out.print("8. Back");

                        System.out.print("Enter option: ");

                        int choice_student_second = scanner.nextInt();
                        scanner.nextLine();

                        if (choice_student_second == 1){

                        }

                        else if (choice_student_second == 2) {


                        }

                        else if (choice_student_second == 3) {

                        }

                        else if (choice_student_second == 4) {


                        }

                        else if (choice_student_second == 5) {

                        }

                        else if (choice_student_second == 6) {
                            ComplaintSystem.main(null);
                            break;
                        }

                        else if (choice_student_second == 7) {

                        }

                        else if (choice_student_second == 8) {

                        }
                    }
                }

            }

            else if (choice_customer_first == 3) {
                break;
            }

            else{
                System.out.print("Invalid option, please try again");
            }
        }
    }
}