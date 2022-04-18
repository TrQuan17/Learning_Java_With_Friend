/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.QuanBai;
import exception.NumberException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Quan
 */
public class QuanBaiAction {
    public static ArrayList<QuanBai> inputInfo() {
        ArrayList<QuanBai> list = new ArrayList<QuanBai>();
                
        int n = InputNumber("Nhap so la bai:", 52);
        
        for(int i = 0; i < n ; i++) {
            System.out.println("La bai " + (i+1) + " :");
            int point = InputNumber("Nhap diem quan bai:", 4);
            int exp = InputNumber("Nhap he so quan bai", 13);
            
            String name = QuanBai.Analysis(point, exp);
            
            QuanBai qb = new QuanBai(name, point, exp);
            
            list.add(qb);
        }
        
        return list;
    }
    
    public static void displayInfo(ArrayList<QuanBai> list) {
        for(QuanBai q : list) {
            System.out.println(q.toString());
        }
    } 
    
    public static int InputNumber(String mess, int end) {
        while(true) {
            try {
               System.out.println(mess);
                
               Scanner scan = new Scanner(System.in);
               int number = scan.nextInt();
               if(number < 1 || number > end) {
                   throw new NumberException("Gia tri khong hop le!");
               } else {
                   return number;
               }
               
            } catch(NumberException e) {
                System.out.println(e.getMessage());
            } catch(Exception e) {
                System.out.println("Dinh dang nhap khong dung!");
            }
        }
    }
}
