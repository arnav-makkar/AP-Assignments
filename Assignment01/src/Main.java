import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        System.out.println("0: Student");
        System.out.println("1: Professors");
        System.out.println("2: Administrators");
        System.out.println("9: Quit");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the login option: ");
        int number = scanner.nextInt();  // Read integer input


        switch(number){
            case 0:
                Student_Functionalities.main(null);  // Call the Student class
                break;
            case 1:
                Prof_Functionalities.main(null);  // Call the Professor class
                break;
            case 2:
                Admin_Functionalities.main(null);  // Call the Administrator class
                break;
            case 9:
                System.out.println("Exiting the system...");
                break;
            default:
                System.out.println("Invalid option, please try again.");
                break;
        }

        System.exit(0);
    }
}