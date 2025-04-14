package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener{
    
    
    Splash(){
        
        getContentPane().setBackground(Color.black);
        setLayout(null);
        JLabel heading = new JLabel("MY PROJECT ON: ");
        heading.setBounds(330, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.BOLD, 60));
        heading.setForeground(Color.white);
        add(heading);
                
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);
        
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(40, 400, 300, 70);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.setFont(new Font("Arial", Font.BOLD, 20));
        clickhere.setFocusPainted(false);
        clickhere.addActionListener(this);
        image.add(clickhere);
        
        
        setSize(1170, 650);
        setLocation(200, 50);
        setVisible(true);
        
        
        while(true){
            heading.setVisible(false);
            try{
                Thread.sleep(700);
            } catch(InterruptedException e){
                
            }
            heading.setVisible(true);
            try{
                Thread.sleep(500);
            } catch(Exception e){
                
            }
            
         }
    }

    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
        
    }
    
    public static void main(String[] args) {
    new Splash();
    }
    
}