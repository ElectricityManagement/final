/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricitybilling;
/**
 *
 * @author Ankur
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
//import electricitybilling.signup;

public class login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2;
    JPanel p1,p2,p3,p4;
    login(){
        super("Login Page");
        
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        tf1 = new JTextField(15);
        pf2 = new JPasswordField(15);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel",new ImageIcon(i2));
        
        b1.addActionListener(this);
        b2.addActionListener(this);


        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("icons/loginicon.png"));
        Image i3 = ic3.getImage().getScaledInstance(128, 160,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        
        /*ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icons/signupimg.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        b3 = new JButton("Sign Up",new ImageIcon(i4));*/
        
        setLayout(new BorderLayout());
        
                
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        
        
        add(l3,BorderLayout.WEST);
        p2.add(l1);
        p2.add(tf1);
        p2.add(l2);
        p2.add(pf2);
        add(p2,BorderLayout.CENTER);
        
        p4.add(b1);
        p4.add(b2);
        //p4.add(b3);
        add(p4,BorderLayout.SOUTH);
        
        p2.setBackground(Color.WHITE);
        p4.setBackground(Color.WHITE);
        
       
        setSize(440,250);
        setLocation(600,400);
        setVisible(true);
        

        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            try{        
                connect c1 = new connect();
                String a  = tf1.getText();
                String b  = pf2.getText();
                String q  = "select * from login where username = '"+a+"' and password = '"+b+"'";
                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new adminhome().setVisible(true);
                    this.setVisible(false);

                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Details");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
            }
        }else if(ae.getSource() == b2){
            System.exit(0);
        } 
    }
    
    public static void main(String[] args){
        new login().setVisible(true);
    }

    
}


