public class Product extends Menu_Item{

    private double price;
    private boolean is_available;

    Product(String name, double price) {
        super(name);

        this.price = price;
        this.is_available = true;
    }

    Product(String name, double price, boolean is_available) {
        super(name);

        this.price = price;
        this.is_available = is_available;
    }

    public void updateItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = this.is_available;
    }

    public boolean getIs_avaliable() {
        return this.is_available;
    }

    public double getPrice() {
        return price;
    }
}