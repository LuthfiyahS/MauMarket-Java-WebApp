/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class Validate {
    public static boolean checkUser(String nama,String pass) 
    {
        boolean st =false;
        try {

            //loading drivers for mysql
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            //creating connection with the database
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MauMarketDB","pia", "pia");
            PreparedStatement ps = con.prepareStatement("select * from tb_user where nama=? and password=?");
            ps.setString(1, nama);
            ps.setString(2, pass);
            ResultSet rs =ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
