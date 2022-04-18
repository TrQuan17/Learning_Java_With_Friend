/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import action.QuanBaiAction;
import bean.QuanBai;
import java.util.ArrayList;


/**
 *
 * @author Quan
 */
public class QuanBaiMain {
    public static void main(String[] args) {
        ArrayList<QuanBai> bobai = new ArrayList<>();
        
        System.out.println("========== BO BAI ===========");
        System.out.println("1. Nhap thong tin cac la bai: ");
        
        bobai = QuanBaiAction.inputInfo();
        
        System.out.println("2. Cac la bai vua nhap: ");
        
        QuanBaiAction.displayInfo(bobai);
        
        
    }
}
