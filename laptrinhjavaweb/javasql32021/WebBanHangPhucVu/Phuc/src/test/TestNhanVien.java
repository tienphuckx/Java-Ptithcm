package test;

public class TestNhanVien {

	public static void main(String[] args) {
		NhanVien teo = new NhanVienChinhThuc();
		teo.setTen("Nguyen Tien Phuc");
		
		System.out.println(teo.getTen());
		System.out.println(teo.xuatLuong());
	}

}
