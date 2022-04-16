package main;

import java.util.ArrayList;
import java.util.Scanner;

public class BT1 {
    public static void main(String[] args){
        ArrayList<Integer> list;
        int n;
        
        n = InputPossitiveInt("Nhap n:");
        list = InputArray(n);
        
        System.out.println("Tong mang :" + SumList(list));
        System.out.println("Tong dau cuoi mang: " + SumBeginEnd(list));
        
    }
    
    public static int InputInt(String mess) {
        while(true) {
            System.out.println(mess);
            try {
                Scanner scan = new Scanner(System.in);
                int n = scan.nextInt();
                return n;
            } catch(Exception e) {
                System.out.println("Dinh dang nhap khong hop le!");
            }
        }
    }
    
    public static int InputPossitiveInt(String mess){
        while(true) {
            int n = InputInt(mess);
            if(n < 0) {
                System.out.println("Gia tri nhap khong hop le!");
                continue;
            }
            return n;
        }
    }
    
    public static ArrayList<Integer> InputArray(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        System.out.println("Nhap mang: ");
        
        for(int i = 0; i < n; i++) {
            int temp = InputInt("[" + i + "] : ");
            arr.add(temp); 
        }
        
        return arr;
    }
    
    public static int SumList(ArrayList<Integer> arr) {
        int Sum = 0;
        for(int i : arr) {
            Sum += i;
        }
        return Sum;
    }
    
    public static int SumBeginEnd(ArrayList<Integer> arr) {
        return arr.get(0) + arr.get(arr.size() - 1);
    }
}


