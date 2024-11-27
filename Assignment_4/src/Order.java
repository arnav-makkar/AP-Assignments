import java.util.*;

public class Order {
    static PriorityQueue<Order> regular_active_orders = new PriorityQueue<>();
    static PriorityQueue<Order> vip_active_orders = new PriorityQueue<>();

    static ArrayList<Order> all_orders = new ArrayList<>();

    private String status;
    private LinkedHashMap<Product, Integer> order;
    private String special_req;
    static ArrayList<String> status_list = new ArrayList<>(Arrays.asList("Order Received", "Preparing", "Out for Delivery", "Order Cancelled", "Refund Initiated", "Order Denied", "Order Delivered"));
    private Customer customer;

    Order(LinkedHashMap<Product, Integer> order, Customer customer){
        this.order = order;
        this.status = status_list.get(0);
        this.customer = customer;
    }

    public void printOrder(){
        String ordr_type = "Regular";
        if(customer.vip) ordr_type = "VIP";

        System.out.println("Customer Name: " + customer.getUserName());
        System.out.println("Order Type: " + ordr_type);
        System.out.println("Order Status: " + status);
        System.out.println("Order Contents: ");

        System.out.printf("%-5s %-15s %-10s%n", "S.No.", "Product", "Quantity");

        int i = 1;
        for(Map.Entry<Product, Integer> entry : order.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            System.out.printf("%-5d %-15s %-10d%n", i, product.getName(), quantity);
            i++;
        }
    }

    public String printOrderString() {
        StringBuilder orderDetails = new StringBuilder();

        String orderType = customer.vip ? "VIP" : "Regular";

        orderDetails.append("Customer Name: ").append(customer.getUserName()).append("\n");
        orderDetails.append("Order Type: ").append(orderType).append("\n");
        orderDetails.append("Order Status: ").append(status).append("\n");
        orderDetails.append("Order Contents: \n");

        // Format the header for the order table
        orderDetails.append(String.format("%-5s %-15s %-10s%n", "S.No.", "Product", "Quantity"));

        // Add each product to the order details
        int i = 1;
        for (Map.Entry<Product, Integer> entry : order.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            // Format the product details
            orderDetails.append(String.format("%-5d %-15s %-10d%n", i, product.getName(), quantity));
            i++;
        }

        // Return the constructed string
        return orderDetails.toString();
    }

    public void Set_special_req(String special_req){
        this.special_req = special_req;
    }

    public String Get_special_req(){
        return special_req;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(int ind){
        this.status = status_list.get(ind);
    }

    public LinkedHashMap<Product, Integer> getOrder(){
        return this.order;
    }
}