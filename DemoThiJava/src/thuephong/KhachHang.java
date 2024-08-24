package thuephong;

public class KhachHang {
	private String maKH;
	private String hoTen;
	private String gioiTinh;
	private String maPhong;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public KhachHang(String maKH, String hoTen, String gioiTinh, String maPhong) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.maPhong = maPhong;
	}
	public KhachHang() {
		super();
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", maPhong=" + maPhong + "]";
	}
	
	
}
