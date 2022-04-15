/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import action.ThiSinhAction;
import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        ThiSinhAction ds = new ThiSinhAction();
       
        System.out.println("==========QUAN LY THI SINH===========");
        System.out.println("1. Nhap danh sach thi sinh");
        System.out.println("2. Danh sach thi sinh trung tuyen");
        System.out.println("3. Sap xep danh sach thi sinh");
        System.out.println("4. Thoat chuong trinh");
        System.out.println("=====================================");
        
        while(true) {
           try {
               Scanner scan = new Scanner(System.in);
               
               System.out.println("Nhap lua chon: ");
               int select = scan.nextInt();
               
               if(select == 4) break;
               switch(select) {
                   case 1:
                       System.out.println("======NHAP DANH SACH THI SINH======");
                       ds.NhapDS();
                       break;
                   case 2:
                       System.out.println("==DANH SACH THI SINH TRUNG TUYEN===");
                       ds.ShowDS(17);
                       break;
                   case 3:
                       System.out.println("=========SAP XEP DANH SACH=========");
                       ds.SapXep();
                       ds.ShowDS(17);
                       break;
                   default:
                       System.out.println("Lua chon khong dung!");
                       break;
               }
           } catch(Exception e) {
               System.out.println("Dinh dang nhap khong dung!");
           } 
        }
    }
}