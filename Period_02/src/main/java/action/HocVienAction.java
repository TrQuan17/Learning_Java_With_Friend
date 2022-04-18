/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import bean.HocVien;
import exception.NumberException;
import exception.WordException;
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
public class HocVienAction {
    ArrayList<HocVien> listHV;
    final static String con_just_letter = "^[A-Za-z\\s]{2,100}$";
    final static String con_letter_number = "^[A-Za-z0-9\\s]{2,100}$";
    
    public HocVienAction() {
        listHV = new ArrayList<HocVien>();
    }
    
    public void NhapHocVien() {
        int n = NhapSoDuong("Nhap so hoc vien:");
        for(int i = 0; i < n; i++) {
            HocVien hv = new HocVien();
            
            hv.setMaHV(NhapChuoi("Nhap ma hoc vien", con_letter_number));
            hv.setHoTen(NhapChuoi("Nhap ho ten:", con_just_letter));
            hv.setDiaChi(NhapChuoi("Nhap dia chi:", con_letter_number));
            hv.setTuoi(NhapTuoi("Nhap tuoi:"));
            
            listHV.add(hv);
        }
    }
    
    public void HienThiHocVien() {
        for(HocVien hv : listHV) {
            System.out.println(hv.toString());
        }
    }
    
    public void TimKiemHocVien() {
        String tt = NhapChuoi("Nhap ma hoc vien tim kiem:", con_letter_number);
        HocVien hv = new HocVien();
        
        hv = TimKiem(tt, listHV);
        
        if(hv != null) {
            System.out.println("Thong tin hoc vien:");
            System.out.println(hv.toString());
        } else {
            System.out.println("Khong tim thay!");
        }
    }
    
    public void SapXepHocVien(){
        if(listHV.isEmpty()) {
            System.out.println("Danh sach trong!");
        } else {
            while(true) {
                String d = NhapChuoi("Nhap chieu sap xep du lieu:", con_just_letter);           
                try {
                    if(d.equals("DESC")) {
                        Collections.sort(listHV, new Comparator<HocVien>(){
                            @Override
                            public int compare(HocVien o1, HocVien o2) {
                                if(o1.getTuoi() < o1.getTuoi()) {
                                    return 1;
                                } else {
                                    return -1;
                                }
                            }
                        });
                        break;
                    } else if(d.equals("ASC")) {
                        Collections.sort(listHV, new Comparator<HocVien>(){
                            public int compare(HocVien o1, HocVien o2) {
                                if(o1.getTuoi() > o1.getTuoi()) {
                                    return 1;
                                } else {
                                    return -1;
                                }
                            }
                        });
                        break;
                    } else {
                        throw new WordException("Lua chon khong dung!");
                    }
                } catch(WordException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    
    public void XoaHocVien() {
        String Del = NhapChuoi("Nhap ma hoc vien can xoa:", con_letter_number);
        HocVien hv = new HocVien();
        hv = TimKiem(Del, listHV);
        
        if(listHV.remove(hv)) {
            System.out.println("Da xoa hoc vien " + hv.getMaHV());
        } else {
            System.out.println("Khong tim thay!");
        }
    }
    
    public static int NhapSoDuong(String mess) {
        System.out.println(mess);
        while(true) {
            try {
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
    
    public static int NhapTuoi(String mess) {
        while(true) {
            try {
                int age = NhapSoDuong(mess);
                if(age < 18 || age > 25) {
                    throw new NumberException("So tuoi nhap khong hop le!");
                } else {
                    return age;
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
            
        }
    }
    
    public static String NhapChuoi(String mess, String con) {
        System.out.println(mess);
        while(true) {
            try {
                Scanner scan = new Scanner(System.in);
                String str = scan.nextLine();

                Pattern p = Pattern.compile(con);
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
    
    public static HocVien TimKiem(String mahv, ArrayList<HocVien> list) {
        for(HocVien hv : list) {
            if(hv.getMaHV().toLowerCase().equals(mahv.toLowerCase())) {
                return hv;
            }
        }
        
        return null;
    }
    
    public static int Menu() {
        System.out.println("================QUAN LY HOC VIEN=================");
        System.out.println("-- 1. Nhap du lieu");
        System.out.println("-- 2. Xuat du lieu");
        System.out.println("-- 3. Tim thong tin");
        System.out.println("-- 4. Sap xep");
        System.out.println("-- 5. Xoa thong tin hoc vien");
        System.out.println("-- 6. Thoat");
        
        while(true) {
            try {
                int select = NhapSoDuong("Nhap lua chon cua ban: ");
                return select;
            } catch(Exception e) {
                System.out.println("Dinh dang nhap khong dung!");
            }
            
            
        }
    }
}
