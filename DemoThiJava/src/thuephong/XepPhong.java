package thuephong;

public class XepPhong {
	private String khachHang;
	private String maPhong;
	private int soNgayDuKien;
	private int soTienDuKien;
	private int tinhTrang;
	public String getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(String khachHang) {
		this.khachHang = khachHang;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getSoNgayDuKien() {
		return soNgayDuKien;
	}
	public void setSoNgayDuKien(int soNgayDuKien) {
		this.soNgayDuKien = soNgayDuKien;
	}
	public int getSoTienDuKien() {
		return soTienDuKien;
	}
	public void setSoTienDuKien(int soTienDuKien) {
		this.soTienDuKien = soTienDuKien;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public XepPhong(String khachHang, String maPhong, int soNgayDuKien, int soTienDuKien, int tinhTrang) {
		super();
		this.khachHang = khachHang;
		this.maPhong = maPhong;
		this.soNgayDuKien = soNgayDuKien;
		this.soTienDuKien = soTienDuKien;
		this.tinhTrang = tinhTrang;
	}
	public XepPhong() {
		super();
	}
	@Override
	public String toString() {
		return "XepPhong [khachHang=" + khachHang + ", maPhong=" + maPhong + ", soNgayDuKien=" + soNgayDuKien
				+ ", soTienDuKien=" + soTienDuKien + ", tinhTrang=" + tinhTrang + "]";
	}
	
	
	
	
}
