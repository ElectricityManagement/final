package electricitybilling;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class First extends JFrame implements ActionListener {
    JLabel l1,l2;
    JButton b1,b2;
    First(){
        super("Who are you");
        JPanel p = new JPanel();
        l1 = new JLabel("Who are you?");
        add(l1,SwingConstants.CENTER);
        b1=new JButton("Admin");
        b2=new JButton("User");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setPreferredSize(new Dimension(116, 40));
        b2.setPreferredSize(new Dimension(116, 40));
        b1.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        setLayout(new BorderLayout());
        add(l1);
        add(p,BorderLayout.SOUTH);
        p.add(b1);
        p.add(b2);
        
        setSize(400,200);
        setLocation(600,400);
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            new login().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource() == b2){
            new loginuser().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[]args){
        new First().setVisible(true);
    }
    
}
