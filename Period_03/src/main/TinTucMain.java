package main;

import action.TinTucAction;

public class TinTucMain {
    public static void main(String[] args) {
        TinTucAction qldm = new TinTucAction();
        System.out.println("============QUAN LY DANH MUC TIN TUC=============");
        System.out.println("1. Nhap danh sach danh muc");
        System.out.println("2. Hien thi danh sach");
        System.out.println("3. Cap nhap thong tin");
        System.out.println("4. Xoa danh muc");
        System.out.println("5. Tim kiem thong tin");
        System.out.println("#. Thoat chuong trinh");
        
        boolean check = true;
        
        while(check) {
            int select = TinTucAction.inputPossitiveInt("Nhap lua chon cua ban: ");
            switch(select) {
                case 1:
                    System.out.println("=========NHAP DANH SACH DANH MUC TIN TUC=========");
                    qldm.InsertDanhMuc();
                    break;
                case 2:
                    System.out.println("=========DANH SACH DANH MUC TIN TUC=======");
                    qldm.ShowDanhMuc();
                    break;
                case 3:
                    System.out.println("=========CAP NHAT THONG TIN=======");
                    qldm.UpdateDanhMuc();
                    break;
                case 4:
                    System.out.println("=========XOA DANH MUC TIN TUC=======");
                    qldm.DeleteDanhMuc();
                    break;
                case 5:
                    System.out.println("=========TIM KIEM THONG TIN=======");
                    qldm.SearchDanhMuc();
                    break;
                default:
                    System.out.println("Goodbye!");
                    check = false;
                    break;
            }
        }
    }
}
