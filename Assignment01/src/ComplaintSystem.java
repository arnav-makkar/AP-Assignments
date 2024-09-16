import java.util.*;

class Complaint {
    private int complaintID;
    private String studentID;
    private String description;
    private String status;


    public Complaint(int complaintID, String studentID, String description) {
        this.complaintID = complaintID;
        this.studentID = studentID;
        this.description = description;
        this.status = "Pending";  // Default status is "Pending"
    }

    // Getter and Setter methods
    public int getComplaintID() {
        return complaintID;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display complaint details
    public void displayComplaint() {
        System.out.println("Complaint ID: " + complaintID);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println();
    }
}

public class ComplaintSystem {
    private static ArrayList<Complaint> complaints = new ArrayList<>();
    private static int complaintCounter = 1000;  // To generate unique complaint IDs

    // Method to generate a new complaint ID
    public static int generateComplaintID() {
        return ++complaintCounter;
    }

    // Method for students to submit complaints
    public static void submitComplaint(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("Enter Complaint Description: ");
        String description = sc.nextLine();

        // Generate unique complaint ID and create new complaint
        Complaint newComplaint = new Complaint(generateComplaintID(), studentID, description);
        complaints.add(newComplaint);

        System.out.println("Complaint submitted successfully with ID: " + newComplaint.getComplaintID());
    }

    // Method to view complaints for a particular student
    public static void viewComplaints(Scanner sc) {
        System.out.print("Enter Username: ");
        String studentID = sc.nextLine();

        System.out.println("Complaints for Student ID: " + studentID);
        boolean found = false;
        for (Complaint complaint : complaints) {
            if (complaint.getStudentID().equals(studentID)) {
                complaint.displayComplaint();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No complaints found for this student ID.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while(true) {
            System.out.println("Complaint System Menu:");
            System.out.println("1. Submit Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    submitComplaint(scanner);
                    break;
                case 2:
                    viewComplaints(scanner);
                    break;
                case 3:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            break;
        }
        //scanner.close();
    }
}