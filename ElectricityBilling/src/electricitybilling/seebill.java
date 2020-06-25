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

public class seebill extends JFrame implements ActionListener{
    JLabel l2;
    JTextArea t1;
    JButton b1,b2;
    JTextField c3;
    Choice c2;
    JPanel p1,p2;
    seebill(){
        setSize(700,900);
        setLayout(new BorderLayout());
        
        p1 = new JPanel();
        p2 = new JPanel();
       
        l2 = new JLabel("Meter Number:");
        c2 = new Choice();
        c3 = new JTextField("",5);
        
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");

        
        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        t1.setBackground(Color.cyan);
        b1 = new JButton("Get Bill");
        b2 = new JButton("Back");
        
        
        p1.add(l2);
        p1.add(c3);
        p1.add(c2);
        add(p1,"North");
        
        add(jsp,"Center");
        p2.add(b1);
        p2.add(b2);
        add(p2,"South");
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLocation(350,40);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                connect c = new connect();
                ResultSet rs = c.s.executeQuery("select * from bill where meter_no='"+c3.getText()+"' and month='"+c2.getSelectedItem()+"'");
                if(rs.next()){
                    t1.append(rs.getString("bill"));
                }
                

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            new userhome().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new seebill().setVisible(true);
    }
}

