package electricitybilling;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class userhome extends JFrame implements ActionListener {
    JButton b1;
    JTextArea a1;
    userhome(){
        super("Home");
        JPanel p = new JPanel();
        
        a1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(a1);
        a1.setFont(new Font("Senserif",Font.ITALIC,18));
        a1.setBackground(Color.orange);
        b1=new JButton("Get Bill");
        b1.addActionListener(this);
        b1.setPreferredSize(new Dimension(100, 40));
        b1.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        setLayout(new BorderLayout());
        add(p,BorderLayout.SOUTH);
        p.add(b1);
        add(jsp,"Center");
        setSize(1000,500);
        setLocation(600,400);
        setVisible(true);
        
        a1.setText("                                                                               YOUR DETAILS");
        try{
            connect c = new connect();
            
            
            ResultSet rs = c.s.executeQuery("select * from user where usrname='Chandler'");
            if(rs.next()){
                a1.append("\n Name : "+rs.getString("name"));
                a1.append("\n Phone : "+rs.getString("phone"));
                a1.append("\n Meter Number : "+rs.getString("meter_no"));
                a1.append("\n State : "+rs.getString("state"));
                a1.append("\n Email ID : "+rs.getString("email"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            new seebill().setVisible(true);
            this.setVisible(false);
        }
        
        
    }

    public static void main(String[]args){
        new userhome().setVisible(true);
    }
    
}
