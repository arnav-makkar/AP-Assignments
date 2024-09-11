import java.util.Scanner;

class Account{
    public String name;
    private String password;

    public Account(String password) {
        this.password = "prof@123";
    }

    public String getPassword(){
        return this.password;
    }
}

class Prof1{
    public static void main(String[] args) {
        System.out.println("reached");
    }
}


public class Prof_Functionalities {
    public static void main(String[] args) {
        System.out.println("Welcome to the Professor Portal!");
        System.out.println("Password: prof@123");

        Account profAccount = new Account("prof@123");

        Scanner scanner = new Scanner(System.in);
        String enteredPassword;

        while (true) {
            System.out.print("Enter password: ");
            enteredPassword = scanner.nextLine();

            if (enteredPassword.equals(profAccount.getPassword())) {
                Prof1.main(null);  // Navigate to Prof1 functionality if password is correct
                break;  // Exit the loop after successful login
            } else {
                System.out.println("Incorrect password, please try again.");
            }
        }
    }
}
