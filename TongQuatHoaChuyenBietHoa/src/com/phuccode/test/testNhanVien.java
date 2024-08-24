package com.phuccode.test;

import com.phuccode.NhanVien;
import com.phuccode.NhanVienChinhThuc;
import com.phuccode.NhanVienThoiVu;

public class testNhanVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NhanVien nvct = new NhanVienChinhThuc();
		nvct.setTen("Nguyen Tien Teo");
		nvct.setCmnd("123456789");
		System.out.println(nvct.toString());
		
		nvct = new NhanVienThoiVu();
		nvct.setTen("Nguyen Tien Teo");
		System.out.println(nvct.toString());
		
		// CUNG 1 bien teo nhung thay doi ==> ĐA HÌNH
		
	}

}
