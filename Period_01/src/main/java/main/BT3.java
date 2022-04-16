/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import action.DictionaryAction;
import java.util.Scanner;

public class BT3 {
    public static void main(String[] args) {
        String s1 = "----------------------------------------------";
        String s2 = "== TU DIEN ANH VIET - BAI TAP VINAENTER EDU ==";
        
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("--1. Nhap du lieu");
        System.out.println("--2. Xuat du lieu");
        System.out.println("--3. Dich tu");
        System.out.println("--4. Thoat");
        System.out.println(s1);
        
        DictionaryAction dic = new DictionaryAction();
        
        while(true) {
            try {
                System.out.println("Nhap lua chon cua ban: ");
                Scanner scan = new Scanner(System.in);
                int select = scan.nextInt();
                if(select == 4) {
                    System.out.println("Cam on da su dung tu dien!");
                    break;
                }
                switch(select) {
                    case 1:
                        System.out.println("=======NHAP DU LIEU TU DIEN=======");
                        dic.Init();
                        break;
                    case 2:
                        System.out.println("=========HIEN THI TU DIEN=========");
                        dic.ShowDictionary();
                        break;
                    case 3:
                        System.out.println("========TIM KIEM TU VUNG==========");
                        dic.SearchWord();
                        break;
                    default:
                        System.out.println("Lua chon khong hop le!");
                        break;
                }
            } catch(Exception e) {
                System.out.println("Dinh dang nhap khong dung!");
            } 
        }
    }
}
