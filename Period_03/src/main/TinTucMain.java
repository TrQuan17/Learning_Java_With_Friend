package main;

import action.TinTucAction;

public class TinTucMain {
    public static void main(String[] args) {
        TinTucAction qldm = new TinTucAction();
        System.out.println("============QUAN LY DANH MUC TIN TUC=============");
        System.out.println("1. Nhap danh sach danh muc");
        System.out.println("2. Hien thi danh sach");
        System.out.println("#. Thoat chuong trinh");
        
        while(true) {
            int select = TinTucAction.inputPossitiveInt("Nhap lua chon cua ban: ");
            if(select == 1) {
                System.out.println("=========NHAP DANH SACH DANH MUC TIN TUC=========");
                qldm.InsertDanhMuc();
            } else if(select == 2) {
                System.out.println("=========DANH SACH DANH MUC TIN TUC=======");
                qldm.ShowDanhMuc();
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
