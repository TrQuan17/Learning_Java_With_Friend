/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import static action.TinTucAction.isExistSQL;
import exception.NumberException;
import exception.WordException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Quan
 */
public class HoaAction {
    private static Statement st;
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
            int id = inputPossitiveInt("Nhap id hien thi:");
            ResultSet rs = st.executeQuery("SELECT * FROM loaihoa WHERE id > " + id);
            while(rs.next()) {
                System.out.printf("%-2s | ",rs.getInt("id")+"");
                System.out.println(rs.getString("tenhoa"));
            }
            
        } catch(Exception e) {
            System.out.println("Khong the lay du lieu!");
        }
    }
    
    public void UpdateHoa() {
        int id = inputPossitiveInt("Nhap id hoa can chinh sua: ");
        if(isExistSQL(id)) {
            String update = initString("Nhap thong tin can cap nhat: ");
            try {
                st.executeUpdate("UPDATE loaihoa SET tenhoa = '"
                        + update 
                        + "' WHERE id = " + id);
            } catch(Exception e) {
                System.out.println("Khong the cap nhat!");
            }
        } else {
            System.out.println("ID khong ton tai!");
        }
    }
    
    public void SearchHoa() {
        try {
            String search = initString("Nhap thong tin can tim kiem: ");
            ResultSet rs = st.executeQuery("SELECT * FROM loaihoa "
                    +"WHERE tenhoa LIKE '%"+ search +"%'");
            boolean check = false;
            while(rs.next()) {
                check = true;
                System.out.printf("%-2s | ",rs.getInt("id")+"");
                System.out.println(rs.getString("tenhoa"));
            }
            if(!check) {
                System.out.println("Khong tim thay!");
            }
        } catch(Exception e) {
            System.out.println("Khong the lay du lieu!");
        }
    }
    
    public void DeleteHoa() {
        int id = inputPossitiveInt("Nhap id can xoa: ");
        try {
            st.executeUpdate("DELETE FROM loaihoa WHERE id = " + id);
            System.out.println("Da xoa id = " + id);
        } catch(Exception e) {
            System.out.println("Khong the xoa du lieu!");
        }
    }
    
    public void CountHoa() {
        try {
            int id = inputPossitiveInt("Nhap id de dem:");
            
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM loaihoa WHERE id > " + id);
            
            if(rs.first()) {
                System.out.println("So loai hoa tu id = " + id + ": " + rs.getInt("total"));
            } else {
                System.out.println("Danh sach trong!");
            }
            
        } catch (Exception ex) {
            System.out.println("Khong the lay du lieu!");
        }
    }
    
    static boolean isExistSQL(int id) {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM loaihoa");
            while(rs.next()) {
                if(id == rs.getInt("id")) {
                    return true;
                }
            }
            
            return false;
        } catch(Exception e) {
            return false;
        }
    }
    
    static String initString(String mess){
        while(true) {
            try {
                System.out.println(mess);
                Scanner scan = new Scanner(System.in);
                String str = scan.nextLine();

                Pattern p = Pattern.compile("^[A-Za-z-\\s]{2,100}$");
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
