package electricitybilling;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


/**
 *
 * @author ASUS
 */
public class delete extends JFrame implements ActionListener {
    
    JButton b1,b2;
    JLabel l;
    JTextField f;
    delete(){
        super("Delete User");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        l = new JLabel("Enetr Username of the user to be deleted : ");
        b1=new JButton("Delete");
        b2=new JButton("Back");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setPreferredSize(new Dimension(116, 40));
        b1.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.setPreferredSize(new Dimension(116, 40));
        b2.setFont(new java.awt.Font("Georgia", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        f = new JTextField("",5);
        
        setLayout(new BorderLayout());
        add(l);
        add(f);
        add(p1,BorderLayout.SOUTH);
        p1.add(b1);
        p1.add(b2);        
        add(p2,BorderLayout.EAST);
        p2.add(f);
        add(p3,BorderLayout.WEST);
        p3.add(l);
        
        
        
        setSize(400,250);
        setLocation(600,400);
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1){
            String m = f.getText();
            try{
                connect c = new connect();
               
                //ResultSet r = c.s.executeQuery("select usrname from user natural join userlogin where meter_no='"+m+"'");
                //c.s.executeUpdate("delete from bill where meter_no='"+m+"'");
                c.s.executeUpdate("delete from user where usrname='"+m+"'");
                c.s.executeUpdate("delete from userlogin where usrname='"+m+"'");
                
                JOptionPane.showMessageDialog(null, "User Deleted Succesfully");
            }catch(Exception e){
                e.printStackTrace();
            }
           
        }else if(ae.getSource()==b2){
            new adminhome().setVisible(true);
            this.setVisible(false);
        }
        
    }

    public static void main(String[]args){
        new delete().setVisible(true);
    }
    
}
