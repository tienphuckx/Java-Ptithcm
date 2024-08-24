package Tool;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static void menuBanner() 
    {
        System.out.println("\n===================== TOOL GIAU TIN VAO FILE TEXT =====================");
        System.out.println("Chon 0 - de giau tin");
        System.out.println("Chon 1 - de giai ma tin");
        System.out.println();
    }

    private static void giauTinBanner() 
    {
        System.out.println("\n===================== GIAU TIN VAO FILE TEXT =====================");
        System.out.println();
    }

    private static void giaiMaTinBanner() 
    {
        System.out.println("\n===================== GIAI MA THONG DIEP =====================");
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        menuBanner();
        System.out.print("Nhap lua chon cua ban: ");
        int luaChon = Integer.parseInt(scanner.nextLine());

        if (luaChon == 0) {
            // thuc hien tinh nang giau tin
            giauTinBanner();
            System.out.print("Nhap noi dung tin giau: ");
            String tinGiau = scanner.nextLine();
            System.out.print("Nhap duong dan den file can giau tin: ");
            String duongDanGiauTin = scanner.nextLine();

            GiauTin.giauTin(tinGiau, Paths.get(duongDanGiauTin));
        } else if (luaChon == 1) {
            // thuc hien tinh nang khoi phuc tin giau
            giaiMaTinBanner();
            System.out.print("Nhap duong dan den file can xem tin giau: ");
            String duongDanKhoiPhuc = scanner.nextLine();
            String tinGiau = KhoiPhuc.khoiPhuc(Paths.get(duongDanKhoiPhuc));

            System.out.println("=========> Tin bi giau la: " + tinGiau);
        } else {
            System.out.println("Nhap sai roi! 0 hoac 1 thoi!");
        }
    }
}
