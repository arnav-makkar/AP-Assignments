import java.util.*;

public class Customer implements User{

    protected boolean vip;
    private String name;
    private String password;
    private static LinkedHashMap<Product, Integer> Cart = new LinkedHashMap<>();
    static ArrayList<Order> cust_order = new ArrayList<>();

    Customer(String name, String password){
        this.name = name;
        this.password = password;
        this.vip = false;
    }

    Customer(String name, String password, boolean vip){
        this.name = name;
        this.password = password;
        this.vip = vip;
    }

    public static void displayCatMenu(int ind){
        for(int i = 0; i < Menu_Item.menu_list.get(ind).size(); i++) {
            System.out.println(i + 1 + ". " + Menu_Item.menu_list.get(ind).get(i).getName() + ": " + Menu_Item.menu_list.get(ind).get(i).getPrice());
        }
    }

    public static void printCart(Customer current_user){
        System.out.printf("%-5s %-15s %-10s %-10s%n", "S.No.", "Product", "Quantity", "Price");

        int i = 1;
        for(Map.Entry<Product, Integer> entry : current_user.Cart.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice();

            System.out.printf("%-5d %-15s %-10d Rs. %-10.2f%n", i, product.getName(), quantity, price);
            i++;
        }
    }

    public static int calculateCartTotal(Customer current_user){
        int total = 0;

        for (Map.Entry<Product, Integer> entry : current_user.Cart.entrySet()) {
            Product item = entry.getKey();   // Get the item (key)
            int quantity = entry.getValue();  // Get the quantity (value)
            double price = item.getPrice();   // Assuming MenuItem has a getPrice() method

            total += quantity * price;        // Add quantity * price to the total
        }

        return total;
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to Customer Interface!");

        while(true){
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Back");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Set Password: ");
                String password = scanner.nextLine();

                int flag = 0;
                for(int i = 0; i < User.cust_list.size(); i++) {
                    if (User.cust_list.get(i).getUserName().equals(name) && User.cust_list.get(i).getPassword().equals(password)) {
                        flag = 1;
                        break;
                    }
                }

                if (flag == 0){
                    Customer cust = new Customer(name, password);
                    cust_list.add(cust);
                    System.out.println("User successfully registered");
                }
                else{
                    System.out.println("User already exists, please login");
                }

            }

