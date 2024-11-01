import java.util.Scanner;

public class Admin implements User{

    private String username;
    private String password;

    Admin(String name, String password){
        this.username = name;
        this.password = password;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Administrator Portal!");

        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        int flag1 = 0;
        for(int i = 0; i < User.admin_list.size(); i++) {
            if (User.admin_list.get(i).getUserName().equals(name) && User.admin_list.get(i).getPassword().equals(password)) {
                flag1 = 1;
                break;
            }
        }

        if(flag1 == 0){
            System.out.println("You do not have an admin access");
        }

        else{
            while(true){
                System.out.println("Hi " + name + "!\n");

                System.out.println("1. Manage Menu");
                System.out.println("2. Manage Orders");
                System.out.println("3. Generate report");
                System.out.println("4. Back");
                System.out.print("Enter Your Choice: ");

                int choice = scanner.nextInt();

                if(choice == 1){

                    while(true){
                        System.out.println("1. Add Items");
                        System.out.println("2. Update Existing Items");
                        System.out.println("3. Remove Items");
                        System.out.println("4. Back");
                        System.out.print("Enter Your Choice: ");

                        int choice2 = scanner.nextInt();
                        if(choice2 == 1){

                        }

                        else if(choice2 == 2){

                        }

                        else if(choice2 == 3){

                        }

                        else if(choice2 == 4){
                            break;
                        }

                        else{
                            System.out.println("Invalid Choice");
                        }
                    }

                }

                else if(choice == 2){
                    while(true){
                        System.out.println("1. View Pending Orders");
                        System.out.println("2. Update Order Status");
                        System.out.println("3. Process Refunds");
                        System.out.println("4. Handle Special Requests");
                        System.out.println("5. Back");
                        System.out.print("Enter Your Choice: ");

                        int choice2 = scanner.nextInt();
                        if(choice2 == 1){

                        }

                        else if(choice2 == 2){

                        }

                        else if(choice2 == 3){

                        }

                        else if(choice2 == 4){

                        }

                        else if(choice2 == 5){
                            break;
                        }

                        else{
                            System.out.println("Invalid Choice");
                        }
                    }
                }

                else if(choice == 3){

                }

                else if(choice == 4){
                    break;
                }

                else{
                    System.out.println("Invalid Choice");
                }
            }
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUserName() {
        return username;
    }
}