package Run;

import Entities.GiangVien;
import Entities.Luong;
import Entities.MonHoc;
import Entities.QLGiangDay;

import java.util.Scanner;

public class Main {
    private static MonHoc[] monHocs = new MonHoc[100];
    private static GiangVien[] giangViens = new GiangVien[100];
    private static QLGiangDay[] qlGiangDays = new QLGiangDay[100];
    private static Luong[] Luongs = new Luong[100];
    private static int IndexMH = 0;
    private static int IndexGV = 0;
    private static int IndexQL = 0;
    private static int IndexLuong = 0;
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    ThemMonHoc();
                    InMonHoc();
                    break;
                case 2:
                    ThemGiangVien();
                    InGiangVien();
                    break;
                case 3:
                    ThemQLGiangDay();
                    InQLGD();
                    break;
                case 4:
                    sapXepTheoTen();
                    InQLGD();
                    break;
                case 5:
                    sapXepTheoL();
                    InQLGD();
                    break;
                case 6:
                    InLuong();
                    break;
                case 7:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Nhập danh sách môn học mới.");
        System.out.println("2. Nhập danh sách giảng viên mới.");
        System.out.println("3. Lập bảng QL giảng dạy.");
        System.out.println("4. Sắp xếp danh sách QL giảng dạy theo tên giảng viên.");
        System.out.println("5. Sắp xếp danh sách QL giảng dạy theo số tiết.");
        System.out.println("6. In bảng tính tiền công.");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void ThemMonHoc()
    {
        System.out.print("Số lượng mon hoc muốn nhập: ");
        int soluong = sc.nextInt();
        for (int i = 0; i < soluong; i++)
        {
            monHocs[IndexMH++] = MonHoc.Them(sc);
        }
    }

    private static void InMonHoc()
    {
        for(int i = 0; i <= IndexMH; i++)
        {
            if(monHocs[i] != null)
            {
                System.out.println(monHocs[i].toString());
            }
        }
    }

    private static void ThemGiangVien()
    {
        System.out.print("Số lượng giảng viên muốn nhập: ");
        int soluong = sc.nextInt();
        for (int i = 0; i < soluong; i++)
        {
            giangViens[IndexGV++] = GiangVien.Them(sc);
        }
    }

    private static void InGiangVien()
    {
        for(int i = 0; i <= IndexGV; i++)
        {
            if(giangViens[i] != null)
            {
                System.out.println(giangViens[i].toString());
            }
        }
    }

    private static MonHoc getMH(int maMH)
    {
        for(int i = 0; i <= IndexMH; i++)
        {
            if(monHocs[i] != null && monHocs[i].getMaMH() == maMH )
            {
                return monHocs[i];
            }
        }
        return null;
    }

    private static GiangVien getGV(int maMH)
    {
        for(int i = 0; i <= IndexGV; i++)
        {
            if(giangViens[i] != null && giangViens[i].getMaGV() == maMH )
            {
                return giangViens[i];
            }
        }
        return null;
    }

    private static void ThemQLGiangDay()
    {
        QLGiangDay obj = QLGiangDay.Them(sc);
        Luong luong = new Luong();
        int currentIndex = 0;
        if(getMH(obj.getMaMH()) == null || getGV(obj.getMaGV()) == null)
        {
            System.out.print("Giang vien hoac Mon hoc khong ton tai");
        }

        if(obj.getSoLop() > 3 || obj.getSoLop() < 1)
        {
            System.out.print("Số lượng lop phai lon hon 0 va khong duoc qua 3!");
        }

        for(int i = 0; i < IndexQL; i++){
            if(qlGiangDays[i].getMaGV()==obj.getMaGV() && qlGiangDays[i].getMaMH()== obj.getMaMH()){
                throw new Error("Bản ghi đã tồn tại");
            }
        }
        int time = 0;
        for(int i = 0; i < IndexQL; i++)
        {
            if(qlGiangDays[i].getMaGV()==obj.getMaGV())
            {
                time += getMH(qlGiangDays[i].getMaMH()).getTongSoTiet() * qlGiangDays[i].getSoLop();
            }
        }
        if(time > 200)
        {
            System.out.print("Số tiet khong duoc lon hon 200!");
        }
        qlGiangDays[IndexQL++] = obj;



        int IQ = IndexQL - 1;
        double oldSLR = 0;
        for(int i = 0; i < IndexLuong; i++)
        {
            if(Luongs[i] != null && Luongs[i].getIdGV() == obj.getMaGV())
            {
                luong = Luongs[i];
                currentIndex = i;
            }
        }


        luong.setName(getGV(qlGiangDays[IQ].getMaGV()).getHoTen());
        luong.setIdGV(qlGiangDays[IQ].getMaGV());
        if(luong.getSalary() != null)
        {
            oldSLR = luong.getSalary();
        }
        MonHoc mh = getMH(qlGiangDays[IQ].getMaMH());
        int solop = qlGiangDays[IQ].getSoLop();
        double KinhPhi = mh.getMucKinhPhiLT();
        int tietTH = mh.getTongSoTiet() - mh.getSoTietLyThuyet();
        int tietLT = mh.getSoTietLyThuyet();
        luong.setSalary((tietLT * KinhPhi + tietTH *(KinhPhi*(7/10)))*solop + oldSLR);

        Luongs[IndexLuong++] = luong;
    }

    private static void InQLGD()
    {
        for(int i = 0; i <= IndexQL; i++)
        {
            if(qlGiangDays[i] != null)
            {
                System.out.println(getGV(qlGiangDays[i].getMaGV()).getHoTen() + " " + getMH(qlGiangDays[i].getMaMH()).getTenMH() + " " + qlGiangDays[i].getSoLop());
            }
        }
    }

    public static void sapXepTheoTen(){
        for(int i = 0; i < IndexQL-2; i++){
            GiangVien bd = getGV(qlGiangDays[i].getMaGV());
            for(int j = i+1; j < IndexQL-1; j++){
                GiangVien bd1 = getGV(qlGiangDays[j].getMaGV());
                if(bd.getHoTen().compareToIgnoreCase(bd1.getHoTen()) > 0){
                    QLGiangDay tmp = qlGiangDays[i];
                    qlGiangDays[i] = qlGiangDays[j];
                    qlGiangDays[j] = tmp;
                }
            }
        }
    }

    public static void sapXepTheoL(){
        for(int i = 0; i < IndexQL-2; i++){
            MonHoc bd = getMH(qlGiangDays[i].getMaMH());
            for(int j = i+1; j < IndexQL-1; j++){
                MonHoc bd1 = getMH(qlGiangDays[j].getMaMH());
                if(bd.getTongSoTiet() > bd1.getTongSoTiet()){
                    QLGiangDay tmp = qlGiangDays[i];
                    qlGiangDays[i] = qlGiangDays[j];
                    qlGiangDays[j] = tmp;
                }
            }
        }
    }

    public static void InLuong()
    {
        for(int i = 0 ; i <= IndexLuong ; i++)
        {
            if(Luongs[i] != null)
            {
                System.out.println(Luongs[i].toString());
            }
        }
    }
}