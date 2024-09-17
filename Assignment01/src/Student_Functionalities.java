import java.util.*;

public class Student_Functionalities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Portal!");

        // Add courses info
        Course IP = new Course("Introduction to Programming", "CSE101", "Dr. BN Jain", "9:00am-10:30am on Monday and Wednesday", 1, 4);
        Course DC = new Course("Digital Circuits", "ECE111", "Dr. Tammam Tillo", "9:00am-10:30am on Tuesday and Thursday", 1, 4);
        Course LA = new Course("Linear Algebra", "MTH101", "Dr. Samaresh Chatterji", "10:30am-12:00pm on Monday and Wednesday", 1, 4);
        Course HCI = new Course("Human Computer Interaction", "ECE113", "Dr. Rajeev Ratn Shah", "10:30am-12:00pm on Tuesday and Thursday", 1, 4);
        Course COM = new Course("Communication Skills", "COM101", "Dr. Payel Mukherjee", "3:00pm-6:00pm on Wednesday", 1, 4);
        Data.sem1.addAll(Arrays.asList(IP, DC, LA, HCI, COM));

        Course DSA = new Course("Data Structures and Algorithms", "CSE102", "Dr. Arun Balaji", "9:00am-10:30am on Tuesday and Thursday", 2, 4);
        DSA.pre_req = "IP";
        Course CO = new Course("Computer Organisation", "CSE112", "Dr. Sujay Deb", "9:00am-10:30am on Monday and Wednesday", 2, 4);
        Course PnS = new Course("Probability and Statistics", "MTH201", "Dr. Subhajit Ghosechowdhury", "10:30am-12:00pm on Monday and Wednesday", 2, 4);
        Course BE = new Course("Basic Electronics", "ECE113", "Dr. Tammam Tillo", "10:30am-12:00pm on Tuesday and Thursday", 2, 4);
        BE.pre_req = "DC";
        Course MnB = new Course("Money and Banking", "ECO223", "Dr. Kirti Kanjilal", "3:00pm-6:00pm on Wednesday", 2, 4);
        Course CTRSS = new Course("Critical Thinking and Readings in Social Science", "SSH101", "Dr. Aasim Khan", "3:00pm-6:00pm on Wednesday", 2, 4);
        Data.sem2.addAll(Arrays.asList(DSA, CO, PnS, MnB, CTRSS, BE));

        Course AP = new Course("Advanced Programming", "CSE201", "Dr. Arun Balaji", "9:00am-10:30am on Monday and Wednesday", 3, 4);
        AP.pre_req = "IP, DSA";
        Course OS = new Course("Operating Systems", "CSE231", "Dr. Vivek Kumar", "9:00am-10:30am on Tuesday and Thursday", 3, 4);
        OS.pre_req = "CO";
        Course M3 = new Course("Multivatiate Calculus", "MTH203", "Dr. Satish Kumar Pandey", "10:30am-12:00pm on Monday and Wednesday", 3, 4);
        Course DM = new Course("Discrete Mathematics", "CSE121", "Dr. Bapi Chatterjee", "10:30am-12:00pm on Tuesday and Thursday", 3, 4);
        Course NT = new Course("Number Theory", "MTH211", "Dr. Debika Banerjee", "3:00pm-6:00pm on Wednesday", 3, 4);
        Course SPP = new Course("Social and Political Philosophy", "SSH221", "Dr. Manohar Kumar", "3:00pm-6:00pm on Wednesday", 3, 4);
        Course PDE = new Course("Politics in Digital Era", "SSH240", "Dr. Aasim Khan", "3:00pm-6:00pm on Wednesday", 3, 4);
        Course PASSP = new Course("Political Anthropology: State, Subject and Power", "SOC216", "Dr. Deepak Prince", "3:00pm-6:00pm on Wednesday", 3, 4);
        Data.sem3.addAll(Arrays.asList(AP, OS, M3, DM, SPP, NT, PASSP, PDE));

        while(true){
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.println("Please choose an option: ");

            int choice_student_first = scanner.nextInt();
            scanner.nextLine();

            if (choice_student_first == 1) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Set Password: ");
                String password = scanner.nextLine();

                //Polymorphism
                Student new_student = new Student(name, password);
                int user_check;
                user_check = Main.check_student_exists(new_student);
                if (user_check == 0){
                    Human.student_list.add(new_student);
                    System.out.println("User successfully registered");
                }
                else{
                    System.out.println("User already exists, please login");
                }
            }

            else if (choice_student_first == 2) {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                Student temp_check = new Student(name, password);
                int user_check;
                Student current_user;
                user_check = Main.check_student_exists(temp_check);

                if(user_check == 0){
                    System.out.println("User cannot be found, please Sign-Up first");
                }

                else{
                    current_user = Human.student_list.get(0);
                    for(int i = 0; i<Human.student_list.size(); i++){
                        if(Human.student_list.get(i).name == name){
                            current_user = Human.student_list.get(i);
                        }
                    }
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
                        System.out.println("7. Back");

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
                        }

                        else if (choice_student_second == 2) {
                            int index = curr_sem-1;

                            if(current_user.courses_taken.isEmpty()){
                                System.out.println("No courses have been chosen. You can add courses for upto 20 credits");
                            }
                            else if(current_user.courses_taken.size() == 5){
                                System.out.println("You cannot add more courses since courses worth 20 credits have already been added.");
                            }
                            else if(current_user.courses_taken.size() < 5){
                                int num = 20-current_user.courses_taken.size()*4;
                                System.out.println("You have already registered for " + current_user.courses_taken.size()*4 + " credits. You may add courses worth " + num + " credits.");

                                System.out.println("Choose one of these courses to add: ");
                                for(int i = 0; i<Data.sem_dir.get(index).size(); i++) {
                                    System.out.print(i+1 + ". ");
                                    System.out.println(Data.sem_dir.get(index).get(i).name);
                                }
                            }

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
                            if(current_user.grades_assigned == 0){
                                System.out.println("No grade has been assigned yet.\nGrades will be visible once assigned by the Prof");
                            }

                            else{
                                Float sum = 0.0F;
                                Float num = (float)current_user.courses_taken.size();

                                for(int i = 0; i<num; i++) {
                                    sum += current_user.grades_map.get(current_user.courses_taken.get(i));
                                }

                                System.out.println("Your CGPA is: " + sum/num);
                            }
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

            else if (choice_student_first == 3) {
                break;
            }

            else{
                System.out.print("Invalid option, please try again");
            }
        }
    }
}