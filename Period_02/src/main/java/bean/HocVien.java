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
public class HocVien {
    String MaHV;
    String HoTen;
    String DiaChi;
    int Tuoi;

    public HocVien() {
        this.MaHV = "None";
        this.HoTen = "None";
        this.DiaChi = "None";
        this.Tuoi = 0;
    }

    public String getMaHV() {
        return MaHV;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int Tuoi) {
        this.Tuoi = Tuoi;
    }
    
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-15s %-15d", 
                MaHV, HoTen, DiaChi, Tuoi);
    }
}
