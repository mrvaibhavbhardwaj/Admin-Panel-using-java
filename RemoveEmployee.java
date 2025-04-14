package project;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cempId;
    JButton delete, back;
    JLabel lblname, lblphone, lblemail;
    
    RemoveEmployee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);
        
        cempId = new Choice();
        cempId.setBounds(200, 50, 150, 30);
        add(cempId);
        
        // Fetch employee IDs
        try {
            Conn c = new Conn();
            String query = "SELECT empId FROM employees";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cempId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        
        lblname = new JLabel();
        lblname.setBounds(200, 100, 150, 30);
        add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(200, 150, 150, 30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email ID");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(200, 200, 200, 30);
        add(lblemail);
        
        // Load details of the first employee in the choice box
        loadEmployeeDetails(cempId.getSelectedItem());
        
        // Add event listener for dropdown change
        cempId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                loadEmployeeDetails(cempId.getSelectedItem());
            }
        });

        delete = new JButton("DELETE");
        delete.setBounds(80, 300, 100, 30);
        delete.setBackground(Color.RED);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("BACK");
        back.setBounds(220, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/remove.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        setSize(1000, 400);
        setLocation(300, 150);
        setVisible(true);
    }
    
    private void loadEmployeeDetails(String empId) {
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM employees WHERE empId = ?";
            PreparedStatement pstmt = c.c.prepareStatement(query);
            pstmt.setString(1, empId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    Conn c = new Conn();
                    String empId = cempId.getSelectedItem();
                    String query = "DELETE FROM employees WHERE empId = ?";
                    PreparedStatement pstmt = c.c.prepareStatement(query);
                    pstmt.setString(1, empId);
                    pstmt.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Employee deleted successfully!");
                    
                    // Remove deleted employee from dropdown
                    cempId.remove(empId);
                    
                    // Load details of the new first employee in the list
                    if (cempId.getItemCount() > 0) {
                        loadEmployeeDetails(cempId.getSelectedItem());
                    } else {
                        lblname.setText("");
                        lblphone.setText("");
                        lblemail.setText("");
                    }
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
