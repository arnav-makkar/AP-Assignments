import javax.swing.*;
import java.awt.*;

public class GUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Byte Me!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the GUI without terminating the program
        frame.setSize(300, 300); // Adjust size to accommodate three buttons

        // Create buttons
        JButton showMenuButton = new JButton("Browse Menu");
        JButton viewOrdersButton = new JButton("View Pending Orders");
        JButton exitButton = new JButton("Exit");

        // Add actions for the buttons
        showMenuButton.addActionListener(e -> showMenu());
        viewOrdersButton.addActionListener(e -> viewOrders());
        exitButton.addActionListener(e -> frame.dispose()); // Safely close the GUI

        // Create a panel and add buttons to it
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, 10px spacing
        panel.add(showMenuButton);
        panel.add(viewOrdersButton);
        panel.add(exitButton);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }

    private static void showMenu() {
        // Create a text area to display the menu
        JTextArea menuTextArea = new JTextArea(15, 30); // 15 rows, 30 columns
        menuTextArea.setEditable(false); // Make it read-only

        // Build the menu content
        StringBuilder menuContent = new StringBuilder();
        menuContent.append("Beverages:\n");
        menuContent.append(Customer.displayCatMenuString(0)).append("\n\n"); // Assuming these methods return a String
        menuContent.append("Snacks:\n");
        menuContent.append(Customer.displayCatMenuString(1)).append("\n\n");
        menuContent.append("Meals:\n");
        menuContent.append(Customer.displayCatMenuString(2));

        // Set the content in the text area
        menuTextArea.setText(menuContent.toString());

        // Wrap the text area in a scroll pane
        JScrollPane scrollPane = new JScrollPane(menuTextArea);

        // Show the menu in a dialog
        JOptionPane.showMessageDialog(
                null,
                scrollPane,
                "Menu",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private static void viewOrders() {
        // Create a text area to display the orders
        JTextArea ordersTextArea = new JTextArea(15, 30); // 15 rows, 30 columns
        ordersTextArea.setEditable(false); // Make it read-only

        // Build the orders content
        StringBuilder ordersContent = new StringBuilder();
        int cnt = 1;

        // Process VIP active orders
        ordersContent.append("VIP Active Orders:\n");
        for (Order order : Order.vip_active_orders) {
            ordersContent.append(cnt).append(". ");
            ordersContent.append(order.printOrderString()).append("\n"); // Assuming printOrder() returns a String
            cnt++;
        }

        // Process Regular active orders
        ordersContent.append("\nRegular Active Orders:\n");
        for (Order order : Order.regular_active_orders) {
            ordersContent.append(cnt).append(". ");
            ordersContent.append(order.printOrderString()).append("\n");
            cnt++;
        }

        // Set the content in the text area
        ordersTextArea.setText(ordersContent.toString());

        // Wrap the text area in a scroll pane
        JScrollPane scrollPane = new JScrollPane(ordersTextArea);

        // Show the orders in a dialog
        JOptionPane.showMessageDialog(
                null,
                scrollPane,
                "View Orders",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}