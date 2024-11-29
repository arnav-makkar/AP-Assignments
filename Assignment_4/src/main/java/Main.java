import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ItemNotAvailableError {

        Scanner scanner = new Scanner(System.in);

        Admin admin1 = new Admin("Arnav", "Arnav123");
        Admin admin2 = new Admin("Aditya", "Aditya123");

        User.admin_list.add(admin1);
        User.admin_list.add(admin2);

        Customer cust1 = new Customer("a", "1");
        Customer cust2 = new Customer("Arvind", "Arvind123");

        User.cust_list.add(cust1);
        User.cust_list.add(cust2);

        Customer vip_cust = new Customer("Sarthak", "Sarthak123", true);

        User.cust_list.add(vip_cust);

//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customer.txt", true))) {
//            oos.writeObject(cust1);
//            oos.writeObject(cust2);
//            oos.writeObject(vip_cust);
//        } catch (IOException e) {
//            System.err.println("An error occurred while writing to the file: " + e.getMessage());
//        }

        Product coffee = new Product("Coffee",20);
        Product tea = new Product("Tea",10);
        Product samosa = new Product("Samosa",20);
        Product rajma = new Product("Rajma Chawal",100);
        Product chhole = new Product("Chhole Chawal",120);

        tea.setIs_available(false);
        chhole.setIs_available(false);

        Menu_Item.menu_list.get(0).add(coffee);
        Menu_Item.menu_list.get(0).add(tea);
        Menu_Item.menu_list.get(0).sort(Comparator.comparingDouble(Product::getPrice));
        Menu_Item.menu_list.get(1).add(samosa);
        Menu_Item.menu_list.get(1).sort(Comparator.comparingDouble(Product::getPrice));
        Menu_Item.menu_list.get(2).add(rajma);
        Menu_Item.menu_list.get(2).add(chhole);
        Menu_Item.menu_list.get(2).sort(Comparator.comparingDouble(Product::getPrice));

        while(true) {
            System.out.println("Welcome to Byte Me!");

            System.out.println("1. Login as Customer");
            System.out.println("2. Login as Admin");
            System.out.println("3. Open GUI");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");

            int choice1 = scanner.nextInt();
            scanner.nextLine();

            if(choice1 == 1) {
                Customer.main(null);
            }

            else if(choice1 == 2) {
                Admin.main(null);
            }

            else if (choice1 == 3) {
                GUI.main(null);
            }

            else if(choice1 == 4) {
                System.out.println("Exiting!");
                System.exit(0);
            }

            else{
                System.out.println("Invalid choice");
            }
        }
    }
}