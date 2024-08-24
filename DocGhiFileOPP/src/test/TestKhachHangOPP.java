package test;

import java.util.ArrayList;

import io.SerializableFileFactory;
import io.TextFileFactory;
import model.KhachHang;

public class TestKhachHangOPP {
	public static void testLuuFile()

	{
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		
		dsKH.add(new KhachHang("KH01", "Nguyen Tien Phuc"));
		dsKH.add(new KhachHang("KH02", "Nguyen Tien Hoang"));
		dsKH.add(new KhachHang("KH03", "Nguyen Tien Vu"));
		dsKH.add(new KhachHang("KH04", "Nguyen Tien Vuong"));
		dsKH.add(new KhachHang("KH05", "Nguyen Tien Huyen"));
		
		boolean kt = SerializableFileFactory.luuFile(dsKH, "d:\\saveFileOOP.txt");
		
		if(kt==true) {
			System.out.println("Luu file thanh cong !");
		}else {
			System.out.println("Luu file that bai !");
		}
	}
	
	public static void main(String[] args) {
//		System.out.println("Save file oop : ");
//		testLuuFile();
		
		System.out.println("Doc file oop :");
		ArrayList<KhachHang> dsKH = SerializableFileFactory.docFile("d:\\saveFileOOP.txt");
		
		System.out.println("DANH SACH KHACH HANG : ");
		System.out.println("Ma:\tTen: ");
		for(KhachHang kh: dsKH)
		{
			System.out.println(kh);
		}
	}
}
