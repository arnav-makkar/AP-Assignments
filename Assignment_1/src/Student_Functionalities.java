import java.util.*;

public class Student_Functionalities implements Data, Human{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Portal!");

        Student Arnav_Makkar = new Student("Arnav Makkar", "Arnav1234");
        Student Aditya_Singh = new Student("Aditya Singh", "Aditya1234");
        Student Rushil_Singha = new Student("Rushil Singha", "Rushil1234");

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

                Student new_student = new Student(name, password);
                int user_check;
                user_check = User.check_user_exists(new_student);
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
                user_check = User.check_user_exists(temp_check);

                if(user_check == 0){
                    System.out.println("User cannot be found, please Sign-Up first");
                }

                else{
                    current_user = Human.student_list.getFirst();
                    for(int i = 0; i<Human.student_list.size(); i++){
                        if(Objects.equals(Human.student_list.get(i).name, name)){
                            current_user = Human.student_list.get(i);
                        }
                    }
                    System.out.println("Hi " + current_user.getUsername());

                    while(true){
                        System.out.println("Please choose any of the following options: ");
                        System.out.println("1. View Available Courses");
                        System.out.println("2. Register for Courses");
                        System.out.println("3. View Schedule");
                        System.out.println("4. Track Academic Progress");
                        System.out.println("5. Drop Courses");
                        System.out.println("6. Complaints Portal");
                        System.out.println("7. Back");

                        System.out.print("Enter option: ");

                        int choice_student_second = scanner.nextInt();
                        scanner.nextLine();

                        if (choice_student_second == 1){

                            System.out.println("Enter ongoing semester: ");

                            int curr_sem = scanner.nextInt();
                            scanner.nextLine();

                            int index = curr_sem-1;

                            if(Data.sem_dir.get(index).isEmpty()){
                                System.out.println("No courses are available");
                            }
                            else{
                                for(int i = 0; i<Data.sem_dir.get(index).size(); i++) {
                                    System.out.print(i+1 + ". ");
                                    System.out.println(Data.sem_dir.get(index).get(i).name);

                                    if(Data.sem_dir.get(index).get(i).pre_req != null){
                                        System.out.println("Pre-requisites: " + Data.sem_dir.get(index).get(i).pre_req);
                                    }

                                    if(Data.sem_dir.get(index).get(i).misc_info != null){
                                        System.out.println("Other information: " + Data.sem_dir.get(index).get(i).misc_info);
                                    }
                                }
                            }
                            System.out.println();
                        }

                        else if (choice_student_second == 2) {
                            System.out.println("Enter ongoing semester: ");

                            int curr_sem = scanner.nextInt();
                            scanner.nextLine();

                            int index = curr_sem-1;

                            if((current_user.courses_taken.size() == 5)){
                                System.out.println("You cannot add more courses since courses worth 20 credits have already been added.");
                            }

                            else{
                                if(current_user.courses_taken.isEmpty()){
                                    System.out.println("No courses have been chosen. You can add courses for upto 20 credits");
                                }

                                else if(current_user.courses_taken.size() < 5){
                                    int num = 20-current_user.courses_taken.size()*4;
                                    System.out.println("You have already registered for " + current_user.courses_taken.size()*4 + " credits. You may add courses worth " + num + " credits.");
                                }

                                System.out.println("Choose one of these courses to add: ");
                                for(int i = 0; i<Data.sem_dir.get(index).size(); i++) {
                                    System.out.print(i+1 + ". ");
                                    System.out.println(Data.sem_dir.get(index).get(i).name);
                                }

                                System.out.print("Enter the course you want to add: ");
                                int c_ind = scanner.nextInt();
                                scanner.nextLine();

                                if(Data.sem_dir.get(index).get(c_ind-1).pre_req != null){

                                    System.out.println("Have you completed: " + Data.sem_dir.get(index).get(c_ind-1).pre_req);
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    System.out.print("Enter option: ");

                                    int option = scanner.nextInt();
                                    scanner.nextLine();

                                    if(option == 1){
                                        current_user.courses_taken.add(Data.sem_dir.get(index).get(c_ind-1));

                                        System.out.println("Course has been added!");
                                        System.out.println();
                                    }

                                    else{
                                        System.out.println("The course cannot be added since all pre-requisites aren't met");
                                    }
                                }

                                else if(Data.sem_dir.get(index).get(c_ind-1).pre_req == null){
                                    current_user.courses_taken.add(Data.sem_dir.get(index).get(c_ind-1));

                                    System.out.println("Course has been added!");
                                    System.out.println();
                                }
                            }
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
                            System.out.println();
                        }

                        else if (choice_student_second == 4) {
                            if(current_user.grades_assigned == 0){
                                System.out.println("No grade has been assigned yet.\nGrades will be visible once assigned by the Admin");
                            }

                            else{
                                float sum = (float) 0.0;
                                float num = (float)current_user.courses_taken.size();

                                System.out.println("Your course-wise grades are as follows: ");

                                for(int i = 0; i<num; i++) {
                                    Float grade = current_user.grades_map.get(current_user.courses_taken.get(i));
                                    sum += grade;
                                    System.out.println(current_user.courses_taken.get(i).name + ": " + grade);
                                }

                                System.out.println("Your CGPA is: " + sum/num);
                            }
                            System.out.println();
                        }

                        else if (choice_student_second == 5) {
                            if(current_user.courses_taken.isEmpty()){
                                System.out.println("No courses has been taken yet");
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
                            System.out.println();
                        }

                        else if (choice_student_second == 6) {
                            ComplaintSystem.main(current_user.name);
                            System.out.println();
                        }

                        else if (choice_student_second == 7) {
                            System.out.println("Exiting student...");
                            System.out.println();
                            break;
                        }

                        else {
                            System.out.println("Invalid choice, please try again.");
                        }
                    }
                    break;
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