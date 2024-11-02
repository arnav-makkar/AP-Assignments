public class Product extends Menu_Item{

    private int quantity;
    private double price;

    Product(String name, int quantity, double price) {
        super(name);

        this.quantity = quantity;
        this.price = price;
    }

    public void updateItem(String name, int quantity, double price){
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public String getName() {
        return this.name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {this.quantity = quantity;}
}