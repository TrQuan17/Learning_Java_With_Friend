/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.ThiSinh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Quan
 */
public class ThiSinhAction {
    ArrayList<ThiSinh> DS;

    public ThiSinhAction() {
        this.DS = new ArrayList<ThiSinh>();
    }
    
    public void NhapDS() {
        int SoThiSinh = NhapSoThiSinh();
        for(int i = 0; i < SoThiSinh; i++) {
            ThiSinh ts = new ThiSinh();
            ts.setTenTh(NhapTen("Nhap ten thi sinh: "));

            double toan = InputScore("Nhap diem toan: ");
            double ly = InputScore("Nhap diem ly: ");
            double hoa = InputScore("Nhap diem hoa: ");

            ts.setDiem(toan, ly, hoa);

            ts.setTongdiem(toan + ly + hoa);
            DS.add(ts);
        }
    }
    
    public void ShowDS(int diemchuan) {
        if(DS.isEmpty()) {
            System.out.println("Danh sach trong!");
        } else {
            System.out.println("Danh sach thi sinh: ");
            for(int i = 0; i < DS.size(); i++) {
                if(DS.get(i).getTongdiem()< 17) {
                    DS.remove(i);
                }
            }

            for(ThiSinh i : DS) {
                ShowThiSinh(i);
            }
        }
        
    }
    
    public void SapXep() {
        if(DS.isEmpty()) {
            System.out.println("Khong co danh sach!");
        } else {
            Collections.sort(DS, new Comparator<ThiSinh>() {
			public int compare(ThiSinh ts1, ThiSinh ts2) {
				if (ts1.getTongdiem()< ts2.getTongdiem()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
        } 
    }
    
    static void ShowThiSinh(ThiSinh i) {
        System.out.printf("|%-15s| %2.2f |\n", i.getTenTh(), i.getTongdiem());
    }
    
    static int NhapSoThiSinh() {
        System.out.println("Nhap so thi sinh");
        while(true) {
            try {
                Scanner scan = new Scanner(System.in);
                int temp = scan.nextInt();
                if(temp > 0) {
                    return temp;
                } else {
                    System.out.println("So thi sinh khong hop le!");
                }
            } catch(Exception e) {
                System.out.println("Dinh dang khong hop le!");
            }
            
        }
    }
    
    static String NhapTen(String mess) {
       while(true) {
            System.out.println(mess);
            Scanner scan = new Scanner(System.in);
            String word = scan.nextLine();
            Pattern p = Pattern.compile("^[A-Za-z\\s]{2,100}$");
            Matcher m = p.matcher(word);
            boolean b = m.find();
            if(b) return word.strip();
            else {
                System.out.println("Ten nhap khong hop le!");
            }
        }
    }
    
    static double InputScore(String mess){   
        while(true) {
            try {
                System.out.println(mess);
                Scanner scan = new Scanner(System.in);
                double score = scan.nextDouble();
                
                if(score < 0 || score > 10) {
                    System.out.println("Gia tri khong hop le!");
                } else {
                    return score;
                }
            } catch(Exception e) {
                System.out.println("Dinh dang khong hop le!");
            }
        }
    }
}
