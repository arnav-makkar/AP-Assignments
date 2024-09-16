import java.util.*;

public class Student_Functionalities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Portal!");

        // Add courses info
        Course IP = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Course DC = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Course LA = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Course HCI = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Course COM = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Data.sem1.addAll(Arrays.asList(IP, DC, LA, HCI, COM));

        Course DSA = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        Course CO = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        Course PnS = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        Course MnB = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        Course CTRSS = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        Course BE = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        Data.sem2.addAll(Arrays.asList(DSA, CO, PnS, MnB, CTRSS, BE));

        Course AP = new Course("Advanced Programming", "CSE201", "Dr. Arun Balaji", "3:00pm-4:30pm on Monday and Wednesday", 3, 4);
        Course OS = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        Course M3 = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        Course DM = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        Course SPP = new Course("Social and Political Philosophy", "SSH221", "Dr. Manohar Kumar", "4:30pm-6:00pm on Monday and Wednesday", 3, 4);
        Course NT = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        Course PASSP = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        Course PDE = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        Data.sem3.addAll(Arrays.asList(AP, OS, M3, DM, SPP, NT, PASSP, PDE));

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
                if (user_check == 0){
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
                    current_user = Human.student_list.get(0); //correct this line
                    System.out.println("Hi " + current_user.getUsername());
                    System.out.println("Enter ongoing semester: ");

                    int curr_sem = scanner.nextInt();
                    scanner.nextLine();

                    while(true){
                        System.out.println("Please choose any of the following options: ");
                        System.out.println("1. View Available Courses");
                        System.out.println("2. Register for Courses");
                        System.out.println("3. View Schedule");
                        System.out.println("4. Track Academic Progress");
                        System.out.println("5. Drop Courses");
                        System.out.println("6. Submit Complaints");
                        System.out.println( "7. Back");

                        System.out.print("Enter option: ");

                        int choice_student_second = scanner.nextInt();
                        scanner.nextLine();

                        if (choice_student_second == 1){

                            int index = curr_sem-1;

                            if(Data.sem_dir.get(index).isEmpty()){
                                System.out.println("No courses are available");
                            }
                            else{
                                for(int i = 0; i<Data.sem_dir.get(index).size(); i++) {
                                    System.out.println(Data.sem_dir.get(index).get(i).name);
                                }
                            }
/*
                            if(curr_sem == 1){
                                if(Data.sem1.isEmpty()){
                                    System.out.println("No courses are available");
                                }

                                else{
                                    for(int i = 0; i<Data.sem1.size(); i++) {
                                        System.out.println(Data.sem1.get(i).toString());
                                    }
                                }
                            }

                            else if(curr_sem == 2){
                                if(Data.sem2.isEmpty()){
                                    System.out.println("No courses are available");
                                }

                                else{
                                    for(int i = 0; i<Data.sem2.size(); i++) {
                                        System.out.println(Data.sem2.get(i).toString());
                                    }
                                }

                            }

                            else if(curr_sem == 3){
                                if(Data.sem3.isEmpty()){
                                    System.out.println("No courses are available");
                                }

                                else{
                                    for(int i = 0; i<Data.sem3.size(); i++) {
                                        System.out.println(Data.sem3.get(i).toString());
                                    }
                                }

                            }

                            else if(curr_sem == 4){
                                if(Data.sem4.isEmpty()){
                                    System.out.println("No courses are available");
                                }

                                else{
                                    for(int i = 0; i<Data.sem4.size(); i++) {
                                        System.out.println(Data.sem4.get(i).toString());
                                    }
                                }
                            }

                            else{
                                break;
                            }

 */
                        }

                        else if (choice_student_second == 2) {

                            int index = curr_sem-1;

                            if(Data.sem_dir.get(index).isEmpty()){
                                System.out.println("No courses are available");
                            }
                            else{
                                System.out.println("Choose one of these courses to add: ");
                                for(int i = 0; i<Data.sem_dir.get(index).size(); i++) {
                                    System.out.print(i+1 + ". ");
                                    System.out.println(Data.sem_dir.get(index).get(i).name);
                                }
                            }

                            // implement credit system here

                            System.out.print("Enter the course you want to add: ");
                            int c_ind = scanner.nextInt();
                            scanner.nextLine();

                            current_user.courses_taken.add(Data.sem_dir.get(index).get(c_ind-1));

                            System.out.println("Course has been added!");
                        }

                        else if (choice_student_second == 3) {
                            if(current_user.courses_taken.isEmpty()){
                                System.out.println("No courses are available");
                            }

                            else{
                                for(int i = 0; i<current_user.courses_taken.size(); i++) {
                                    System.out.println(current_user.courses_taken.get(i).name + ": " + current_user.courses_taken.get(i).timings);
                                }
                            }
                        }

                        else if (choice_student_second == 4) {
                            // NA
                        }

                        else if (choice_student_second == 5) {
                            if(current_user.courses_taken.isEmpty()){
                                System.out.println("No courses are available");
                            }

                            else{
                                for(int i = 0; i<current_user.courses_taken.size(); i++) {
                                    System.out.print(i+1 + ". ");
                                    System.out.println(current_user.courses_taken.get(i).name);
                                }

                                System.out.print("Enter the course you want to drop: ");
                                int drop_ind = scanner.nextInt();
                                scanner.nextLine();

                                current_user.courses_taken.remove(drop_ind-1);

                                System.out.println("Course has been dropped!");
                            }
                        }

                        else if (choice_student_second == 6) {
                            ComplaintSystem.main(null);
                        }

                        else if (choice_student_second == 7) {
                            break;
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