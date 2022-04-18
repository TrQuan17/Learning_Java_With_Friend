/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import action.HocVienAction;

/**
 *
 * @author Quan
 */
public class HocVienMain {
    public static void main(String[] args) {
        HocVienAction qlhv = new HocVienAction();
        boolean check = true;
        while(check) {
            int select = HocVienAction.Menu();
            switch(select) {
                case 1:
                    System.out.println("========NHAP DU LIEU HOC VIEN========");
                    qlhv.NhapHocVien();
                    break;
                case 2:
                    System.out.println("=======HIEN THI DU LIEU HOC VIEN======");
                    qlhv.HienThiHocVien();
                    break;
                case 3:
                    System.out.println("========TIM THONG TIN HOC VIEN=======");
                    qlhv.TimKiemHocVien();
                    break;
                case 4:
                    System.out.println("==========SAP XEP HOC VIEN===========");
                    qlhv.SapXepHocVien();
                    System.out.println("DANH SACH SAU KHI SAP XEP:");
                    qlhv.HienThiHocVien();
                    break;
                case 5:
                    System.out.println("======XOA THONG TIN HOC VIEN=========");
                    qlhv.XoaHocVien();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    check = false;
                    break;
                default:
                    System.out.println("Lua chon khong dung!");
                    break;
            }
        }
    }
}
