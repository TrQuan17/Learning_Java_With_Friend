package main;

import action.HoaAction;

public class HoaMain {
    public static void main(String[] args) {
        HoaAction qlsh = new HoaAction();
        System.out.println("============QUAN LY SHOP HOA=============");
        System.out.println("1. Nhap danh sach hoa");
        System.out.println("2. Hien thi danh sach");
        System.out.println("3. Cap nhat thong tin");
        System.out.println("4. Xoa thong tin hoa");
        System.out.println("5. Tim kiem thong tin");
        System.out.println("6. Dem thong tin hoa");
        System.out.println("#. Thoat chuong trinh");
        boolean check = true;
        while(check) {
            int select = HoaAction.inputPossitiveInt("Nhap lua chon cua ban: ");
            switch(select) {
                case 1:
                    System.out.println("=========NHAP DANH SACH HOA=========");
                    qlsh.InsertHoa();
                    break;
                case 2:
                    System.out.println("=========DANH SACH LOAI HOA=======");
                    qlsh.ShowDSHoa();
                    break;
                case 3:
                    System.out.println("=========CAP NHAT THONG TIN=======");
                    qlsh.UpdateHoa();
                    break;
                case 4:
                    System.out.println("=========XOA THONG TIN HOA=======");
                    qlsh.DeleteHoa();
                    break;
                case 5:
                    System.out.println("=========TIM KIEM THONG TIN=======");
                    qlsh.SearchHoa();
                    break;
                case 6:
                    System.out.println("=========DEM THONG TIN HOA=======");
                    qlsh.CountHoa();
                    break;
                default:
                    System.out.println("Goodbye!");
                    check = false;
                    break;
            }
        }
    }
}
