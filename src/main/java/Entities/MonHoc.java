package Entities;

import java.util.Scanner;

public class MonHoc {
    private static int nextId = 100;
    private int maMH;
    private String tenMH;
    private int tongSoTiet;
    private int soTietLyThuyet;
    private double mucKinhPhiLT;


    public MonHoc() {

    }

    public MonHoc(String tenMH, int tongSoTiet, int soTietLyThuyet, double mucKinhPhiLT) {
        this.maMH = nextId++;
        this.tenMH = tenMH;
        this.tongSoTiet = tongSoTiet;
        this.soTietLyThuyet = soTietLyThuyet;
        this.mucKinhPhiLT = mucKinhPhiLT;
    }

    public static void setNextId(int nextId) {
        MonHoc.nextId = nextId;
    }

    public void setMaMH(int maMH) {
        this.maMH = maMH;
    }

    public void setTenMH(String tenMH) {
        this.tenMH = tenMH;
    }

    public void setTongSoTiet(int tongSoTiet) {
        this.tongSoTiet = tongSoTiet;
    }

    public void setSoTietLyThuyet(int soTietLyThuyet) {
        this.soTietLyThuyet = soTietLyThuyet;
    }

    public void setMucKinhPhiLT(double mucKinhPhiLT) {
        this.mucKinhPhiLT = mucKinhPhiLT;
    }

    public double getMucKinhPhiLT() {
        return mucKinhPhiLT;
    }

    public static int getNextId() {
        return nextId;
    }

    public int getMaMH() {
        return maMH;
    }

    public int getTongSoTiet() {
        return tongSoTiet;
    }

    public String getTenMH() {
        return tenMH;
    }

    public int getSoTietLyThuyet() {
        return soTietLyThuyet;
    }

    public static MonHoc Them(Scanner sc)
    {
        System.out.print("Nhập tên môn học: ");
        String tenMH = sc.nextLine();
        if(tenMH.equals(""))
        {
            tenMH = sc.nextLine();
        }

        System.out.print("Nhập tổng số tiết: ");
        int tongSoTiet = sc.nextInt();

        System.out.print("Nhập số tiết lý thuyết: ");
        int soTietLyThuyet = sc.nextInt();

        System.out.print("Nhập mức kinh phí lý thuyết: ");
        double mucKinhPhiLT = sc.nextDouble();

        return new MonHoc(tenMH, tongSoTiet, soTietLyThuyet, mucKinhPhiLT);
    }

    @Override
    public String toString() {
        return "maMH=" + maMH + ", tenMH='" + tenMH + ", tongSoTiet=" + tongSoTiet + ", soTietLyThuyet=" + soTietLyThuyet + ", mucKinhPhiLT=" + mucKinhPhiLT;
    }
}
