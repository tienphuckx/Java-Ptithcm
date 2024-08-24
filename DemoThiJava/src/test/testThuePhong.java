package test;

import thuephong.KhachHang;
import thuephong.Phong;
import thuephong.XepPhong;

public class testThuePhong {
	public static void main(String[] args) {
		Phong phong = new Phong("p01", "VIP", 200000);
		System.out.println("=======TAO PHONG========");
		System.out.println(phong.toString());
		System.out.println();
		
		KhachHang kh = new KhachHang("kh1", "Nguyen Tien Phuc", "nam", "p01");
		System.out.println("=======TAO KHACH HANG========");
		System.out.println(kh.toString());
		System.out.println();
		
		XepPhong xepPhong = new XepPhong(kh.getHoTen(), phong.getMa(), 15, 15*200, 1);
		System.out.println("=======XEP PHONG========");
		System.out.println(xepPhong.toString());
		System.out.println();
		
		
		
	}
}
