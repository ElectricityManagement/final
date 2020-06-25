package electricitybilling;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class adminhome extends JFrame implements ActionListener {
    
    JButton b1,b2,b3;
    adminhome(){
        super("Admin");
        JPanel p = new JPanel();
        
        b1=new JButton("View Users");
        b2=new JButton("Generate a Bill");
        b3=new JButton("Delete a User");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.setPreferredSize(new Dimension(116, 40));
        b2.setPreferredSize(new Dimension(116, 40));
        b3.setPreferredSize(new Dimension(116, 40));
        b1.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b2.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(new BorderLayout());
       
        add(p,BorderLayout.CENTER);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        
        setSize(400,250);
        setLocation(600,400);
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            new userdetails().setVisible(true);
            this.setVisible(false);
        }
        else if (e.getSource() == b2){
            new generate().setVisible(true);
            this.setVisible(false);
        }else if(e.getSource()==b3){
            new delete().setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[]args){
        new adminhome().setVisible(true);
    }
    
}
