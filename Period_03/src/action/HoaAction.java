/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import exception.NumberException;
import exception.WordException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
/**
 *
 * @author Quan
 */
public class HoaAction {
    private Statement st;
    private static final String DATABASE = "shophoa";
    public HoaAction() {
        st = ConnectMySQL.getConnectMySQL(DATABASE);
    }
    
    public void InsertHoa() {
        int n = inputPossitiveInt("Nhap so loai hoa:");
        for(int i = 0; i < n; i++) {
            String nameHoa = initString("Nhap ten hoa: ");
            try {
                st.executeUpdate("INSERT INTO loaihoa(tenhoa) VALUES('" + nameHoa + "')");
            } catch(Exception e) {
                System.out.println("Khong the them!");
            }
        }
    }
    
    public void ShowDSHoa() {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM loaihoa");
            if(!rs.first()) {
                System.out.println("Danh sach rong!");
            } else {
                while(rs.next()) {
                    System.out.printf("%-2s | ",rs.getInt("id")+"");
                    System.out.println(rs.getString("tenhoa"));
                }
            }
        } catch(Exception e) {
            System.out.println("Khong the lay du lieu!");
        }
    }
    
    static String initString(String mess){
        while(true) {
            try {
                System.out.println(mess);
                Scanner scan = new Scanner(System.in);
                String str = scan.nextLine();

                Pattern p = Pattern.compile("^[A-Za-z\\s]{2,100}$");
                Matcher m = p.matcher(str.strip());
                boolean b = m.find();

                if(b) return str.strip();
                else {
                    throw new WordException("Chuoi nhap khong hop le!");
                }
            } catch(WordException e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
    
    public static int inputPossitiveInt(String mess) {
        while(true) {
            try {
                System.out.println(mess);
                Scanner scan = new Scanner(System.in);
                int n = scan.nextInt();
                if (n < 0) {
                    throw new NumberException("Nhap gia tri lon hon 0!");
                } else {
                    return n;
                }
            } catch(NumberException e) {
                System.out.println(e.getMessage());
            } catch(Exception e) {
                System.out.println("Dinh dang nhap khong dung!");
            }          
        }
    }
}
