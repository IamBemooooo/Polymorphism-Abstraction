package Entities;

import java.util.Scanner;

public class QLGiangDay {
    private int MaGV;
    private int MaMH;
    private int SoLop;

    public QLGiangDay() {
    }

    public QLGiangDay(int maGV, int maMH, int soLop) {
        MaGV = maGV;
        MaMH = maMH;
        SoLop = soLop;
    }

    public int getSoLop() {
        return SoLop;
    }

    public int getMaMH() {
        return MaMH;
    }

    public int getMaGV() {
        return MaGV;
    }

    public void setMaGV(int maGV) {
        MaGV = maGV;
    }

    public void setSoLop(int soLop) {
        SoLop = soLop;
    }

    public void setMaMH(int maMH) {
        MaMH = maMH;
    }

    public static QLGiangDay Them(Scanner sc)
    {
        System.out.println("\nNhập thông tin giảng dạy:");

        System.out.print("Mã giảng viên: ");
        int MaGV = sc.nextInt();

        System.out.print("Mã môn học: ");
        int MaMH = sc.nextInt();

        System.out.print("Số lớp: ");
        int SoLop = sc.nextInt();

        return  new QLGiangDay(MaGV,MaMH,SoLop);
    }

    @Override
    public String toString() {
        return "MaGV=" + MaGV + ", MaMH=" + MaMH + ", SoLop=" + SoLop;
    }
}
