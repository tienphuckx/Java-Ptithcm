package com.phuccode.demo;

import java.util.Scanner;

import com.phuccode.docghifile.model.KhachHang;

public class Main {
	
	//MENU
	public static void menu()
	{
		System.out.println("1.Nhap khach hang");
		System.out.println("2.Tim khach hang");
		System.out.println("3.Xoa khach hang");
		System.out.println("4.luu khach hang");
		System.out.println("5.Xuat khach hang");
		System.out.println("6.Thoat");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Lua chon: ");
		int choose = scanner.nextInt();
		switch(choose)
		{
		case 1: nhapKhachHang();
			break;
			
		case 2: timKhachHang("key");
		break;
		
		case 3: xoaKhachHang();
		break;
		
		case 4: luuKhachHang();
		break;
		
		case 5: xuatKhachHang();
		break;
		
		case 6: thoat();
		break;
			
		default: break;
		}
	}

	

	private static void thoat() {
		System.exit(0);
		
	}



	private static void xuatKhachHang() {
		// TODO Auto-generated method stub
		
	}

	private static void luuKhachHang() {
		// TODO Auto-generated method stub
		
	}

	private static void xoaKhachHang() {
		// TODO Auto-generated method stub
		
	}

	private static void timKhachHang(String key) {
		// TODO Auto-generated method stub
//		for(KhachHang kh: dskh)
//		{
//			if(kh.getMaPhong().equals(key))
//			{
//				System.out.println(kh.getTen());
//			}
//			
//			if(kh.getMaPhong().startsWith(key))
//			{
//				System.out.println(kh.getTen());
//			}
//		}
		
	}

	private static void nhapKhachHang() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		while(true)
		{
			menu();
		}
		
	}

}
