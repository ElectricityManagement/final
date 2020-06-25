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

public class generate extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextArea t1;
    JButton b1,b2;
    JTextField c1,c3;
    Choice c2;
    JPanel p1;
    generate(){
        setSize(700,900);
        setLayout(new BorderLayout());
        
        p1 = new JPanel();
        
        l1 = new JLabel("Units Cosumed:");
        l2 = new JLabel("Meter Number:");
        c2 = new Choice();
        c1 = new JTextField("",5);
        c3 = new JTextField("",10);
        
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
        b1 = new JButton("Generate Bill");
        b2 = new JButton("Back");
        
        p1.add(l2);
        p1.add(c3);
        p1.add(l1);
        p1.add(c1);
        p1.add(c2);
        add(p1,"North");
        
        add(jsp,"Center");
        add(b1,"South");
        add(b2,"West");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLocation(350,40);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                connect c = new connect();

                String month = c2.getSelectedItem();
                t1.setText("\tWeasley Power Limited\nELECTRICITY BILL FOR THE MONTH OF "+month+" ,2020\n\n\n");

                ResultSet rs = c.s.executeQuery("select * from user where meter_no="+c3.getText());

                if(rs.next()){
                    t1.append("\n    Customer Name:"+rs.getString("name"));
                    t1.append("\n    Meter Number:  "+rs.getString("meter_no"));
                    t1.append("\n    Phone:            "+rs.getString("phone"));
                    t1.append("\n    State:                 "+rs.getString("state"));
                    t1.append("\n    Email:                "+rs.getString("email"));
                    t1.append("\n-------------------------------------------------------------");
                    t1.append("\n");
                }

                rs = c.s.executeQuery("select * from meter,meter_type where (meter.type_name=meter_type.type_name) and meter_no="+c3.getText());           
                if(rs.next()){
                    t1.append("\n    Meter Rent:  "+rs.getString("rent"));
                }
                String rent = rs.getString("rent");
                int rent1 = Integer.parseInt(rent);


                rs = c.s.executeQuery("select state_tax.state,tax from user,state_tax where user.state=state_tax.state and meter_no="+c3.getText());
                if(rs.next()){
                    t1.append("\n    Tax in your State:"+rs.getString("tax"));
                }
                String tax = rs.getString("tax");
                int tax1 = Integer.parseInt(tax);

                t1.append("\n    Units Consumed:"+c1.getText());
                t1.append("\n    Price of 1 unit:8");
                String un = c1.getText();
                int unit = Integer.parseInt(un);
                int electricityCost = unit*8;

                int total = rent1 + tax1 + electricityCost;
                String fin = Integer.toString(total);


                t1.append("\n    Electricity Cost:"+electricityCost);
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n    Total Payable:"+fin);
                
                String meter = c3.getText();
                String bill = t1.getText();
                //if(ae.getSource()==b2){
                    c.s.executeUpdate("insert into bill values('"+meter+"','"+month+"','"+bill+"')");
                    JOptionPane.showMessageDialog(null, "Bill Saved");
                //}

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            new adminhome().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new generate().setVisible(true);
    }
}

