import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserHome extends JFrame {
    UserHome() {
        setTitle("User Home");
        setLayout(new FlowLayout());
        
        JButton viewButton = new JButton("View Data");
        
        add(viewButton);
        
        viewButton.addActionListener(e -> {
            // Handle view data functionality (e.g., showing user data)
        });
        
        setSize(400, 200);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UserHome();
    }
}
