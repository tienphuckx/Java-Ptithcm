package com.phuccode.docghifile.testio;

import java.util.ArrayList;

import com.phuccode.docghifile.io.TextFileFactory;
import com.phuccode.docghifile.model.KhachHang;

public class TestKhachHang {
	
	public static void testSaveFile()
	{
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		dskh.add(new KhachHang("kh01", "Nguyen Tien Phuc"));
		dskh.add(new KhachHang("kh02", "Nguyen Tien Hoang"));
		dskh.add(new KhachHang("kh03", "Nguyen Tien Tran"));
		dskh.add(new KhachHang("kh04", "Nguyen Tien Huyen"));
		
		Boolean kq = TextFileFactory.save(dskh, "f:\\phucluufile.txt");
		
		if(kq==true)
		{
			System.out.println("Luu thanh cong");
		}else {
			System.out.println("Luu that bai");
		}
	}
	
	public static void testReadFile(String path)
	{
		ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
		dskh = TextFileFactory.read(path);
		
		for(KhachHang kh:dskh)
		{
			System.out.println(kh.getMa() + " ---> " +kh.getTen() );
		}
	}


	public static void main(String[] args) {
		
//		testSaveFile();
		testReadFile("f:\\phucluufile.txt");
		
	}

}
