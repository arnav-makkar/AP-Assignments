import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Admin admin1 = new Admin("Arnav", "Arnav123");
        Admin admin2 = new Admin("Aditya", "Aditya123");

        User.admin_list.add(admin1);
        User.admin_list.add(admin2);

        Customer cust1 = new Customer("Arvind", "Arvind123");
        Customer cust2 = new Customer("Aditya", "Aditya123");

        User.cust_list.add(cust1);
        User.cust_list.add(cust2);

        Customer vip_cust = new Customer("Sarthak", "Sarthak123", true);

        User.cust_list.add(vip_cust);

        Product coffee = new Product("Coffee", 100, 20);
        Product tea = new Product("Tea", 100, 10);
        Product samosa = new Product("Samosa", 10, 20);
        Product rajma = new Product("Rajma Chawal", 10, 100);

        Menu_Item.menu_list.get(0).add(coffee);
        Menu_Item.menu_list.get(0).add(tea);
        Menu_Item.menu_list.get(1).add(samosa);
        Menu_Item.menu_list.get(2).add(rajma);

        while(true) {
            System.out.println("Welcome to Byte Me!");

            System.out.println("1. Login as Customer");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");

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