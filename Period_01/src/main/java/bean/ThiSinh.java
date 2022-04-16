/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Quan
 */
public class ThiSinh {
    String tenTh;
    double[] diem;
    double tongdiem;

    public ThiSinh() {
        diem = new double[3];
    }

    public String getTenTh() {
        return tenTh;
    }

    public void setTenTh(String tenTh) {
        this.tenTh = tenTh;
    }

    public double[] getDiem() {
        return diem;
    }

    public void setDiem(double... diem) {
        this.diem = diem;
    }

    public double getTongdiem() {
        return tongdiem;
    }

    public void setTongdiem(double tongdiem) {
        this.tongdiem = tongdiem;
    }
    
    
}
