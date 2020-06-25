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

class fframe extends JFrame implements Runnable{
    Thread t1;
    fframe(){
        super("Electricity Billing System");
        setLayout(new FlowLayout());
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image c1=i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon c2=new ImageIcon(c1);
        
        
        JLabel l1 = new JLabel(c2);
        add(l1);
        t1=new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(5000);
            this.setVisible(false);
            
            First l = new First();
            l.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

public class flash {
    public static void main(String[] args){
        fframe f1 = new fframe();
        f1.setVisible(true);
        int x=1;
        for(int i=2;i<=600;i+=4,x+=1){
            f1.setLocation(800-((i+x)/2),500-(i/2));
            f1.setSize(i+x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
    }
}