            else if(choice == 2){

                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Set Password: ");
                String password = scanner.nextLine();


                int flag = 0;
                Customer current_user = null;
                for(int i = 0; i < User.cust_list.size(); i++) {
                    if (User.cust_list.get(i).getUserName().equals(name) && User.cust_list.get(i).getPassword().equals(password)) {
                        flag = 1;
                        current_user = User.cust_list.get(i);
                        break;
                    }
                }

                if (flag == 1){
                    System.out.println("\nHi " + name + "!");

                    while(true){
                        System.out.println("1. Browse Menu");
                        System.out.println("2. View/Update Cart");
                        System.out.println("3. Track Order");
                        System.out.println("4. Submit Review");
                        System.out.println("5. Upgrade to VIP Customer");
                        System.out.println("6. Back");
                        System.out.print("Please choose an option: ");

                        int choice2 = scanner.nextInt();
                        scanner.nextLine();

                        if(choice2 == 1){

                            System.out.print("Select Category: \n");

                            System.out.println("1. Beverages");
                            System.out.println("2. Snacks");
                            System.out.println("3. Meals");

                            System.out.print("Enter Your Choice: ");
                            int choice3 = scanner.nextInt();

                            if(choice3 > 3 || choice3 < 1){
                                System.out.println("Invalid Choice");
                            }

                            else {
                                int ind = choice3 - 1;

                                if(Menu_Item.menu_list.get(ind).size() == 0) {
                                    System.out.print("No items to display");
                                }

                                else{
                                    displayCatMenu(ind);
                                    System.out.println();
                                }
                            }
                        }

                        else if(choice2 == 2){
                            while(true){
                                System.out.println("1. View Cart");
                                System.out.println("2. Add Items to Cart");
                                System.out.println("3. Remove Item from Cart");
                                System.out.println("4. View Total");
                                System.out.println("5. Checkout");
                                System.out.println("6. Back");

                                System.out.print("Enter Your Choice: ");
                                int choice3 = scanner.nextInt();
                                scanner.nextLine();

                                if(choice3 == 1){
                                    if (current_user.Cart.isEmpty()){
                                        System.out.println("No items to display");
                                    }
                                    else{
                                        printCart(current_user);
                                    }
                                }

                                else if(choice3 == 2){

                                    System.out.print("Select Category: \n");

                                    System.out.println("1. Beverages");
                                    System.out.println("2. Snacks");
                                    System.out.println("3. Meals");

                                    System.out.print("Enter Your Choice: ");
                                    int choice4 = scanner.nextInt();

                                    if(choice4 > 3 || choice4 < 1){
                                        System.out.println("Invalid Choice");
                                    }

                                    else{
                                        int ind = choice4 - 1;

                                        if(Menu_Item.menu_list.get(ind).size() == 0){
                                            System.out.print("No items to display");
                                        }

                                        else{
                                            displayCatMenu(ind);
                                            System.out.println();

                                            System.out.print("Enter Item to add: ");
                                            int choice5 = scanner.nextInt();
                                            scanner.nextLine();

                                            if(choice5 < 1 || choice5 > Menu_Item.menu_list.get(ind).size()){
                                                System.out.println("Invalid Choice");
                                            }

                                            else{

                                                System.out.print("Enter Quantity: ");
                                                int quantity = scanner.nextInt();
                                                scanner.nextLine();

                                                current_user.Cart.put(Menu_Item.menu_list.get(ind).get(choice5 - 1), quantity);
                                            }
                                        }
                                    }
                                }

                                else if(choice3 == 3){
                                    if (current_user.Cart.isEmpty()){
                                        System.out.println("No items to display");
                                    }
                                    else{
                                        printCart(current_user);

                                        System.out.print("Select item to remove: ");
                                        int item_ind = scanner.nextInt();
                                        scanner.nextLine();

                                        List<Product> items = new ArrayList<>(current_user.Cart.keySet());

                                        if (item_ind > 0 && item_ind <= items.size()) {
                                            Product itemToRemove = items.get(item_ind - 1); // Convert 1-based index to 0-based
                                            current_user.Cart.remove(itemToRemove);          // Remove item from the LinkedHashMap
                                            System.out.println("Item removed successfully.");
                                        }

                                        else{
                                            System.out.println("Invalid item selection.");
                                        }
                                    }
                                }

                                else if(choice3 == 4){

                                    int total = calculateCartTotal(current_user);

                                    System.out.println("Cart Total Payable: Rs." + total);
                                }

                                else if(choice3 == 5){

                                    int total = calculateCartTotal(current_user);

                                    System.out.println("Cart Total Payable: Rs." + total);

                                    System.out.println("Enter UPI ID: ");
                                    scanner.nextLine();
                                    String UPI_ID = scanner.nextLine();

                                    System.out.println("Enter Address: ");
                                    scanner.nextLine();
                                    String address = scanner.nextLine();

                                    Order ordr = new Order(current_user.Cart);

                                    current_user.cust_order.add(ordr);

                                    if(current_user.vip){
                                        Order.order_list.add(ordr);
                                    }
                                    else{
                                        Order.vip_order_list.add(ordr);
                                    }

                                    System.out.println("Order Successful!");
                                }

                                else if(choice3 == 6){
                                    break;
                                }

                                else{
                                    System.out.println("Invalid Choice");
                                }
                            }
                        }

                        else if(choice2 == 3){

                            while(true){
                                System.out.println("1. View Order Status");
                                System.out.println("2. Cancel Order");
                                System.out.println("3. View Order History");
                                System.out.println("4. Back");
                                System.out.print("Enter Your Choice: ");

                                int choice3 = scanner.nextInt();
                                scanner.nextLine();

                                if(choice3 == 1){
                                    System.out.println("Order Status: " + current_user.cust_order.getLast().getStatus());
                                }

                                else if(choice3 == 2){
                                    current_user.cust_order.getLast().setStatus(3);

                                    System.out.println("Your order has been cancelled!");
                                }

                                else if(choice3 == 3){

                                    if(current_user.cust_order.isEmpty()){
                                        System.out.println("No items to display");
                                    }

                                    else{
                                        for (int i = 0; i < current_user.cust_order.size(); i++){

                                            System.out.printf("%-5s %-15s %-10s %-10s%n", "S.No.", "Product", "Quantity", "Price");

                                            int j = 1;
                                            Map<Product, Integer> order = current_user.cust_order.get(i).getOrder();
                                            for(Map.Entry<Product, Integer> entry : order.entrySet()) {
                                                Product product = entry.getKey();
                                                int quantity = entry.getValue();
                                                double price = product.getPrice();

                                                System.out.printf("%-5d %-15s %-10d $%-10.2f%n", j, product.getName(), quantity, price);
                                                j++;
                                            }
                                        }

                                        System.out.println();
                                    }

                                }

                                else if(choice3 == 4){
                                    break;
                                }

                                else{
                                    System.out.println("Invalid Choice");
                                }
                            }
                        }

                        else if(choice2 == 4){
                            // review
                        }

                        else if(choice2 == 5){

                            if(current_user.vip){
                                System.out.println("You are already a VIP Customer");
                            }

                            else{
                                while(true){
                                    System.out.println("1. Become VIP Customer by paying Rs. 250");
                                    System.out.println("2. Back");
                                    System.out.print("Enter Option: ");

                                    int choice3 = scanner.nextInt();

                                    if(choice3 == 1){
                                        System.out.print("Enter UPI ID: ");
                                        scanner.nextLine();
                                        String temp = scanner.nextLine();

                                        System.out.println("Transaction succcessful!");
                                        System.out.println("You are now a VIP Customer\n");

                                        current_user.vip = true;

                                        break;
                                    }

                                    else if(choice3 == 2){
                                        break;
                                    }

                                    else{
                                        System.out.println("Invalid Choice");
                                    }
                                }
                            }
                        }

                        else if(choice2 == 6){
                            break;
                        }

                        else{
                            System.out.println("Invalid option");
                        }
                    }
                }

                else{
                    System.out.println("Incorrect Username or Password entered");
                }
            }

            else if(choice == 3){
                break;
            }

            else{
                System.out.println("Invalid choice");
            }
        }
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUserName() {
        return name;
    }
}