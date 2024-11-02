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
        System.out.println("\nWelcome to the Administrator Interface!");

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
                System.out.println("\nHi " + name + "!");

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

                            System.out.print("Select Category: ");

                            System.out.println("1. Beverages");
                            System.out.println("2. Snacks");
                            System.out.println("3. Meals");

                            System.out.print("Enter Your Choice: ");
                            int choice3 = scanner.nextInt();

                            if(choice3 > 3 || choice3 < 1){
                                System.out.println("Invalid Choice");
                            }

                            else{
                                int ind = choice3 - 1;

                                System.out.println("Enter Item Name: ");
                                String itemName = scanner.nextLine();

                                System.out.println("Enter Item Quantity: ");
                                int quantity = scanner.nextInt();

                                System.out.println("Enter Item Price: ");
                                double price = scanner.nextDouble();

                                Product prod = new Product(itemName, price);

                                Menu_Item.menu_list.get(ind).add(prod);

                                System.out.print("Item has been successfully added!");
                            }
                        }

                        else if(choice2 == 2){

                            System.out.print("Select Category: ");

                            System.out.println("1. Beverages");
                            System.out.println("2. Snacks");
                            System.out.println("3. Meals");

                            System.out.print("Enter Your Choice: ");
                            int choice3 = scanner.nextInt();

                            if(choice3 > 3 || choice3 < 1){
                                System.out.println("Invalid Choice");
                            }

                            else{
                                int ind = choice3 - 1;

                                if(Menu_Item.menu_list.get(ind).size() == 0){
                                    System.out.print("No items to display");
                                }

                                else{
                                    for(int i = 0; i<Menu_Item.menu_list.get(ind).size(); i++){
                                        System.out.println(i+1 + ". " + Menu_Item.menu_list.get(ind).get(i).getName());
                                    }

                                    System.out.print("Select Item to edit: ");
                                    int choice4 = scanner.nextInt();

                                    System.out.print("Enter New Name: ");
                                    String newName = scanner.nextLine();

                                    System.out.print("Enter New Price: ");
                                    double newPrice = scanner.nextDouble();

                                    Menu_Item.menu_list.get(ind).get(choice4-1).updateItem(newName, newPrice);

                                    System.out.print("Item details have been successfully updated!");
                                }
                            }

                        }

                        else if(choice2 == 3){

                            System.out.print("Select Category: ");

                            System.out.println("1. Beverages");
                            System.out.println("2. Snacks");
                            System.out.println("3. Meals");

                            System.out.print("Enter Your Choice: ");
                            int choice3 = scanner.nextInt();

                            if(choice3 > 3 || choice3 < 1){
                                System.out.println("Invalid Choice");
                            }

                            else{
                                int ind = choice3 - 1;

                                if(Menu_Item.menu_list.get(ind).size() == 0){
                                    System.out.print("No items to display");
                                }

                                else{
                                    for(int i = 0; i<Menu_Item.menu_list.get(ind).size(); i++){
                                        System.out.println(i+1 + ". " + Menu_Item.menu_list.get(ind).get(i).getName());
                                    }

                                    System.out.print("Select Item to remove: ");
                                    int choice4 = scanner.nextInt();

                                    Menu_Item.menu_list.get(ind).get(choice4-1).setIs_avaliable(false);
                                    Menu_Item.menu_list.get(ind).remove(choice4-1);

                                    System.out.print("Item has been successfully removed!");
                                }
                            }

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

                    System.out.println("\nDaily Sales Report\n");

                    int total_sales = 0;
                    Product item = null;

                    // calc tot sales
                    // calc mpi

                    System.out.println("Total Orders: " + Order.vip_order_list.size()+Order.order_list.size());
                    System.out.println("Total Sales: " + total_sales);
                    System.out.println("Most Popular Product: " + item.getName());
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