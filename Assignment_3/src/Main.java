import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // initialise admin 2
        // initialise 2 customers
        // initialise 1 vip

        User admin1 = new Admin("Arnav", "Arnav123");
        User admin2 = new Admin("Aditya", "Aditya123");

        User.admin_list.add(admin1);
        User.admin_list.add(admin2);

        new Customer("Arvind", "Arvind123");
        new Customer("Aditya", "Aditya123");

        new VIP_Customer("Sarthak", "Sarthak123");

        while(true) {
            System.out.println("Welcome to Byte Me!");

            System.out.println("1. Login as Customer");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");

            int choice1 = scanner.nextInt();
            scanner.nextLine();

            if(choice1 == 1) {
                Customer.main(null);
            }

            else if(choice1 == 2) {
                Admin.main(null);
            }

            else if(choice1 == 3) {
                System.out.println("Exiting!");
                System.exit(0);
            }
        }
    }
}