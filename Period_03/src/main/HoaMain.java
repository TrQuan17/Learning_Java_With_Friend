package main;

import action.HoaAction;

public class HoaMain {
    public static void main(String[] args) {
        HoaAction qlsh = new HoaAction();
        System.out.println("============QUAN LY SHOP HOA=============");
        System.out.println("1. Nhap danh sach hoa");
        System.out.println("2. Hien thi danh sach");
        System.out.println("#. Thoat chuong trinh");
        
        while(true) {
            int select = HoaAction.inputPossitiveInt("Nhap lua chon cua ban: ");
            if(select == 1) {
                System.out.println("========= NHAP DANH SACH HOA =========");
                qlsh.InsertHoa();
            } else if(select == 2) {
                System.out.println("=========DANH SACH HOA TRONG SHOP========");
                qlsh.ShowDSHoa();
            } else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
