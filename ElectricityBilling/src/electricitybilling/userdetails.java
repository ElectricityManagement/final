package electricitybilling;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class userdetails extends JFrame implements ActionListener {
    JTable t1;
    JButton b1;
    JLabel l1;
    JTextField a1;
    JPanel p;
    String x[] = {"Name","Phone","Meter Number","State","E-mail","Username"};
    String y[][] = new String[50][8];
    int i=0, j=0;
    userdetails(){
        super("Customer Details");
        setSize(1200,650);
        setLocation(200,200);
        //l1=new JLabel("enter meterID to search");
        //a1= new JTextField(6);
        p=new JPanel();
        try{
            //electricityBill is my connect class
            connect c1  = new connect();
            //String s=a1.getText();
            //String q  = "select * from details where MeterID = '"+s+"'";
            //ResultSet rs = c1.s.executeQuery(q);
            String s1 = "select * from user";
            ResultSet rs1  = c1.s.executeQuery(s1);
            while(rs1.next()){
                y[i][j++]=rs1.getString("name");
                y[i][j++]=rs1.getString("phone");
                y[i][j++]=rs1.getString("meter_no");
                y[i][j++]=rs1.getString("state");
                y[i][j++]=rs1.getString("email");
                y[i][j++]=rs1.getString("usrname");
                i++;
                j=0;
            }
                t1 = new JTable(y,x);
                /*p.add(l1);
                p.add(a1);
                p.add(t1);
                add(p,BorderLayout.CENTER);*/ // trying to add search option
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Back");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        b1.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new adminhome().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[]args){
        new userdetails().setVisible(true);
    }
    
}