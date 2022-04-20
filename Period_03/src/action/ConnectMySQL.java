/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.sql.*;

public class ConnectMySQL {
    public static Statement getConnectMySQL(String database) {
        try {
            String url = "jdbc:mysql://localhost:3306/" + database;
            String user_name = "root";
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user_name, "");
            System.out.println("Ket noi MySQL thanh cong!");
            return con.createStatement();
            
        } catch (Exception ex) {
            System.out.println("Khong the ket noi MySQL!");
            return null;
        }
        
    }
}
