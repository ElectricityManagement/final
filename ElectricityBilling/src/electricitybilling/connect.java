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
import java.sql.*;

public class connect {
    Connection c;
    Statement s;
    public connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///electricity","root","hahachandler77");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
