public class Customer implements User{

    protected boolean vip;
    private String name;
    private String password;

    Customer(String name,String password){
        this.name = name;
        this.password = password;
        this.vip = false;
    }

    public static void main(String[] args){

    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUserName() {
        return "";
    }
}
