package Entities;

import java.util.Scanner;

public class GiangVien {
    private static int nextId = 100;
    private int maGV;
    private String hoTen;
    private String diaChi;
    private String soDT;
    private String trinhDo;


    public GiangVien() {

    }


    public GiangVien(String hoTen, String diaChi, String soDT, String trinhDo) {
        this.maGV = nextId++;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.trinhDo = trinhDo;
    }

    public static void setNextId(int nextId) {
        GiangVien.nextId = nextId;
    }

    public void setMaGV(int maGV) {
        this.maGV = maGV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public String getSoDT() {
        return soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getMaGV() {
        return maGV;
    }

    public static int getNextId() {
        return nextId;
    }

    public static GiangVien Them(Scanner sc)
    {
        System.out.print("Nhập họ và tên: ");
        String hoTen = sc.nextLine();
        if(hoTen.equals(""))
        {
            hoTen = sc.nextLine();
        }

        System.out.print("Nhập địa chỉ: ");
        String diaChi = sc.nextLine();

        System.out.print("Nhập số điện thoại: ");
        String soDT = sc.nextLine();

        System.out.print("Nhập trình độ: ");
        String trinhDo = sc.nextLine();

        return new GiangVien(hoTen, diaChi, soDT, trinhDo);
    }

    @Override
    public String toString() {
        return "maGV=" + maGV + ", hoTen='" + hoTen + ", diaChi='" + diaChi + ", soDT='" + soDT + ", trinhDo='" + trinhDo;
    }
}
