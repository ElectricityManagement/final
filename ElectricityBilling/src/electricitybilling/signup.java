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

public class signup extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    signup(){
        setLocation(350,200);
        setSize(800,700);
        
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));
        
        p.setBackground(Color.CYAN);
        
        l1 = new JLabel("Name");
        t1 = new JTextField(30);
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Phone");
        t2 = new JTextField(10);
        p.add(l2);
        p.add(t2);
        l3 = new JLabel("Meter Number(10000-10011)");
        t3 = new JTextField(5);
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField(20);
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("Set Username");
        t5 = new JTextField(20);
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("Set Password");
        t6 = new JTextField(20);
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Email");
        t7 = new JTextField(30);
        p.add(l7);
        p.add(t7);
        
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.CYAN);
        
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.CYAN);
        
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i3 = ic1.getImage().getScaledInstance(300, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);
        
        
        add(l8,"West");
        //for changing the color of the whole 
        getContentPane().setBackground(Color.CYAN);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            String a = t1.getText();
            String c = t2.getText();
            String d = t3.getText();
            String e = t4.getText();
            String f = t5.getText();
            String g = t6.getText();
            String h = t7.getText();

            try{
                connect c1 = new connect();
                
                c1.s.executeUpdate("insert into userlogin values('"+f+"','"+g+"')");
                c1.s.executeUpdate("insert into user values('"+a+"','"+c+"','"+d+"','"+e+"','"+h+"','"+f+"')");
                JOptionPane.showMessageDialog(null,"New User Created");
                this.setVisible(false);
                new loginuser().setVisible(true);
                this.setVisible(false);
                

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
        
    }
    
    
    public static void main(String[] args){
        new signup().setVisible(true);
    }
}