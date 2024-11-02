import java.util.*;

public class Order {
    static PriorityQueue<Order> order_list = new PriorityQueue<>();
    static PriorityQueue<Order> vip_order_list = new PriorityQueue<>();

    private String status;
    private LinkedHashMap<Product, Integer> order;
    private ArrayList<String> status_list = new ArrayList<>(Arrays.asList("Order Received", "Order Delivered", "Order Denied", "Order Cancelled"));

    Order(LinkedHashMap<Product, Integer> order){
        this.order = order;
        this.status = status_list.get(0);
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