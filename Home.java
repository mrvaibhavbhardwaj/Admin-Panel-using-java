package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    JButton add, view, update, remove;

    Home() {
        setLayout(null);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        // Heading
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(120, 120, 500, 40); // Shifted more to the left
        heading.setFont(new Font("TAHOMA", Font.BOLD, 30));
        heading.setForeground(Color.WHITE);
        image.add(heading);

        // Buttons - Shifted towards the center-left
        add = new JButton("ADD EMPLOYEE");
        add.setBounds(200, 180, 200, 40); // Shifted left
        add.addActionListener(this);
        image.add(add);

        view = new JButton("VIEW EMPLOYEES");
        view.setBounds(200, 240, 200, 40); // Aligned below 'Add'
        view.addActionListener(this);
        image.add(view);

        update = new JButton("UPDATE EMPLOYEE");
        update.setBounds(200, 300, 200, 40); // Aligned below 'View'
        update.addActionListener(this);
        image.add(update);

        remove = new JButton("REMOVE EMPLOYEE");
        remove.setBounds(200, 360, 200, 40); // Aligned below 'Update'
        remove.addActionListener(this);
        image.add(remove);

        // Frame Properties
        setSize(1120, 630);
        setVisible(true);
        setLocation(250, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();
        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();
        } else if (ae.getSource() == update) {
            new ViewEmployee();
        } else{
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}