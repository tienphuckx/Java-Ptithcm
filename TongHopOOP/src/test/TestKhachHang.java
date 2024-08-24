package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import io.SerializableFileFactory;
import model.KhachHang;

public class TestKhachHang {
	
	public static ArrayList<KhachHang>dsKH= new ArrayList<KhachHang>();
	
	public static void menu()
	{
		
		System.out.println("	1--> Nhập khách hàng.");
		System.out.println("	2--> Xuất xuất dữ liệu trong RAM.");
		System.out.println("	3--> Tìm kiếm khách hàng.");
		System.out.println("	4--> Sắp xếp khách hàng.");
		System.out.println("	5--> Lưu dữ liệu vào ổ cứng.");
		System.out.println("	6--> Đọc dữ liệu từ ổ cứng lên RAM.");
		System.out.println("	7--> Thống kê theo nhà mạng : Bao nhiêu khách hàng dùng SĐT mobi ?(090)");
		System.out.println("	8--> Thoát");
		int chon=0;
		System.out.println("INPUT YOUR CHOISE:");
		chon=new Scanner(System.in).nextInt();
		switch(chon)
		{
			case 1:
			{
				xu_ly_nhap();
				break;
			}
			
			case 2:
			{
				xu_ly_xuat();
				break;
			}
			case 3:
			{
				tim_kiem_khach_hang();
				break;
			}
			case 4:
			{
				sap_xep_khach_hang();
				break;
			}
			case 5:
			{
				luu_khach_hang();
				break;
			}
			case 6:
			{
				doc_khach_hang();
				break;
			}
			case 7:
			{
				thong_ke();
				break;
			}
			case 8:
			{
				thoat();
				break;
			}
			
			default:
				break;
		}
	}

	private static void thoat() {
		System.out.println("CẢM ƠN BẠN ĐÃ DÙNG PHẦN MỀM ! bai bai love you");
		System.exit(0);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	private static void thong_ke() 
	{
		int n = 0;
		for(KhachHang kh: dsKH)
		{
			if(kh.getKh_sdt().startsWith("090"))
			{
				n++;
			}		
		}
		System.out.println("Có "+ n + " Khách hàng MOBI.");
		
	}

	private static void doc_khach_hang() {
		dsKH = SerializableFileFactory.docFile("F:\\du_lieu_khach_hang.txt");
		System.out.println("Đọc file thành công !");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
	}

	private static void luu_khach_hang() {
		boolean result = SerializableFileFactory.luuFile(dsKH, "F:\\du_lieu_khach_hang.txt");
		if(result==true) {
			System.out.println("Đã lưu file thành công !");
		}else {
			System.out.println("Lưu thất bại");
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
	}

	private static void sap_xep_khach_hang() {
		Collections.sort(dsKH);
		System.out.println("Đã sắp xếp SĐT thành công !");
		
	}

	private static void tim_kiem_khach_hang() {
		String phone = "090";
		System.out.println("============================");
		System.out.println("Khách hàng có đầu số 090 :");
		
		for(KhachHang kh: dsKH)
		{
			if(kh.getKh_sdt().startsWith(phone))
			{
				System.out.println(kh);
			}
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		
	}

	private static void xu_ly_xuat() {
		System.out.println("=============================");
		System.out.println("Mã\t Tên\t SĐT");
		for(KhachHang kh:dsKH)
		{
			System.out.println(kh);
		}
		System.out.println("=============================");
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	private static void xu_ly_nhap() 
	{
		KhachHang kh = new KhachHang();
		
		System.out.println("--> Nhập mã :");
		int kh_ma = new Scanner(System.in).nextInt();
		
		System.out.println("--> Nhập tên :");
		String kh_ten = new Scanner(System.in).nextLine();
		
		System.out.println("--> Nhập SĐT :");
		String kh_sdt = new Scanner(System.in).nextLine();
		
		kh.setKh_ma(kh_ma);
		kh.setKh_ten(kh_ten);
		kh.setKh_sdt(kh_sdt);
		
		dsKH.add(kh);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	public static void main(String[] args) {
		// VÒNG LẶP VĨNH CỬU
		while(true)
		{
			menu();
		}

	}

}
