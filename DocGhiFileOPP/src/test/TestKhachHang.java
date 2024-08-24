package test;

import java.util.ArrayList;

import model.*;
import io.TextFileFactory;

public class TestKhachHang {
	
	public static void testLuuFile()

	{
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		
		dsKH.add(new KhachHang("KH01", "Nguyen Tien Phuc"));
		dsKH.add(new KhachHang("KH02", "Nguyen Tien Hoang"));
		dsKH.add(new KhachHang("KH03", "Nguyen Tien Vu"));
		dsKH.add(new KhachHang("KH04", "Nguyen Tien Vuong"));
		dsKH.add(new KhachHang("KH05", "Nguyen Tien Huyen"));
		
		boolean kt = TextFileFactory.luuFile(dsKH, "d:\\testData.txt");
		if(kt==true) {
			System.out.println("Luu file thanh cong !");
		}else {
			System.out.println("Luu file that bai !");
		}
	}
	
	
	public static void main(String[] args) 
	{
		testLuuFile();
		
		ArrayList<KhachHang> dsKH = TextFileFactory.docFile("d:\\testData.txt");
		
		System.out.println("DANH SACH KHACH HANG : ");
		System.out.println("Ma:\tTen: ");
		for(KhachHang kh: dsKH)
		{
			System.out.println(kh);
		}
	}
}
