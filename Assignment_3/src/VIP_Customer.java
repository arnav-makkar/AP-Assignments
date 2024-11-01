public class VIP_Customer extends Customer {
    VIP_Customer(String name, String password){
        super(name, password);
        this.vip = true;
    }
}